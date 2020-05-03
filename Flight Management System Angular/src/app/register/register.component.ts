import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { UserserviceService } from '../userservice.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  
  successMessage:String;
  errorMessage:String;
  
  id:number;
  password:string;
  invalidLogin = false

  checkUser:User = new User();
  usr:User = new User();
  
  constructor(private router:Router, public userserv:UserserviceService) { }

  ngOnInit(): void {
  }
  
  checkLogin() {
    
    this.userserv.findData(this.id).subscribe(data=>
      {
        this.checkUser = data;
       
        if(this.checkUser.userId != null)
        {
          if(this.userserv.authenticate(this.password,this.checkUser))
        {
          alert("logged in")
          this.router.navigate([''])
          this.invalidLogin = false;
        }
        else
        {
          this.invalidLogin=true;
        }
          
        }
        
    },
    error=>
    {
      console.log("error occured",error);
      alert("User does not exist");
    }
    );
  }

addUser():void
{
  this.userserv.addData(this.usr).subscribe(data=>
    {
      this.successMessage=data;
      this.errorMessage=undefined
    },
    error=>
    {      
        this.errorMessage=JSON.parse(error.error).message;
        console.log(error.error);
        this.successMessage=undefined
    }
    );
}
}

