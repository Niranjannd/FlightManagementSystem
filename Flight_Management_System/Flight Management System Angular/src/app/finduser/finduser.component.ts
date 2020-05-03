import { Component, OnInit, ViewChild } from '@angular/core';
import { User } from '../user';
import { UserserviceService } from '../userservice.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-finduser',
  templateUrl: './finduser.component.html',
  styleUrls: ['./finduser.component.css']
})
export class FinduserComponent implements OnInit {

finduser:User = new User();
fid:number;

successMessage:string;
errorMessage:string;

  constructor(private userserv:UserserviceService) { }

  ngOnInit(): void {
  }
searchData():void

{

  this.userserv.findData(this.fid).subscribe((data)=>
    {
    this.finduser=data
    this.successMessage=data;
    this.errorMessage=undefined
    },
    error=>
    {
      alert(this.errorMessage);
      this.errorMessage=JSON.parse(error.error).message;
      console.log(error.error);
      this.successMessage=undefined
    }
    

    );
  
}
}