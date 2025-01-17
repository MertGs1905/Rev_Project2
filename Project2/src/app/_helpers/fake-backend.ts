import { Injectable } from '@angular/core';
import { HttpRequest, HttpResponse, HttpHandler, HttpEvent, HttpInterceptor, HTTP_INTERCEPTORS } from '@angular/common/http';
import { Observable, of, throwError } from 'rxjs';
import { delay, mergeMap, materialize, dematerialize } from 'rxjs/operators';
import { IUser } from '../services/User';
import { isBuffer, isUndefined } from 'util';

<<<<<<< HEAD
let users = [
{ id: 1, firstName: 'Chris', lastName: 'Sinko', username: 'test', password: 'test' },
{ id: 2, firstName: 'Jacob', lastName: 'Shanklin', username: 'Admin', password: '123!' },
{ id: 3, firstName: 'Mert', lastName: 'Altun', username: 'Admin2', password: '123!' },
{ id: 4, firstName: 'Mike', lastName: 'Perkins', username: 'Admin3', password: '123!' },
{ id: 5, firstName: 'Tyree', lastName: 'Graham', username: 'Admin4', password: '123!' }
];
||||||| merged common ancestors
let users = [{ id: 1, firstName: 'Chris', lastName: 'Sinko', username: 'test', password: 'test' },
{ id: 2, firstName: 'Jacob', lastName: 'Shanklin', username: 'Admin', password: '123!' },
{ id: 3, firstName: 'Mert', lastName: 'Altun', username: 'Admin2', password: '123!' },
{ id: 4, firstName: 'Mike', lastName: 'Perkins', username: 'Admin3', password: '123!' },
{ id: 5, firstName: 'Tyree', lastName: 'Graham', username: 'Admin4', password: '123!' }
];
=======
let users = JSON.parse(localStorage.getItem('users')) || [];
>>>>>>> d282ef23b6b9a581847bbea0111f843377db38d7

@Injectable()
export class FakeBackendInterceptor implements HttpInterceptor {
    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        const { url, method, headers, body } = request;

        // wrap in delayed observable to simulate server api call
        return of(null)
            .pipe(mergeMap(handleRoute))
            .pipe(materialize())        // call materialize and dematerialize to ensure delay even if an error
                                        // is thrown (https://github.com/Reactive-Extensions/RxJS/issues/648)
            .pipe(delay(500))
            .pipe(dematerialize());

        function handleRoute() {
            switch (true) {
                case url.endsWith('/users/authenticate') && method === 'POST':
                    return authenticate();
                case url.endsWith('/users/showusers') && method === 'GET':
                    return showusers();
                case url.endsWith('/users/register') && method === 'POST':
                    return register();
                default:
                    // pass through any requests not handled above
                    return next.handle(request);
            }
        }

        // route functions

        function authenticate() {
            const { username, password } = body;
            const user = users.find(x => x.username === username && x.password === password);
            if (!user) { return error('Username or password is incorrect'); }
            return ok({
                id: user.id,
                username: user.username,
                firstName: user.firstName,
                lastName: user.lastName,
                token: 'fake-jwt-token'
            });
        }

        function register() {
            const user = body;

            if (users.find(x => x.username === user.username)) {
                return error('Username "' + user.username + '" is already taken');
            }

            user.id = users.length ? Math.max(...users.map(x => x.id)) + 1 : 1;
            users.push(user);
            localStorage.setItem('users', JSON.stringify(users));

            return ok();
        }

        function showusers() {
            return ok(users);
        }
        // helper functions

        // tslint:disable-next-line: no-shadowed-variable
        function ok(body?) {
            return of(new HttpResponse({ status: 200, body }));
        }

        function error(message) {
            return throwError({ error: { message } });
        }
    }
}

export const fakeBackendProvider = {
    // use fake backend in place of Http service for backend-less development
    provide: HTTP_INTERCEPTORS,
    useClass: FakeBackendInterceptor,
    multi: true
};
