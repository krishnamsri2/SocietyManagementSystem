import { Component, OnInit, Output, ViewChild, EventEmitter, OnDestroy } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Subscription } from 'rxjs';
import { UserModel } from 'src/app/shared/user.model';
import { RoleService } from '../role/role.service';
import { UserPostServices } from '../user.posts.service';

@Component({
  selector: 'app-new-user',
  templateUrl: './new-user.component.html',
  styleUrls: ['./new-user.component.css']
})
export class NewUserComponent implements OnInit,OnDestroy {

  private user : UserModel;  

  constructor(private userOperations : UserPostServices, private roleService : RoleService) { }

  ngOnInit(): void {
    
  }

  ngOnDestroy(){
    
  }

  onFormSubmit(signUpForm : NgForm){
    
    let firstName = signUpForm.value.firstName;
    let lastName=signUpForm.value.lastName;
    let emailId=signUpForm.value.email;
    let phoneNumber=signUpForm.value.phoneNumber;
    this.user= new UserModel(firstName,lastName,phoneNumber,emailId);
    this.userOperations.addUsers(this.user).subscribe((response)=>{
    });
    signUpForm.reset();
  }

}
