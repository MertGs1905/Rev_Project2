import { Component, OnInit } from '@angular/core';
import { IUser } from '../services/User';
import { CurrentUserService } from '../services/current-user.service';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {
  currentUser: IUser;
  constructor(private userService: CurrentUserService) {
  }

  ngOnInit() {
    this.userService.getCurrentUser().subscribe(user => this.currentUser = user);
    console.log('CurrentUser in sidebar ' + this.currentUser);
  }


}

// $(document).ready(function () {

//     $("#sidebar").mCustomScrollbar({
//          theme: "minimal"
//     });

//     $('#sidebarCollapse').on('click', function () {
//         $('#sidebar').toggleClass('active');
//     });

// });

// $(document).ready(function () {

//     $("#sidebar").mCustomScrollbar({
//          theme: "minimal"
//     });

//     $('#sidebarCollapse').on('click', function () {
//         // open or close navbar
//         $('#sidebar').toggleClass('active');
//         // close dropdowns
//         $('.collapse.in').toggleClass('in');
//         // and also adjust aria-expanded attributes we use for the open/closed arrows
//         // in our CSS
//         $('a[aria-expanded=true]').attr('aria-expanded', 'false');
//     });

// });
