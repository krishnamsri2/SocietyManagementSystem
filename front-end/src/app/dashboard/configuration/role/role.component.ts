import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { RoleService } from './role.service';

@Component({
  selector: 'app-role',
  templateUrl: './role.component.html',
  styleUrls: ['./role.component.css']
})
export class RoleComponent implements OnInit {

  @ViewChild('roleCreateForm') roleCreateForm : NgForm;
  @ViewChild('roleDeleteForm') roleDeleteForm : NgForm;
  @ViewChild('roleUpdateForm') roleUpdateForm: NgForm; 

  constructor(private roleService : RoleService) { }

  ngOnInit(): void {
  }

  onRoleCreate(){
    let newRole = this.roleCreateForm.value.newRole;
    this.roleService.addRole(newRole);
  }

  onRoleDelete(){
    let oldRole = this.roleDeleteForm.value.deleteRole;
    this.roleService.deleteRole(oldRole);
  }

  onRoleUpdate(){
    let oldRole=this.roleUpdateForm.value.oldRole;
    let newRole=this.roleUpdateForm.value.newRole;
    let userId=this.roleUpdateForm.value.userIdforRoleUpdation;
    this.roleService.updateRole(userId,oldRole,newRole);
  }
}
