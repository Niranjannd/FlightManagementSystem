import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ViewuserComponent } from './viewuser/viewuser.component';
import { FinduserComponent } from './finduser/finduser.component';
import { UpdateuserComponent } from './updateuser/updateuser.component';
import { DeleteuserComponent } from './deleteuser/deleteuser.component';
import { RegisterComponent } from './register/register.component';


const routes: Routes = [
{path:'register',component:RegisterComponent}, 
{path:'view',component:ViewuserComponent},
{path:'find',component:FinduserComponent},
{path:'update',component:UpdateuserComponent},
{path:'delete',component:DeleteuserComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
