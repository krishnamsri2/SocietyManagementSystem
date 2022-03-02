import { Component, Input, OnDestroy, OnInit, Output, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Subscription } from 'rxjs';
import { RoleModel } from 'src/app/dashboard/configuration/user/role/role.model';
import { RoleService } from 'src/app/dashboard/configuration/user/role/role.service';
import { EventEmitter } from '@angular/core';

@Component({
  selector: 'app-new-role-modal',
  templateUrl: './new-role-modal.component.html',
  styleUrls: ['./new-role-modal.component.css']
})
export class NewRoleModalComponent implements OnInit, OnDestroy {

  public roleTypeArray = ['WORKER','RESIDENT','ADMIN'];

  public newRole=new RoleModel('','','');

  @Input('userIdForRoleAddition') userDetailId : number;
  @Output() reloadPage = new EventEmitter<boolean>();
  
  private newUserSubscription : Subscription;
  closeResult = '';

  ngOnInit(): void {
    
    //this.reloadPage.emit(true);
    //console.log(this.userDetailId);
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

  onSubmit(){

    //this.newRole.userDetailId=this.userDetailId;

    console.log(this.newRole,this.userDetailId);

    
    this.newUserSubscription=this.roleService.addRole(this.newRole,this.userDetailId).
    subscribe(()=>{
      console.log("Role for a particular user added");
      this.reloadPage.emit(true);
      setTimeout(()=>{
        this.newRole=new RoleModel('','','');
      })
      
    },err=>{
      console.log("Error in adding a role for a particular user",err);
    });
    
  }

  ngOnDestroy(){
    //this.newUserSubscription.unsubscribe();
    
  }

}
