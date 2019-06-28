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

    constructor(private http: HttpClient, private userService: AuthenticationService) {
        this.posts = this.http.get<IPost[]>(`${environment.apiUrl}/getAllPosts`);
        userService.currentUser.subscribe(cUser => this.currentUser = cUser);
    }

    addPost(post: IPost) {
        const payload = new HttpParams()
            .set('postText', post.post)
            .set('user_id', this.currentUser.user_id.toString());

        this.http.post(`${environment.apiUrl}/newPost`, payload).subscribe(data => {
            console.log('Post added' + data);
        });

    }

    getPosts(): Observable<IPost[]> {
        return this.posts;
    }

}
