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
  private postSub = new BehaviorSubject([]);
  private baseUrl: string;
  private dataStore: {
    posts: {postId: 5, userId: 1, postText: '', rating: {1, 2}}
  };

  constructor(private http: HttpClient) {
    this.http.get<IPost[]>(`${environment.apiUrl}/post/getAllPosts`)
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
