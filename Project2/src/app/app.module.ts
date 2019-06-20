import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

import { AppComponent } from './app.component';
import { RegisterComponent } from './register/register.component';
import { NavbarComponent } from './navbar/navbar.component';
import { LoginComponent } from './login/login.component';
import { CurrentUserService } from './services/current-user.service';

import { SidebarComponent } from './sidebar/sidebar.component';
import { PostFormComponent } from './post-form/post-form.component';
import { PostService } from './services/post.service';
import { UsercardComponent } from './usercard/usercard.component';
<<<<<<< HEAD
import { ResetPasswordComponent } from './reset-password/reset-password.component';
=======
import { fakeBackendProvider } from './_helpers';
import { AuthGuard } from './_helpers';
import { JwtInterceptor, ErrorInterceptor } from './_helpers';
>>>>>>> b6e00f791ec6872ac1f26692de108e06098c5285

@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    NavbarComponent,
    LoginComponent,
    SidebarComponent,
    PostFormComponent,
    UsercardComponent,
    ResetPasswordComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule.forRoot([
      { path: '', component: PostFormComponent, canActivate: [AuthGuard] },
      { path: 'register', component: RegisterComponent },
      { path: 'login', component: LoginComponent },
<<<<<<< HEAD
<<<<<<< HEAD
      { path: 'resetpassword', component: ResetPasswordComponent}
=======
      { path: 'newPost', component: PostFormComponent, canActivate: [AuthGuard]},
      { path: 'post', component: PostFormComponent}
=======
      { path: 'post', component: PostFormComponent, canActivate: [AuthGuard]},
>>>>>>> 8992443c180df676282b917aa95af457cd9be9a0
      // { path: 'profile/:id', component: ProfileComponent, canActivate: [AuthGuard]}
>>>>>>> b6e00f791ec6872ac1f26692de108e06098c5285
    ])
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true },
    { provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true},
    CurrentUserService, PostService, fakeBackendProvider],
  bootstrap: [AppComponent]
})
export class AppModule { }
