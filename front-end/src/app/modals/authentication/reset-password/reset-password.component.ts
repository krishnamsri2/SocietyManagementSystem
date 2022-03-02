import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-reset-password',
  templateUrl: './reset-password.component.html',
  styleUrls: ['./reset-password.component.css']
})
export class ResetPasswordComponent implements OnInit {

  public confirmPassword : string = '';
  public password : string = '';
  public hide : boolean;
  private emailId : string;
  
  public successMessage:boolean;
 
  
  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params : Params)=>{
      this.emailId=params['email'];
    });
  }
  constructor(private http : HttpClient,private activatedRoute : ActivatedRoute,private route : Router) {}

  onClick(){
    
    // this.http.post('',).subscribe((response)=>{
    //   this.successMessage=true;
    // },error=>{
    //   this.errorMessage=true;  
    //});

  }

  redirectToLogin(){
    this.route.navigate(['']);
  }

  myFunction(){
    this.hide=!this.hide;
  }

}
