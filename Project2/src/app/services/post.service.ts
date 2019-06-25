import { Injectable } from '@angular/core';
import { IPost } from './Post';
import { Observable, BehaviorSubject } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PostService {
  private apiUrl = 'http://localhost:4200//Project2/';
  posts: Observable<IPost[]>;
  private postSub = new BehaviorSubject([]);
  private baseUrl: string;
  private dataStore: {
    posts: IPost[]
  };

  constructor(private http: HttpClient) {
    this.http.get<IPost[]>(this.apiUrl + 'getAllPost.app')
      .subscribe(posts => {
        this.dataStore.posts = posts;
        this.posts = this.postSub.asObservable();
        this.postSub.next(Object.assign({}, this.dataStore).posts);
      });
  }

  addPost(post: IPost) {
    this.dataStore.posts.push(post);
    this.postSub.next(Object.assign({}, this.dataStore).posts);
  }

  getPosts(): IPost[] {
    return this.dataStore.posts;
  }

}
