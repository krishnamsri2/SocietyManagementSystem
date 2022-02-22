import { Component, OnDestroy, OnInit, ViewChild } from '@angular/core';

import { Subscription } from 'rxjs';

import { RoleModel } from './role.model';
import { RoleService } from './role.service';


@Component({
  selector: 'app-role',
  templateUrl: './role.component.html',
  styleUrls: ['./role.component.css']
})
export class RoleComponent implements OnInit,OnDestroy {

  public roleArray;

  public userDetailId:number;

  private rolesOfAUserSubs : Subscription;
  private deleteSubscription : Subscription;

  constructor(private roleService : RoleService) { }

  ngOnInit(): void {
    this.userDetailId=this.roleService.getUserID();
    this.rolesOfAUserSubs = this.roleService.getAllRolesOfAUser(this.userDetailId).subscribe((responseData)=>{
      this.roleArray=responseData;
    },error=>{
      console.log("Error in retrieving roles of a user with user id ",this.userDetailId,error);
    });
  }

  deleteRoleOnClick(roleId:string){
    this.deleteSubscription=this.roleService.deleteRole(roleId).subscribe(()=>{
      console.log("Deletion successful");
      alert("Role deleted");
    },err=>{
      console.log("Error in deleting a role of a particular user",err);
    });
  }

  ngOnDestroy(){
    //this.errorSubscription.unsubscribe();
    this.deleteSubscription.unsubscribe();
  }
  
}
