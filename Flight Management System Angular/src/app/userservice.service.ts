import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class UserserviceService {

  constructor(private http:HttpClient) { }

  authenticate(password:string, checkUser:User) 
  {
    if (checkUser.userPassword == password) 
    {
      sessionStorage.setItem('data',JSON.stringify(checkUser));
      return true;
    } 
    else 
    {
      alert("wrong password")
      return false;
    }
    
  }

  
  isUserLoggedIn() 
  {
    let user = JSON.parse(sessionStorage.getItem('data'));
    console.log(!(user == null));
    return !(user == null)
    
  }

  logOut()
  {
    sessionStorage.removeItem('data')
  }
  
  getUser():User
  {
    let user = JSON.parse(sessionStorage.getItem('data'))
    return user;
  }


  isAdmin():boolean
  {
    let userr = JSON.parse(sessionStorage.getItem('data'))
    if(userr.userType == "admin")
    {
      return true;
    }
    else
    return false;
  }
  isCustomer():boolean
  {
    let userr = JSON.parse(sessionStorage.getItem('data'))
    if(userr.userType == "customer")
    {
      return true;
    }
    else
    return false;
  }

  viewData():Observable<any>
  {
    let url="http://localhost:2026/user";
    return this.http.get(url);
  }

  addData(user:User):Observable<any>
  {
  let url="http://localhost:2026/user/new";
  return this.http.post(url,user,{responseType:'text'});
  }

  findData(id:number):Observable<any>
  {
    let url="http://localhost:2026/user/"+id;
    return this.http.get(url);
  }

  deleteData(id:number):Observable<any>
  {

    let url="http://localhost:2026/user/delete/"+id;
    return this.http.delete(url,{responseType:'text'});
  }

  updateData(user:User):Observable<any>
  {
    let url="http://localhost:2026/user/update/";
    return this.http.put(url,user,{responseType:'text'});
  }
}
