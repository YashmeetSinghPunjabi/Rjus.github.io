import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AllCoursesComponent } from './components/all-courses/all-courses.component';
import { StudentRegistrationComponent } from './components/student-registration/student-registration.component';
import { CourseDescriptionComponent } from './course-description/course-description.component';
import { ForgotPassComponent } from './forgot-pass/forgot-pass.component';
import { LoginComponent } from './login/login.component';

const routes: Routes = [
  {path: 'course-description',component:CourseDescriptionComponent },
  {path: 'all-courses',component:AllCoursesComponent},
  {path:'login',component:LoginComponent},
  {path:'',component:AllCoursesComponent},
  {path:'ForgotPass',component:ForgotPassComponent},
  {path:'SignUp',component:StudentRegistrationComponent}
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
