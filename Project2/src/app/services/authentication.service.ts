import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { IUser } from './User';
import { environment } from 'src/environments/environment';

@Injectable({ providedIn: 'root' })
export class AuthenticationService {
    private currentUserSubject: BehaviorSubject<any>;
    public currentUser: Observable<any>;

    constructor(private http: HttpClient) {
        this.currentUserSubject = new BehaviorSubject<any>(JSON.parse(localStorage.getItem('currentUser')));
        this.currentUser = this.currentUserSubject.asObservable();
    }

    public get currentUserValue() {
        return this.currentUserSubject.value;
    }

    login(username, password) {
        username = username.toLowerCase();
        const payload = new HttpParams().set('username', username).set('password', password);
        return this.http.post<any>(`${environment.apiUrl}/user/authenticate`, payload)
            .pipe(map(user => {
                // store user details and jwt token in local storage to keep user logged in between page refreshes
                localStorage.setItem('currentUser', JSON.stringify(user));
                this.currentUserSubject.next(user);
                return user;
            }));
    }
    registerNewUser(user) {
        /*
        const payload = new HttpParams().set('username', username).set('password', password);
        return this.http.post<any>(`${environment.apiUrl}/user/register`, payload)
            .pipe(map(user => {
                // store user details and jwt token in local storage to keep user logged in between page refreshes
                localStorage.setItem('currentUser', JSON.stringify(user));
                this.currentUserSubject.next(user);
                return user;
            }));
            */
           const payload = new HttpParams().set('username', 'TestUser').set('password', '123!@#');
           return this.http.post<any>(`${environment.apiUrl}/user/register`, payload);
    }
    getusers() {
        return this.http.get<any>(`${environment.apiUrl}/user/getAllUsers`)
            .pipe(map(user => {
                return user;
            }));
    }
    logout() {
        // remove user from local storage and set current user to null
        localStorage.removeItem('currentUser');
        this.currentUserSubject.next(null);
    }
}
