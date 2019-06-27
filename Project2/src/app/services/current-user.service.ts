import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { map } from 'rxjs/operators';
import { IUser } from './User';

@Injectable({ providedIn: 'root' })
export class CurrentUserService {
    constructor(private http: HttpClient) { }

    getAll() {
        return this.http.get<any[]>(`${environment.apiUrl}/users`);
    }
    getById(id) {
        return this.http.get<IUser>(`${environment.apiUrl}/users/${id}`);
    }
    register(username, password, firstName, lastName, email) {
        const payload = new HttpParams()
            .set('username', username)
            .set('password', password)
            .set('firstname', firstName)
            .set('lastname', lastName)
            .set('email', email);
        console.log(payload);
        return this.http.post(`${environment.apiUrl}/auth/registerUser`, payload);
    }

    delete(id) {
        return this.http.delete(`${environment.apiUrl}/users/${id}`);
    }
    resetPw(email) {
        const payload = new HttpParams()
            .set('email', email);
        return this.http.post(`${environment.apiUrl}/resetPassword`, payload);
    }
}
