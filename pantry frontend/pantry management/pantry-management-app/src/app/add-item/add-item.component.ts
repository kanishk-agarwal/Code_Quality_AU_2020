import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-item',
  templateUrl: './add-item.component.html',
  styleUrls: ['./add-item.component.css']
})
export class AddItemComponent implements OnInit {
  itemID: number;
  name: string;
  quantity: number;
  http: HttpClient;
  itemAdded: Boolean;
  clicked: Boolean;
  router: Router;
  constructor(http:HttpClient,router:Router) {
      this.http=http;
      this.router=router;
  }
  ngOnInit() {
    if(localStorage.getItem("isLoggedIn")=="false"){
      this.router.navigate(['./login']);
   } 
  }
  addItem(){
      var item={
        itemID: this.itemID,
        name: this.name,
        quantity_available: this.quantity
      }
      this.clicked=true;
      this.http.post<Boolean>('http://localhost:8090/addItem',item).subscribe((data)=>{
          this.itemAdded=data;
      });
  }
}
