import { Component, OnInit } from '@angular/core';
import { CurrentUserService } from '../services/current-user.service';
import { IUser } from '../services/User';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  private user: IUser;
  email = '';
  username = '';
  password = '';
  constructor(private userService: CurrentUserService) { }

  ngOnInit() {
  }

  registerUser() {
    this.user = {
      email: this.email,
      username: this.username,
      password: this.password
    };

    this.userService.setCurrentUser(this.user);
  }
}
