import { Component, OnInit, OnDestroy } from '@angular/core';
import { IUser } from '../services/User';
import { CurrentUserService } from '../services/current-user.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-usercard',
  templateUrl: './usercard.component.html',
  styleUrls: ['./usercard.component.css']
})
export class UsercardComponent implements OnInit, OnDestroy {
  subscription: Subscription;
  currentUser: IUser;
  constructor(private userService: CurrentUserService) {
    this.subscription = this.userService.getCurrentUser().subscribe(user => {
      if (user) {
        this.currentUser = user;
      } else {
        this.currentUser = null;
      }
      console.log(this.currentUser);
    });
  }

  ngOnInit() {
  }

  ngOnDestroy() {
    // unsubscribe to ensure no memory leaks
    this.subscription.unsubscribe();
  }

}
