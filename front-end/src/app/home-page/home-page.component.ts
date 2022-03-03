import { HttpResponse } from '@angular/common/http';
import { Component, OnInit, ViewChild } from '@angular/core';
import { EmailValidator, NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';
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

  private cookie:boolean;

  constructor(private router: Router, private authService: AuthService,private userService:UserPostServices,private cookieService:CookieService) { }

  ngOnInit(): void {

    if(this.cookieService.get('user')){
      //localStorage.setItem('user',this.cookieService.get('user'));
      this.router.navigate(['dashboard']);
    }
    console.log(this.userName, this.password);
  }

  setCookies(){
    this.cookie=true;
  }

  onClick() {

      this.authService.login(this.userName, this.password).subscribe((response: any) => {

      console.log(response);

      if (response) {

        localStorage.setItem("societyId", btoa(response.societyId));
        localStorage.setItem("userId", btoa(response.userId));
        localStorage.setItem("user",btoa(JSON.stringify(response)));

        if(this.cookie){
          this.cookieService.set('user',btoa(JSON.stringify(response)),0.00347222222);
        }

        this.router.navigate(['dashboard']);
      }

      else {
        this.errorMessage = "Invalid Credentials!!!"
      }
    }, error => {
      console.log(error);
    });
  }

  myFunction(){
    this.hide=!this.hide;
  }

}
