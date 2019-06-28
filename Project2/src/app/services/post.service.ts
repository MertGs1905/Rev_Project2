import { Injectable } from '@angular/core';
import { IPost } from './Post';
import { Observable, BehaviorSubject } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
    providedIn: 'root'
})
export class PostService {
    posts: Observable<IPost[]>;

    constructor(private http: HttpClient) {
        this.posts = this.http.get<IPost[]>(`${environment.apiUrl}/post/getAllPosts`);
    }

    addPost(post: IPost) {
        // this.dataStore.push(post);
    }

    getPosts(): Observable<IPost[]> {
        return this.posts;
    }

}
