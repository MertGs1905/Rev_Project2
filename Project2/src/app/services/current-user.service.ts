import { Injectable } from '@angular/core';
import { Observable, Subject, of } from 'rxjs';
import { IUser } from './User';

@Injectable()
export class CurrentUserService {
  private subject = new Subject<IUser>();
  constructor() { }

  setCurrentUser(user: IUser) {
    this.subject.next(user);
  }

  getCurrentUser(): Observable<IUser> {
    return this.subject.asObservable();
  }
}
