import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { IUser } from './User';

@Injectable()
export class CurrentUserService {
  private currentUser: IUser;
  constructor() { }

  setCurrentUser(user: IUser) {
    this.currentUser = user;
  }

  getCurrentUser(): Observable<IUser> {
    return of(this.currentUser);
  }
}
