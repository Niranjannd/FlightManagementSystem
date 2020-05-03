import { Component, OnInit } from '@angular/core';
import { UserserviceService } from '../userservice.service';
import { User } from '../user';

@Component({
  selector: 'app-updateuser',
  templateUrl: './updateuser.component.html',
  styleUrls: ['./updateuser.component.css']
})
export class UpdateuserComponent implements OnInit {

fid:number;
updateduser:User =  new User();

  constructor(private userserv:UserserviceService) { }

  ngOnInit(): void {
  }

  searchData():void
  {
    this.userserv.findData(this.fid).subscribe(data=>this.updateduser=data);
  }

  updateData():void
  {
    alert(this.updateduser.userName);
    alert(this.updateduser.userId);

    this.userserv.updateData(this.updateduser).subscribe(data=>
      {
        alert("User updated");
      },
        error=>
      {
        console.log("There is some error.",error);
      }
      );
  }



}
