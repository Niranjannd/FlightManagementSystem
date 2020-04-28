import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ViewuserComponent } from './viewuser/viewuser.component';
import { FinduserComponent } from './finduser/finduser.component';
import { UpdateuserComponent } from './updateuser/updateuser.component';
import { DeleteuserComponent } from './deleteuser/deleteuser.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RegisterComponent } from './register/register.component';

@NgModule({
  declarations: [
    AppComponent,
    ViewuserComponent,
    FinduserComponent,
    UpdateuserComponent,
    DeleteuserComponent,
    RegisterComponent,
  
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
