import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../services/authentication.service';
import { IUser } from '../services/User';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  user: IUser;
  email = '';
  username = '';
  password = '';
  constructor(private userService: AuthenticationService) { }

  ngOnInit() {
  }

  registerUser() {
    this.user = {
      email: this.email,
      username: this.username,
      password: this.password
    };

    // this.userService.setCurrentUser(this.user);
  }
}
