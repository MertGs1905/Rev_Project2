import { Component, OnInit } from '@angular/core';
import { IPost } from '../services/Post';
import { PostService } from '../services/post.service';
import { Subscription } from 'rxjs';
import { IUser } from '../services/User';
import { AuthenticationService } from '../services';

@Component({
  selector: 'app-post-form',
  templateUrl: './post-form.component.html',
  styleUrls: ['./post-form.component.css']
})
export class PostFormComponent implements OnInit {
  postText: string;
  post: IPost;
  subscription: Subscription;
  currentUser: IUser;
  constructor(private postsService: PostService, private userService: AuthenticationService) {
    this.subscription = this.userService.currentUser.subscribe(user => {
      if (user) {
        this.currentUser = user;
      } else {
        this.currentUser = null;
      }
    });
  }

  ngOnInit() {
  }

  setPost() {
    this.post = {
      user: this.currentUser,
      post: this.postText,
      rating: {
        likes: 0,
        dislikes: 0
      }
    };

    console.log(this.post);

    this.postsService.addPost(this.post);

  }
}
