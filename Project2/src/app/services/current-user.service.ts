import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
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
    register(user) {
        return this.http.post(`${environment.apiUrl}/users/register`, user);
    }

    delete(id) {
        return this.http.delete(`${environment.apiUrl}/users/${id}`);
    }
}
