import { Component, OnInit } from '@angular/core';
import { IPost } from '../services/Post';
import { PostService } from '../services/post.service';
import { CurrentUserService } from '../services/current-user.service';
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
  username: string;
  subscription: Subscription;
  currentUser: IUser;
  constructor(private postsService: PostService, private userService: AuthenticationService) {


    this.subscription = this.userService.currentUser.subscribe(user => {

      if (user) {
        this.currentUser = user;
        this.username = this.currentUser.username;
      } else {
        this.currentUser = null;
      }

    });
  }

  ngOnInit() {
  }
<<<<<<< HEAD
setPost() {
  this.post = {
    username: 'mert',
    comment: this.postText
  };
=======
  setPost() {
    this.post = {

      username: this.username,
      comment: this.postText

    };
>>>>>>> 1475b36bb0bced8d4a6acfd3c144fd430c4309f6

    console.log(this.post);

    this.postsService.addPost(this.post);

  }
}
