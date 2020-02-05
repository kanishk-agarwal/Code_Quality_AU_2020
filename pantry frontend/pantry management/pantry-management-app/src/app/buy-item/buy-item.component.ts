import { Component, OnInit, SystemJsNgModuleLoader } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
export interface Item{
  itemId: number;
  name: string;
  quantity_available:number;
  quantity_sold: number;
}
@Component({
  selector: 'app-buy-item',
  templateUrl: './buy-item.component.html',
  styleUrls: ['./buy-item.component.css']
})
export class BuyItemComponent implements OnInit {
  http: HttpClient;
  items:Item[]=new Array();
  itemID:number;
  quantity:number;
  boughtItem:Boolean;
  clicked:Boolean;
  router:Router;
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
  buyItem(){
    this.clicked=true;
    let buy={
      username: localStorage.getItem('username'),
      itemId: this.itemID,
      quantity_bought:this.quantity
    }
    console.log(this.itemID);
    this.http.post<Boolean>('http://localhost:8090/buyItem',buy).subscribe((data)=>{
            this.boughtItem=data;
    });
  }
}
