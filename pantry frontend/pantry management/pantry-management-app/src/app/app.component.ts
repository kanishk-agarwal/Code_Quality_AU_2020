import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Router,ActivatedRoute } from "@angular/router";
import { ThrowStmt } from '@angular/compiler';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'pantry-management-app';
  username: string;
  password: string;
  http:HttpClient;
  validUser: Boolean;
  loginClicked: Boolean;
  router: Router;
  logoutClicked: boolean;
  ngOnInit(){
  }
  constructor(http: HttpClient, router: Router){
    this.http=http;
    this.router=router;
  }
  validateUser(){
    const loginDetails={
      username: this.username,
      password: this.password
    };
    this.loginClicked=true;
    this.http.post<Boolean>('http://localhost:8090/login',loginDetails).subscribe((data)=>{    
        this.validUser=data;
        if(this.validUser==true){
          localStorage.setItem("isLoggedIn","true");
          localStorage.setItem("username",this.username);
          this.router.navigateByUrl('/userDetails/'+this.username);
        }
    });

  }
  isLoggedIn():Boolean{
    if(localStorage.getItem("isLoggedIn")=="true"){
      return true;
    }
    return false;
  }
  goToSignUp(){
    this.router.navigateByUrl('/registerUser');
  }
  goToUserDetails(){
    this.router.navigateByUrl('/userDetails/'+this.username);
  }
  goTobuyItemPage(){
    this.router.navigateByUrl('/buyItem');
  }
  goToViewItemsBoughtPage(){
    this.router.navigateByUrl('/viewItemsBought');
  }
  goToAddItemPage(){
    this.router.navigateByUrl('/addItem');
  }
  goToUpdateItemPage(){
    this.router.navigateByUrl('/updateItem');
  }
  goToDeleteItemPage(){
    this.router.navigateByUrl('/deleteItem')
  }
  logout(){
    localStorage.setItem("isLoggedIn","false");
    localStorage.setItem("username","");
    this.ngOnInit();
    this.logoutClicked=true;
  }
}
