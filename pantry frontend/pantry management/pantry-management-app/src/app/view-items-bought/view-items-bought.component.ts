import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Router,ActivatedRoute } from "@angular/router";

export interface Item{
  itemId: number;
  name: string;
  quantity_available:number;
  quantity_sold: number;
}
@Component({
  selector: 'app-view-items-bought',
  templateUrl: './view-items-bought.component.html',
  styleUrls: ['./view-items-bought.component.css']
})
export class ViewItemsBoughtComponent implements OnInit {
  http:HttpClient;
  items:Item[];
  route:ActivatedRoute;
  router:Router;
  username:string;
  notBought: Boolean;
  constructor(http:HttpClient,route:ActivatedRoute,router:Router) { 
    this.http=http;
    this.router=router;
    this.route=route;
  }
  ngOnInit() {
    if(localStorage.getItem("isLoggedIn")=="true"){
      this.username=localStorage.getItem("username");
      this.listItems();
  }
   else{
      this.router.navigate(['./login']);
   } 
    
  }
  listItems(){
    this.http.get<Item[]>('http://localhost:8090/last30DaysItems/'+this.username).subscribe((data)=>{
          if(data==null){
            this.notBought=true;
          }
          this.items=data;
          console.log(this.items);
      });
  }

}
