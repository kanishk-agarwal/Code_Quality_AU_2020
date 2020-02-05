import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Router} from  "@angular/router";
export interface Item{
  itemId: number;
  name: string;
  quantity_available:number;
  quantity_sold: number;
}
@Component({
  selector: 'app-update-item',
  templateUrl: './update-item.component.html',
  styleUrls: ['./update-item.component.css']
})
export class UpdateItemComponent implements OnInit {
  http:HttpClient;
  router:Router;
  items:Item[];
  item_id:number;
  quantity:number;
  valueUpdated:Boolean;
  clicked: Boolean;
  constructor(http:HttpClient,router:Router) {
      this.http=http;
      this.router=router;
   }

  ngOnInit() {
    if(localStorage.getItem("isLoggedIn")=="true"){
      this.listItems();
  }
   else{
      this.router.navigate(['./login']);
   } 
  }
  listItems(){
    this.http.get<Item[]>('http://localhost:8090/getAllAvailableItems').subscribe((data)=>{
        this.items=data;
    });
  }
  updateItem(){
    let update={
      item_id: this.item_id,
      quantity: this.quantity
    }
    this.clicked=true;
    this.http.post<Boolean>('http://localhost:8090/updateItem',update).subscribe((data)=>{
        this.valueUpdated=data;
    });
    this.ngOnInit();
  }
}
