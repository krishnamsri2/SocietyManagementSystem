import { Component, OnDestroy, OnInit, ViewChild } from '@angular/core';
import { Subscription } from 'rxjs';
import { RoleService } from './role.service';


@Component({
  selector: 'app-role',
  templateUrl: './role.component.html',
  styleUrls: ['./role.component.css']
})
export class RoleComponent implements OnInit,OnDestroy {

  public roleArray;

  public displayRoles=false;

  public userDetailId:number;

  private rolesOfAUserSubs : Subscription;
  private deleteSubscription : Subscription;

  constructor(private roleService : RoleService) { }

  getRoles(){
    this.userDetailId=this.roleService.getUserID();
    this.rolesOfAUserSubs = this.roleService.getAllRolesOfAUser(this.userDetailId).subscribe((responseData)=>{
      this.roleArray=responseData;
      //location.reload();
    },error=>{
      console.log("Error in retrieving roles of a user with user id ",this.userDetailId,error);
    });
  }

  ngOnInit(): void {
    this.getRoles();
    console.log(this.userDetailId);
  }

  deleteRoleOnClick(roleId:string){
    this.deleteSubscription=this.roleService.deleteRole(roleId).subscribe(()=>{
      console.log("Deletion successful");
      this.getRoles();
    },err=>{
      console.log("Error in deleting a role of a particular user",err);
    });
  }

  reloadThePage(reloadPage : boolean){
    this.getRoles();
    //location.reload();
  }

  ngOnDestroy(){
    
    this.rolesOfAUserSubs.unsubscribe();
    this.deleteSubscription.unsubscribe();
  }
  
}
