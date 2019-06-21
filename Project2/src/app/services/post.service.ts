import { Injectable } from '@angular/core';
import { IPost } from './Post';
import { Observable, BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PostService {
  posts: Observable<IPost[]>;
  private postSub: BehaviorSubject<IPost[]>;
  private baseUrl: string;
  private dataStore: {
    posts: IPost[]
  };

  constructor() {
    this.dataStore = { posts: [] };
    this.postSub = new BehaviorSubject([]);
    this.posts = this.postSub.asObservable();
  }

  addPost(post: IPost) {
    this.dataStore.posts.push(post);
    this.postSub.next(Object.assign({}, this.dataStore).posts);
  }

  getPosts(): IPost[] {
    return this.dataStore.posts;
  }

}
