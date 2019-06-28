import { Component, OnInit, OnDestroy } from '@angular/core';
import { PostService } from '../services/post.service';
import { IPost } from '../services/Post';
import { Subscription } from 'rxjs';


@Component({
  selector: 'app-post-feed',
  templateUrl: './post-feed.component.html',
  styleUrls: ['./post-feed.component.css'],

})
export class PostFeedComponent implements OnInit, OnDestroy {
  postSub: Subscription;
  posts: IPost[];
  constructor(private postService: PostService) {

  }

  ngOnInit() {
    this.postSub = this.postService.posts.subscribe(posts => {
        console.log(posts);
        this.posts = posts;
    });
  }

  ngOnDestroy() {
    this.postSub.unsubscribe();
  }

}
