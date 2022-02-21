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

  public roleArray : RoleModel[] = [];

  public userDetailId:number;

  private errorSubscription : Subscription;
  private deleteSubscription : Subscription;

  constructor(private roleService : RoleService) { }

  ngOnInit(): void {
    this.userDetailId=this.roleService.getUserID();
    //this.roleArray=this.roleService.getAllRolesOfAUser(this.userId);
  }

  deleteRoleOnClick(roleId:string){
    this.deleteSubscription=this.roleService.deleteRole(roleId).subscribe(()=>{
      console.log("Deletion successful");
    },err=>{
      console.log("Error in deleting a role of a particular user",err);
    });
  }

  ngOnDestroy(){
    //this.errorSubscription.unsubscribe();
    this.deleteSubscription.unsubscribe();
  }
  
}
