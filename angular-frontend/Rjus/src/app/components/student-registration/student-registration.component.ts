import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';


@Component({
  selector: 'app-student-registration',
  templateUrl: './student-registration.component.html',
  styleUrls: ['./student-registration.component.css']
})
export class StudentRegistrationComponent implements OnInit {
  studentRegistrationForm = new FormGroup({
    Name: new FormControl(''),
    Email: new FormControl(''),
    Address:new FormControl(''),
    ContactNo:new FormControl(''),
    UserName:new FormControl(''),
    Password:new FormControl(''),
    Gender:new FormControl('')
  });
  onSubmit()
  {
    console.warn(this.studentRegistrationForm.value);
  }
  constructor() { }

  ngOnInit(): void {
  }

}
