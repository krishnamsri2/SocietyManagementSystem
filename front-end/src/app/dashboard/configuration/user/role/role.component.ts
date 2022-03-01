import { Component, OnDestroy, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { RoleService } from './role.service';


@Component({
  selector: 'app-role',
  templateUrl: './role.component.html',
  styleUrls: ['./role.component.css']
})
export class RoleComponent implements OnInit,OnDestroy {

  public roleArray : any;

  public displayRoles=false;

  public userDetailId:number;

  private rolesOfAUserSubs : Subscription;
  private updateStatusSubs : Subscription;

  constructor(private roleService : RoleService,private route : ActivatedRoute) { }

  getRoles(){
    //this.userDetailId=this.roleService.getUserID();
    this.rolesOfAUserSubs = this.roleService.getAllRolesOfAUser(this.userDetailId).subscribe((responseData)=>{
      this.roleArray=responseData;
      console.log(responseData);
    },error=>{
      console.log("Error in retrieving roles of a user with user id ",this.userDetailId,error);
    });
  }

  ngOnInit(): void {
    this.route.params.subscribe((params:Params)=>{
      this.userDetailId=+params['userDetailId'];
    });
    console.log(this.userDetailId);
    this.getRoles();
    
  }

  changeStatusOnClick(roleId:number){
    this.updateStatusSubs=this.roleService.activateDeactivateRole(roleId).subscribe(()=>{
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
    this.updateStatusSubs.unsubscribe();
  }
  
}
