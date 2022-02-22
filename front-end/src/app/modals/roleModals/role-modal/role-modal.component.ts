import { Component, Input, OnDestroy, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { Subscription } from 'rxjs';

import { RoleModel } from 'src/app/dashboard/configuration/user/role/role.model';
import { RoleService } from 'src/app/dashboard/configuration/user/role/role.service';

@Component({
  selector: 'app-role-modal',
  templateUrl: './role-modal.component.html',
  styleUrls: ['./role-modal.component.css']
})
export class RoleModalComponent implements OnInit, OnDestroy {

  @Input('id') userDetailId : number;
  @Input('roleIdForEdit') roleId : number;

  public roleTypeArray = ['WORKER','ADMIN','RESIDENT']
  
  private updateRoleSubscription : Subscription;
  private roleWithARoleIdSubs : Subscription;
  public oldRole;   

  closeResult = '';
  ngOnInit(): void {

    this.roleWithARoleIdSubs=this.roleService.getRoleDetailsByRoleId(this.roleId).subscribe((responseData)=>{
      this.oldRole=responseData;
    },error=>{
      console.log("Error in retrieving role with rold-id ",this.roleId,error);
    });
    //console.log("Hello");
    console.log(this.oldRole);
  }

  constructor(private modalService: NgbModal, private roleService : RoleService) {}

  open(content) {
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });
  }

  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return `with: ${reason}`;
    }
  }

  onFormSubmit(roleUpdateForm:NgForm){
    let newRoleType=roleUpdateForm.value.roleType;
    let newRole=roleUpdateForm.value.role;
    let newRoleDesc=roleUpdateForm.value.roleDescription;
    this.updateRoleSubscription=this.roleService.updateRoleDetailsByRoleId(new RoleModel(newRoleType,newRole,newRoleDesc),this.roleId).
    subscribe(()=>{
      console.log("Roles updated for a particular user");
      alert("Role updated");
    },err=>{
      console.log("Error in updating roles for a particular role",err);
    });
  }

  ngOnDestroy(){
    //this.updateRoleSubscription.unsubscribe();
  }

}
