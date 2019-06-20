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

<<<<<<< HEAD
    this.userService.login(this.user);
=======
    // this.userService.setCurrentUser(this.user);
>>>>>>> ed5bdef0bb2ddc5cbc3db242b0f961ae7d1d29d1
  }
}
