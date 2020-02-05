import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-new-user-registration',
  templateUrl: './new-user-registration.component.html',
  styleUrls: ['./new-user-registration.component.css']
})
export class NewUserRegistrationComponent implements OnInit {
  http: HttpClient
  name: String;
  username: String;
  password: String;
  userRegistered: Boolean;
  registerClicked: Boolean;
  constructor(http: HttpClient) {
    this.http=http;
   }

  ngOnInit() {
  }
  registerUser(){
    this.registerClicked=true;
    let newUserDetails={
      "name": this.name,
      "username": this.username,
      "password": this.password
    };
    this.http.post<Boolean>('http://localhost:8090/addUser',newUserDetails).subscribe((data)=>{    
        this.userRegistered=data;
        console.log(this.userRegistered);
    });
  }
}
