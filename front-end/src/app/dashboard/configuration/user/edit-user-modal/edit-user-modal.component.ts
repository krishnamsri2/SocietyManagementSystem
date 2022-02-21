import { Component, Input, OnDestroy, OnInit, ViewChild } from '@angular/core';
import { FormGroup, NgForm } from '@angular/forms';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Subscription } from 'rxjs';
import { UserModel } from 'src/app/shared/user.model';
import { UserPostServices } from '../user.posts.service';

@Component({
  selector: 'app-edit-user-modal',
  templateUrl: './edit-user-modal.component.html',
  styleUrls: ['./edit-user-modal.component.css']
})
export class EditUserModalComponent implements OnInit,OnDestroy {

  //@ViewChild('f',{static:true}) updateForm : NgForm;
  @Input('userId') userDetailId : number;

  closeResult = ''; 

  public defaultUser;

  private defaultUserSubscription: Subscription;

  private updatedUser : UserModel;

  constructor(private modalService: NgbModal, private userService : UserPostServices) {}

  ngOnInit(): void {

    this.defaultUserSubscription = this.userService.getUserById(this.userDetailId).subscribe((responseData)=>{
      this.defaultUser=responseData;
      
    },error=>{
      console.log("Error in user updation",error);
    });
    
    
  }

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

  onFormSubmit(updateForm : NgForm){
    let emailId=updateForm.value.emailId;
    let phoneNumber=updateForm.value.phoneNumber;
    let firstName=updateForm.value.firstName;
    let lastName=updateForm.value.lastName;
    let userDetailId=this.userDetailId;
    this.updatedUser=new UserModel(userDetailId,firstName,lastName,phoneNumber,emailId);
    this.userService.updateUser(this.updatedUser,this.userDetailId);
  }

  ngOnDestroy(){
    this.defaultUserSubscription.unsubscribe();
  }

}
