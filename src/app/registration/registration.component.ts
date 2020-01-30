import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { UserRegistrationService } from '../user-registration.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit
 {

   user: User = new User("","",0,"");
   msg:any;

  constructor(private service:UserRegistrationService) { }

  ngOnInit() {
  }


  public registerNow()
   {
       let response=  this.service.doRegister(this.user);
       response.subscribe((data) => this.msg = data);
   }
}
