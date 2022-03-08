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
  
  public superAdmin=false;

  constructor(private userOperations : UserPostServices, private roleService : RoleService) { }

  ngOnInit(): void {
    console.log(+atob(localStorage.getItem('societyId')));
    if(+atob(localStorage.getItem('societyId'))===0){
      this.superAdmin=true;
    }
  }

  ngOnDestroy(){
    //this.superAdmin=false;
  }

  onFormSubmit(signUpForm : NgForm){
    
    let firstName = signUpForm.value.firstName;
    let lastName=signUpForm.value.lastName;
    let emailId=signUpForm.value.email;
    let phoneNumber=signUpForm.value.phoneNumber;
    let societyName=signUpForm.value.societyName;
    
    //this.user= new UserModel(firstName,lastName,phoneNumber,emailId,null,societyName);

    console.log("I'm superadmin",this.superAdmin);

    if(this.superAdmin){
      this.user= new UserModel(firstName,lastName,phoneNumber,emailId,null,societyName,null);
      this.userOperations.addUsersBySuperAdmin(this.user).subscribe((responseData)=>{
        //location.reload();
      },error=>{
        console.log("Error in getting admins",error);
      });
    }

    else{
      this.user= new UserModel(firstName,lastName,phoneNumber,emailId,null,null,null);

      this.userOperations.addUsers(this.user).subscribe((response)=>{
        //location.reload();
      },error=>{
        console.log("Error in getting users of a society",error);
      });
    }
    
    signUpForm.reset();
  }

}
