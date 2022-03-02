import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ChangePasswordModel } from './change-password.model';

@Component({
  selector: 'app-change-password',
  templateUrl: './change-password.component.html',
  styleUrls: ['./change-password.component.css']
})
export class ChangePasswordComponent implements OnInit {

  public hide: boolean;

  public oldPassword: string = '';
  public password: string = '';
  public confirmPassword: string = '';

  public successMessage: boolean;
  public errorMessage: boolean;

  private currentUser;

  closeResult = '';
  ngOnInit(): void {
    this.currentUser = JSON.parse(atob(localStorage.getItem("user")));
  }
  constructor(private modalService: NgbModal, private http: HttpClient) { }

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

  myFunction() {
    this.hide = !this.hide;
  }

  onClick() {
    let changePasswordTO = new ChangePasswordModel(this.currentUser.emailId, this.oldPassword, this.password);
    console.log(changePasswordTO);
    //   this.http.post(``,changePasswordTO).subscribe((responseData)=>{
    //     this.successMessage=true;
    //   },error=>{
    //     this.errorMessage=true;
    //     console.log(error);
    //   });
    // }

  }
}
