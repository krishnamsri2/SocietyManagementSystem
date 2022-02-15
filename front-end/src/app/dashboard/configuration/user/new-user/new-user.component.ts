import { Component, OnInit, Output, ViewChild, EventEmitter, OnDestroy } from '@angular/core';
import { NgForm } from '@angular/forms';
import { UserPostServices } from '../user.posts.service';



@Component({
  selector: 'app-new-user',
  templateUrl: './new-user.component.html',
  styleUrls: ['./new-user.component.css']
})
export class NewUserComponent implements OnInit,OnDestroy {

  @ViewChild('f') signUpForm : NgForm;

  @Output() showAttributes = new EventEmitter<boolean>();

  constructor(private userOperations : UserPostServices) { }

  ngOnInit(): void {
    this.showAttributes.emit(true);
  }

  ngOnDestroy(){
    this.showAttributes.emit(false);
  }

  user = {
    firstName:'',
    lastName:'',
    email:'',
    roleType : '',
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
    this.user.roleType = this.signUpForm.value.roleType;
    console.log(this.user);
    this.userOperations.addUsers(this.signUpForm.value);
    this.signUpForm.reset();
  }

}
