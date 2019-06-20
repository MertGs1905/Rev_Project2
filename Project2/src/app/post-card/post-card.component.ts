import { Component, OnInit } from '@angular/core';
import { IUser } from '../services/User';
import { IPost } from '../services/Post';

@Component({
  selector: 'app-post-card',
  templateUrl: './post-card.component.html',
  styleUrls: ['./post-card.component.css']
})
export class PostCardComponent implements OnInit {
  userName: string;
  postText: string;
  constructor() { }

  ngOnInit() {
  }

}
