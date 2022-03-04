import { HttpClient } from '@angular/common/http';
import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Subscription } from 'rxjs';
import { RequestObject } from 'src/app/service/request.service';
import { ResetPasswordModel } from './reset-password.model';

@Component({
  selector: 'app-reset-password',
  templateUrl: './reset-password.component.html',
  styleUrls: ['./reset-password.component.css']
})
export class ResetPasswordComponent implements OnInit,OnDestroy {

  public confirmPassword : string = '';
  public password : string = '';
  public hide : boolean;
  private token : string;
  
  public successMessage:boolean;
  public errorMessage:boolean;
 
  private paramsSubs : Subscription;
  
  constructor(private http : HttpClient,private activatedRoute : ActivatedRoute,private route : Router,private requestObj:RequestObject) {}

  ngOnInit(): void {
    this.paramsSubs=this.activatedRoute.queryParams.subscribe((params : Params)=>{
       this.token=params['token'];
       
     });
   }

  onClick(){

    this.requestObj.putRequestObject(new ResetPasswordModel(this.token,this.password));
    let resetPasswordTO=this.requestObj.getRequestObject();

    console.log(resetPasswordTO);
    
    this.http.post('http://localhost:9191/reset',resetPasswordTO).subscribe((response)=>{
      this.successMessage=true;
    },error=>{
      this.errorMessage=true;  
    });

  }

  redirectToLogin(){
    this.route.navigate(['']);
  }

  myFunction(){
    this.hide=!this.hide;
  }

  ngOnDestroy(){
    this.paramsSubs.unsubscribe();
  }

}
