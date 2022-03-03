import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { RequestObject } from 'src/app/service/request.service';

@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.css']
})
export class ForgotPasswordComponent implements OnInit {

  public emailId : string = '';
  public errorMessage : boolean;
  public successMessage : boolean;

  public isLoading:boolean=true;
  
  closeResult = '';
  ngOnInit(): void {
    
  }
  constructor(private modalService: NgbModal,private http : HttpClient,private requestObj : RequestObject) {}

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

  onClick(){

    this.isLoading=false;
    
    this.requestObj.putRequestObject({ emailId : this.emailId });
    let forgotPasswordTO=this.requestObj.getRequestObject();

    this.http.post('http://localhost:9191/forgot',forgotPasswordTO).subscribe((response:any)=>{
      this.successMessage=true;
      this.isLoading=true;
      console.log(response);
    },error=>{
      this.errorMessage=true;
      this.isLoading=true;
    });
  }

}
