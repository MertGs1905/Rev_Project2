import { Injectable } from '@angular/core';
import { IPost } from './Post';
import { Observable, BehaviorSubject } from 'rxjs';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { IUser } from './User';
import { AuthenticationService } from '.';

@Injectable({
    providedIn: 'root'
})
export class PostService {
    posts: Observable<IPost[]>;
    currentUser: IUser;

<<<<<<< HEAD
    constructor(private http: HttpClient) {
        this.http.get<IPost[]>(`${environment.apiUrl}/post/getAllPosts`)
            .subscribe(posts => {
                console.log(posts);
                this.dataStore = posts;
                this.posts = this.postSub.asObservable();
                this.postSub.next(Object.assign({}, this.dataStore).posts);
            });
=======
    constructor(private http: HttpClient, private userService: AuthenticationService) {
        this.posts = this.http.get<IPost[]>(`${environment.apiUrl}/post/getAllPosts`);
        userService.currentUser.subscribe(cUser => this.currentUser = cUser);
>>>>>>> 10c07d87cbd7ebb1f7fbe9a3e53e97eba2c47fbb
    }

    addPost(post: IPost) {
        const payload = new HttpParams()
            .set('postText', post.post)
            .set('user_id', this.currentUser.user_id.toString());

        this.http.post(`${environment.apiUrl}/post/newPost`, payload).subscribe(data => {
            console.log('Post added' + data);
        });

    }

    getPosts(): Observable<IPost[]> {
        return this.posts;
    }

}
