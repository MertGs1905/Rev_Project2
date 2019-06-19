import { Injectable} from '@angular/core';
import {IPost} from './Post'
import {Observable, Subject, of} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PostService  {
  private  subject = new Subject<IPost[]>();
  
 posts$ = this.subject.asObservable();
  constructor() { }


  private set posts(val: IPost[]){
    this.posts.next(val);
  }
  addPost(post : IPost){
    this.posts =[...this.posts,post];
    //this.subject.next(this.push(post));
  }

  getPosts(): IPost[]{
  return this.posts;
  }


}
