import { Component, OnInit, Output, ViewChild, EventEmitter, OnDestroy } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Subscription } from 'rxjs';
import { RoleService } from '../role/role.service';
import { UserPostServices } from '../user.posts.service';

@Component({
  selector: 'app-new-user',
  templateUrl: './new-user.component.html',
  styleUrls: ['./new-user.component.css']
})
export class NewUserComponent implements OnInit,OnDestroy {

  

  constructor(private userOperations : UserPostServices, private roleService : RoleService) { }

  private errorMessage : Subscription;

  ngOnInit(): void {
    
  }

  ngOnDestroy(){
    
  }

  private user = {

    token: {
      societyId: '',
      userId: '',
    },
    
    requestObject: {

      firstName : '',
      userDetailId: '',
      lastName : '',
      emailId : '',
      phoneNumber: '',
      
    
    }
    
  }

  onFormSubmit(signUpForm : NgForm){
    
    this.user.requestObject.firstName=signUpForm.value.firstName;
    this.user.requestObject.lastName=signUpForm.value.lastName;
    this.user.requestObject.emailId=signUpForm.value.email;
    this.user.requestObject.phoneNumber=signUpForm.value.phoneNumber;
    console.log(this.user);
    this.errorMessage=this.userOperations.addUsers(this.user).subscribe(()=>{
      alert('User registered');
    });
    signUpForm.reset();
  }

}
