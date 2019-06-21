import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../services';
import { IUser } from '../services/User';
import { Subscription, Observable, of } from 'rxjs';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  subscription: Subscription;
  currentUser: IUser;
  bannerImage = 'assets/Cool-Cat-Cropped.jpg';

  constructor(private userService: AuthenticationService) {
  }

  ngOnInit() {
    this.getUser();
  }

  getUser(): void {
    this.subscription = this.userService.currentUser.subscribe(user => {
      if (user) {
        this.currentUser = user;
      } else {
        this.currentUser = null;
      }
      console.log(this.currentUser);
    });
  }

}
