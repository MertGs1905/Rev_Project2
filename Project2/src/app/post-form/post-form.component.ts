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
  userId: number;
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

=======
>>>>>>> ed5bdef0bb2ddc5cbc3db242b0f961ae7d1d29d1
  setPost() {
    this.post = {
      username: this.username,
      comment: this.postText
    };
<<<<<<< HEAD
=======

    console.log(this.post);

>>>>>>> ed5bdef0bb2ddc5cbc3db242b0f961ae7d1d29d1
    this.postsService.addPost(this.post);

  }
}
