import { Component, OnInit, ViewChild } from '@angular/core';
import { FormGroup, NgForm } from '@angular/forms';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  @ViewChild('f') signUpForm : NgForm;

  constructor() { }

  ngOnInit(): void {
  }

  user = {
    firstName:'',
    lastName:'',
    email:'',
    towerNumber:'',
    flatNumber: '',
    phoneNumber:''
  };

  onFormSubmit(){
    this.user.firstName=this.signUpForm.value.firstName;
    this.user.lastName=this.signUpForm.value.lastName;
    this.user.email=this.signUpForm.value.email;
    this.user.towerNumber=this.signUpForm.value.towerNumber;
    this.user.flatNumber=this.signUpForm.value.flatNumber;
    this.user.phoneNumber=this.signUpForm.value.phoneNumber;
    console.log(this.user);
    this.signUpForm.reset();
  }

}
