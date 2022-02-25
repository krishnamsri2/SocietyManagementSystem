import { HttpResponse } from '@angular/common/http';
import { Component, OnInit, ViewChild } from '@angular/core';
import { EmailValidator, NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/auth.service';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  public userName:string='';
  public password:string='';
  public errorMessage:string='';
  
  constructor(private router:Router,private authService : AuthService) { }

  ngOnInit(): void {
    console.log(this.userName,this.password);
    
  }

  onClick(){

    // this.authService.login(this.userName,this.password).subscribe((response:HttpResponse<any>)=>{
    //   localStorage.setItem("token",response.headers.get('token'));
    //   localStorage.setItem("id",response.userDetailId);
    //   let menuList = response.headers.get('list');

    //   this.router.navigate(['dashboard']);   
    // },error=>{
    //   this.errorMessage=error;
    // });
    
    this.router.navigate(['dashboard']);
  }


}
