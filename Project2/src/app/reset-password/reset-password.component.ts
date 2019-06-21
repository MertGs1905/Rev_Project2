import { Component, OnInit } from '@angular/core';
import { IUser } from '../services/User';
import { CurrentUserService } from '../services/current-user.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

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
  passwordForm: FormGroup;

  constructor(private resetpass: CurrentUserService,
              private formBuilder: FormBuilder,
              private http: HttpClient) { }

  ngOnInit() {
    this.passwordForm = this.formBuilder.group({
      email: ['', Validators.required]
  });
  }

  forgetpass() {
    this.user = {
      email: this.email,
      password: this.password,
      username: this.username
    };


  }

}
