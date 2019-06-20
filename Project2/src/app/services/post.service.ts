import { Injectable } from '@angular/core';
import { IPost } from './Post'
import { Observable, Subject, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PostService {
  private subject = new Subject<IPost[]>();

  posts$ = this.subject.asObservable();
  constructor() { }


  private set posts(val: IPost[]) {
    this.subject.next(val);
  }
  addPost(post: IPost) {
    this.posts = [...this.posts, post];
  }

  getPosts(): IPost[] {
    return this.posts;
  }


}
