import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
export interface Item{
  itemId: number;
  name: string;
  quantity_available:number;
  quantity_sold: number;
}
@Component({
  selector: 'app-delete-item',
  templateUrl: './delete-item.component.html',
  styleUrls: ['./delete-item.component.css']
})
export class DeleteItemComponent implements OnInit {
  http:HttpClient;
  items:Item[];
  item_id:number;
  quantity:number;
  itemDeleted:Boolean;
  clicked: Boolean;
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
  deleteItem(){
    this.clicked=true;
    this.http.delete<Boolean>("http://localhost:8090/deleteItem/"+this.item_id).subscribe((data)=>{
        this.itemDeleted=data;
        if(data==true){
          this.ngOnInit();
        }
    })
  }
}
