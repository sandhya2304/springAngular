import { Component, OnInit } from '@angular/core';
import { UserRegistrationService } from '../user-registration.service';


@Component({
  selector: 'app-search-delete',
  templateUrl: './search-delete.component.html',
  styleUrls: ['./search-delete.component.css']
})
export class SearchDeleteComponent implements OnInit
 {

users:any;
email:string;

  constructor(private service:UserRegistrationService) { }

public deleteUsers(id:number)
{
	let resp = this.service.deleteUser(id);
      resp.subscribe((data) => this.users = data);
}

public findByEmail()
{
      let resp = this.service.getUsersByEmail(this.email);
      resp.subscribe((data) => this.users = data);
}


  ngOnInit()
  {
      let resp = this.service.getUsers();
      resp.subscribe((data) => this.users = data);

  }

}
