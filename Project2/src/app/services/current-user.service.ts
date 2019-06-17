import { Injectable } from '@angular/core';
import { IUser } from './User';

@Injectable()
export class CurrentUserService {
  private currentUser: IUser;
  constructor() { }

  setCurrentUser(user: IUser) {
    this.currentUser = user;
  }

  getCurrentUser() {
    return this.currentUser;
  }
}
