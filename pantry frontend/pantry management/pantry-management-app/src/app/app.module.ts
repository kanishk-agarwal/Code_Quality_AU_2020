import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClientModule} from '@angular/common/http'
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { NewUserRegistrationComponent } from './new-user-registration/new-user-registration.component';
import { UserDetailsComponent } from './user-details/user-details.component';
import { AddItemComponent } from './add-item/add-item.component';
import { BuyItemComponent } from './buy-item/buy-item.component';
import { ViewItemsBoughtComponent } from './view-items-bought/view-items-bought.component';
import { UpdateItemComponent } from './update-item/update-item.component';
import { DeleteItemComponent } from './delete-item/delete-item.component';
@NgModule({
  declarations: [
    AppComponent,
    NewUserRegistrationComponent,
    UserDetailsComponent,
    AddItemComponent,
    BuyItemComponent,
    ViewItemsBoughtComponent,
    UpdateItemComponent,
    DeleteItemComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
