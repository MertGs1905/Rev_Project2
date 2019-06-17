import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { RegisterComponent } from './register/register.component';
import { NavbarComponent } from './navbar/navbar.component';
import { LoginComponent } from './login/login.component';
import { CurrentUserService } from './services/current-user.service';

import { SidebarComponent } from './sidebar/sidebar.component';
import { PostFormComponent } from './post-form/post-form.component';
import { PostService } from './services/post.service';
import { UsercardComponent } from './usercard/usercard.component';

@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    NavbarComponent,
    LoginComponent,
    SidebarComponent,
    PostFormComponent,
    UsercardComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule.forRoot([
      { path: 'register', component: RegisterComponent },
      { path: 'login', component: LoginComponent }
    ])
  ],
  providers: [CurrentUserService,PostService],
  bootstrap: [AppComponent]
})
export class AppModule { }
