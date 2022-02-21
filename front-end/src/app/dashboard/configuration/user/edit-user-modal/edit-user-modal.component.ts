import { Component, Input, OnInit, ViewChild } from '@angular/core';
import { FormGroup, NgForm } from '@angular/forms';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { UserModel } from 'src/app/shared/user.model';
import { UserPostServices } from '../user.posts.service';

@Component({
  selector: 'app-edit-user-modal',
  templateUrl: './edit-user-modal.component.html',
  styleUrls: ['./edit-user-modal.component.css']
})
export class EditUserModalComponent implements OnInit {

  @ViewChild('f',{static:false}) updateForm : NgForm;
  @Input('userId') userDetailId : number;

  closeResult = '';
  public defaultUser;

  private updatedUser : UserModel;

  constructor(private modalService: NgbModal, private userService : UserPostServices) {}

  ngOnInit(): void {

    this.defaultUser=this.userService.getUserById(this.userDetailId);
    // console.log(this.defaultUser);
    //  setTimeout(()=>{
    //   this.updateForm.setValue(this.defaultUser);
      
    //  });
    
    //console.log("hello");
    
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
    // console.log(this.updateForm);
    this.updatedUser.emailId=updateForm.value.emailId;
    this.updatedUser.phoneNumber=updateForm.value.phoneNumber;
    this.updatedUser.firstName=updateForm.value.firstName;
    this.updatedUser.lastName=updateForm.value.lastName;
    this.updatedUser.flatNumber=null;
    this.updatedUser.towerNumber=null;
    this.updatedUser.userDetailId=this.userDetailId;

    this.userService.updateUser(this.updatedUser,this.userDetailId);
    
    updateForm.reset();  
  }

}
