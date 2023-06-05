import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { SideNavLeftComponent } from './components/side-nav-left/side-nav-left.component';
import { SideNavRightComponent } from './components/side-nav-right/side-nav-right.component';
import { AllCoursesComponent } from './components/all-courses/all-courses.component';
import { TestComponent } from './components/test/test.component';
import { CourseDescriptionComponent } from './course-description/course-description.component';
import { LoginComponent } from './login/login.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatPaginatorModule } from '@angular/material/paginator';
import { ForgotPassComponent } from './forgot-pass/forgot-pass.component';
import { HttpClientModule } from '@angular/common/http';
import { StudentRegistrationComponent } from './components/student-registration/student-registration.component';
import { ReactiveFormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    SideNavLeftComponent,
    SideNavRightComponent,
    AllCoursesComponent,
    TestComponent,
    CourseDescriptionComponent,
    LoginComponent,
    ForgotPassComponent,
    StudentRegistrationComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatPaginatorModule,
    HttpClientModule,
    ReactiveFormsModule
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
