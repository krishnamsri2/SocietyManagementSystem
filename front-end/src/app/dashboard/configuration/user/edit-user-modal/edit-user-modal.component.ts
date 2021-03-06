import { Component, Input, OnDestroy, OnInit, Output, ViewChild } from '@angular/core';
import { FormGroup, NgForm } from '@angular/forms';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Subscription } from 'rxjs';

import { UserModel } from 'src/app/shared/user.model';
import { EventEmitter } from '@angular/core';
import { UserPostServices } from '../user.posts.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-edit-user-modal',
  templateUrl: './edit-user-modal.component.html',
  styleUrls: ['./edit-user-modal.component.css']
})
export class EditUserModalComponent implements OnInit, OnDestroy {

  @Input('userDetailId') userDetailId: number;

  @Output() reloadPage = new EventEmitter<boolean>();

  closeResult = '';

  public defaultUser;

  private defaultUserSubscription: Subscription;
  private updatedUserSubs: Subscription;

  private updatedUser: UserModel;

  constructor(private modalService: NgbModal, private userService: UserPostServices, private activeRoute: ActivatedRoute) { }

  ngOnInit(): void {
    console.log(this.userDetailId);
    this.defaultUserSubscription = this.userService.getUserById(this.userDetailId).subscribe((responseData) => {
      this.defaultUser = responseData;
      console.log(this.defaultUser);
    }, error => {
      console.log("Error in user updation", error);
    });

  }

  open(content) {
    this.modalService.open(content, { ariaLabelledBy: 'modal-basic-title' }).result.then((result) => {
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

  onClick() {

    this.defaultUserSubscription = this.userService.updateUser(this.defaultUser).subscribe((response) => {
      console.log("User updated", response);
      this.reloadPage.emit(true);
    }, error => {
      alert('User not updated!!');
      console.log("Error in updating the user with id", this.userDetailId, error);
    });;
  }

  ngOnDestroy() {

  }

}
