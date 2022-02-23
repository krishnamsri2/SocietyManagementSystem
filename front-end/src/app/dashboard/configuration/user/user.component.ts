import { Component, Input, OnDestroy, OnInit, ViewChild } from '@angular/core';
import { FormGroup, NgForm } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
//import { Observable } from 'src/app/dashboard/configuration/user/role/node_modules/rxjs';
import { Subscription } from 'rxjs';
import * as $ from 'jquery';

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
  userDeletionSubs : Subscription;

  constructor(public activeRoute : ActivatedRoute,private userService : UserService, private userPostService : UserPostServices,
    private roleService : RoleService, private flatsDetailsService : FlatDetailsService){
  }

  currentUsers(){
    this.userSubscription = this.userPostService.fetchUsers().subscribe((userData)=>{
      this.users=userData;
      //this.userService.setUsers(this.users);
      //console.log(this.users);
      },error =>{
      console.log("Error in retrieving users",error);
    });
  }

  ngOnInit(){
    this.currentUsers();
  }

  saveUserId(userId : number){
    this.roleService.setUserId(userId);
    //console.log(this.roleService.getUserID());
    
  }

  setUserInactive(userId : number){
    this.userDeletionSubs=this.userPostService.setUserInactive(userId).subscribe(()=>{
      this.currentUsers();
    },error=>{
      console.log("User deletion not successful",error);
    });
    
  }

  setUserId(userDetailId : number){
    this.flatsDetailsService.setUserDetailId(userDetailId);
  }

  onUpdateUser(reloadPage:boolean){
    this.currentUsers();
  }

  ngOnDestroy(){
    
  }

}
