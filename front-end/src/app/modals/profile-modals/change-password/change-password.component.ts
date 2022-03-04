import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { CookieService } from 'ngx-cookie-service';
import { RequestObject } from 'src/app/service/request.service';
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

  constructor(private modalService: NgbModal, private http: HttpClient,private route:Router,private requestObj:RequestObject,private cookieService : CookieService) { }

  ngOnInit(): void {
    this.currentUser = JSON.parse(atob(localStorage.getItem("user")));
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

  myFunction() {
    this.hide = !this.hide;
  }

  onClick() {
    let changePasswordTO = new ChangePasswordModel(this.currentUser.emailId, this.oldPassword, this.password);
    this.requestObj.putRequestObject(changePasswordTO);

    this.http.put(`http://localhost:9191/changePassword`, this.requestObj.getRequestObject()).subscribe((responseData) => {
      console.log("Password changed successfully",responseData);
      this.successMessage = true;
    }, error => {
      this.errorMessage = true;
      console.log(error);
    });
  }

  redirectToLogin(){
    localStorage.clear();
    this.cookieService.delete('user');
    this.route.navigate(['']);
  }

}

