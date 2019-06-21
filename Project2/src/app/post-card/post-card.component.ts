import { Component, OnInit, Input } from '@angular/core';
import { IUser } from '../services/User';
import { IPost } from '../services/Post';

@Component({
  selector: 'app-post-card',
  templateUrl: './post-card.component.html',
  styleUrls: ['./post-card.component.css']
})
export class PostCardComponent implements OnInit {
  @Input() userName: string;
  @Input() postText: string;
  constructor() { }

  ngOnInit() {
  }

}
