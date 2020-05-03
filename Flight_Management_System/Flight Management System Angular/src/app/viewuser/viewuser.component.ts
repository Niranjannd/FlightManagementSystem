import { Component, OnInit } from '@angular/core';
import { UserserviceService } from '../userservice.service';
import { User } from '../user';

@Component({
  selector: 'app-viewuser',
  templateUrl: './viewuser.component.html',
  styleUrls: ['./viewuser.component.css']
})
export class ViewuserComponent implements OnInit {

  users:User[]=[];
  constructor(private userserv:UserserviceService) { }

  ngOnInit(): void {
    this.userserv.viewData().subscribe(data=>this.users=data);

  }

}
