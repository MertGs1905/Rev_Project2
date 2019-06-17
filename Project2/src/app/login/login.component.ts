import { Component, OnInit } from '@angular/core';
import { CurrentUserService } from '../services/current-user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  email = '';
  password = '';

  constructor(private login: CurrentUserService) { }

  ngOnInit() {
  }

}
