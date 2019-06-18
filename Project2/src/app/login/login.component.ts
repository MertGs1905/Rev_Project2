import { Component, OnInit } from '@angular/core';
import { CurrentUserService } from '../services/current-user.service';
import { IUser } from '../services/User';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  private user: IUser;
  email = '';
  password = '';
  username = '';

  constructor(private login: CurrentUserService) { }

  ngOnInit() {
  }

  getUser() {
    this.user = {
      email: this.email,
      password: this.password,
      username: this.username
    };

    this.login.setCurrentUser(this.user);

  }

}
