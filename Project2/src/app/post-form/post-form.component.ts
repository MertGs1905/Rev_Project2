import { Component, OnInit } from '@angular/core';
import {IPost} from '../services/Post';
import {PostService} from '../services/post.service';
@Component({
  selector: 'app-post-form',
  templateUrl: './post-form.component.html',
  styleUrls: ['./post-form.component.css']
})
export class PostFormComponent implements OnInit {
postText: string;
post: IPost;
  constructor(private postsService: PostService) { }

  ngOnInit() {
  }
setPost(){
  this.post = {
   
    username: "mert",
    comment: this.postText

  };

  this.postsService.addPost(this.post);
}
}
