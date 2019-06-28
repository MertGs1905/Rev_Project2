import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../services';
import { IUser } from '../services/User';
import { Subscription, Observable, of } from 'rxjs';
import { HttpClient, HttpParams } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-edit-profile',
  templateUrl: './edit-profile.component.html',
  styleUrls: ['./edit-profile.component.css']
})

export class EditProfileComponent implements OnInit {
  subscription: Subscription;
  currentUser: IUser;
  bannerImage = 'assets/Cool-Cat-Cropped.jpg';

  firstname : string;
  lastname:   string;
  email:      string;
  birthdate:  string;
  hobbies:    string;
  occupation: string;

  constructor(private userService: AuthenticationService) {
   
  }



  ngOnInit() {
    this.getUser();
  }

  edit() {
    const payload = new HttpParams().set('firstname', firstname).set('last name', last name);
    return this.http.post<IUser>(`${environment.apiUrl}/auth/authenticate`, payload)
        .pipe(map(user => {
            // store user details and jwt token in local storage to keep user logged in between page refreshes
            localStorage.setItem('currentUser', JSON.stringify(user));
            console.log(JSON.stringify(user));
            this.currentUserSubject.next(user);
            return user;
        }));
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
