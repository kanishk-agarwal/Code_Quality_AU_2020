import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Router,ActivatedRoute } from "@angular/router";
export interface User{
  id: number;
  name: string;
  username: string;
  doj: Date;
}
@Component({
  selector: 'app-user-details',
  templateUrl: './user-details.component.html',
  styleUrls: ['./user-details.component.css']
})

export class UserDetailsComponent implements OnInit {
  http:HttpClient;
  username: string;
  router: Router;
  userID:number;
  name: string;
  DOJ: Date;
  route: ActivatedRoute;
  constructor(http:HttpClient, router: Router,route:ActivatedRoute) {
    this.http=http;
    this.router=router;
    this.route=route;
   }

  ngOnInit() {
    if(localStorage.getItem("isLoggedIn")=="true"){
        this.username=localStorage.getItem("username");
        this.viewUserDetails();
    }
     else{
        this.router.navigate(['./login']);
     } 
  }
  viewUserDetails(){
    this.http.get<User>('http://localhost:8090/userDetails/'+this.username).subscribe((data)=>{    
        this.userID=data.id;
        this.name=data.name;
        this.DOJ=data.doj;
  });
}
}
