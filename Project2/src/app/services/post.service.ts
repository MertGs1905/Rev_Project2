import { Injectable} from '@angular/core';
import {IPost} from './Post'

@Injectable({
  providedIn: 'root'
})
export class PostService  {
  private posts: IPost[] = [];

  constructor() { }

  addPost(post : IPost){
    this.posts.push(post);
  }

  getPosts(): IPost[]{
    return this.posts;
  }

  
}
