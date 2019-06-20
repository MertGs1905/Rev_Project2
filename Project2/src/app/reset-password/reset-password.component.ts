import { Component, OnInit } from '@angular/core';
import { IUser } from '../services/User';
import { CurrentUserService } from '../services/current-user.service';

@Component({
  selector: 'app-reset-password',
  templateUrl: './reset-password.component.html',
  styleUrls: ['./reset-password.component.css']
})
export class ResetPasswordComponent implements OnInit {
  private user: IUser;
  email = '';
  password = '';
  username = '';

  constructor(private resetpass: CurrentUserService) { }

  ngOnInit() {
  }

  forgetpass(){
    this.user = {
      email: this.email,
      password: this.password,
      username: this.username
    };


  }

}
