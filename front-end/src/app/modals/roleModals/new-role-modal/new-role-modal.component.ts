import { Component, Input, OnDestroy, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Subscription } from 'rxjs';
import { RoleModel } from 'src/app/dashboard/configuration/role/role.model';
import { RoleService } from 'src/app/dashboard/configuration/role/role.service';

@Component({
  selector: 'app-new-role-modal',
  templateUrl: './new-role-modal.component.html',
  styleUrls: ['./new-role-modal.component.css']
})
export class NewRoleModalComponent implements OnInit, OnDestroy {

  public roleTypeArray = ['WORKER','RESIDENT','ADMIN'];

  @Input('userIdForRoleAddition') userDetailId : number;
  
  private newUserSubscription : Subscription;
  closeResult = '';

  ngOnInit(): void {
    
  }
  constructor(private modalService: NgbModal,private roleService : RoleService) {}

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

  onFormSubmit(roleCreateForm : NgForm){

    let newRole = roleCreateForm.value.role;
    let newRoleType = roleCreateForm.value.roleType;
    let newRoleDesc = roleCreateForm.value.roleDescription;

    console.log(newRole);
    
    this.newUserSubscription=this.roleService.addRole(new RoleModel(newRoleType,newRole,newRoleDesc),this.userDetailId).
    subscribe(()=>{
      console.log("Role for a particular user added");
      alert("Role added");
    },err=>{
      console.log("Error in adding a role for a particular user",err);
    });
  }

  ngOnDestroy(){
    this.newUserSubscription.unsubscribe();
  }

}
