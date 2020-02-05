import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { NewUserRegistrationComponent } from './new-user-registration/new-user-registration.component';
import { UserDetailsComponent } from './user-details/user-details.component';
import { AddItemComponent } from './add-item/add-item.component';
import { BuyItemComponent } from './buy-item/buy-item.component';
import { ViewItemsBoughtComponent } from './view-items-bought/view-items-bought.component';
import { UpdateItemComponent } from './update-item/update-item.component';
import { DeleteItemComponent } from './delete-item/delete-item.component';
const routes: Routes = [
  {
    path:'registerUser',
    component: NewUserRegistrationComponent
  },
  {
    path: 'login',
    component: AppComponent
  },
  {
    path:'userDetails/:username',
    component: UserDetailsComponent
  },
  {
    path:'addItem',
    component: AddItemComponent
  },
  {
    path:'buyItem',
    component: BuyItemComponent
  },
  {
    path:'viewItemsBought',
    component: ViewItemsBoughtComponent
  },
  {
    path:'updateItem',
    component: UpdateItemComponent
  },
  {
    path:'deleteItem',
    component: DeleteItemComponent
  },
  // {
  //   path:'/',
  //   component: AppComponent
  // }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
