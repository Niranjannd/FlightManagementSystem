import { Component, OnInit } from '@angular/core';
import { UserserviceService } from '../userservice.service';
import { User } from '../user';

@Component({
  selector: 'app-deleteuser',
  templateUrl: './deleteuser.component.html',
  styleUrls: ['./deleteuser.component.css']
})
export class DeleteuserComponent implements OnInit {

  message:string;
  finduser:User;
  fid:number;
  constructor(private userserv:UserserviceService) { }

  ngOnInit(): void {
  }
searchData():void
{
  this.userserv.findData(this.fid).subscribe(data=>
    {
    this.finduser=data
    },
    error=>
    {
    if(this.finduser!=null)
    {
    this.message.concat("Id not found.");
    alert(this.message)
    }
  });
  
}
deleteData():void
{
  this.userserv.deleteData(this.fid).subscribe(data=>
    {
      alert("User Deleted.")   
    }   
    );
}
}
