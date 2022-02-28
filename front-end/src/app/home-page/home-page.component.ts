import { HttpResponse } from '@angular/common/http';
import { Component, OnInit, ViewChild } from '@angular/core';
import { EmailValidator, NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/auth.service';
import { UserPostServices } from '../dashboard/configuration/user/user.posts.service';
import { LoginModel } from './login.model';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  public userName: string = '';
  public password: string = '';
  public errorMessage: string = '';

  public hide: boolean;

  constructor(private router: Router, private authService: AuthService,private userService:UserPostServices) { }

  ngOnInit(): void {
    console.log(this.userName, this.password);

  }

  onClick() {

      this.authService.login(this.userName, this.password).subscribe((response: any) => {

      console.log(response);

      if (response) {
        localStorage.setItem("societyId", btoa(response.societyId));
        localStorage.setItem("userId", btoa(response.userId));
        this.userService.setCurrentUser(response);
        this.router.navigate(['dashboard']);
      }

      else {
        this.errorMessage = "Invalid Credentials!!!"
      }
    }, error => {
      //this.errorMessage=error;
      console.log(error);
    });

    //this.router.navigate(['dashboard']);
  }

  myFunction(){
    this.hide=!this.hide;
  }

}
