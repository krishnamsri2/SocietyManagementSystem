import { Component, Input, OnDestroy, OnInit, ViewChild } from '@angular/core';
import { FormGroup, NgForm } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
//import { Observable } from 'src/app/dashboard/configuration/user/role/node_modules/rxjs';
import { Subscription } from 'rxjs';
import { UserModel } from 'src/app/shared/user.model';
import { UserService } from 'src/app/user.service';
import { FlatDetailsService } from './flat-details/flat-details.service';
import { RoleService } from './role/role.service';
import { UserPostServices } from './user.posts.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit,OnDestroy {

  private userDetailId : number;
  users : UserModel[];

  userSubscription : Subscription;
  
  constructor(public activeRoute : ActivatedRoute,private userService : UserService, private userPostService : UserPostServices,
    private roleService : RoleService, private flatsDetailsService : FlatDetailsService){
  }

  ngOnInit(){
    this.userSubscription = this.userPostService.fetchUsers().subscribe((userData)=>{
      this.users=userData;
      this.userService.setUsers(this.users);
      },error =>{
      console.log("Error in retrieving users",error);
    },()=>{
      console.log("Retrieval Succesful");
    });
  }

  saveUserId(userId : number){
    this.roleService.setUserId(userId);
  }

  setUserInactive(userId : number){
    this.userPostService.setUserInactive(userId);
  }

  setUserId(userDetailId : number){
    this.flatsDetailsService.setUserDetailId(userDetailId);
  }

  ngOnDestroy(){
    //this.userSubscription.unsubscribe();
  }

}
