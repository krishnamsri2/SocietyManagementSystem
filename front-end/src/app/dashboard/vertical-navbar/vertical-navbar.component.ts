import { Component, OnInit } from '@angular/core';
import { ComponentModel } from './component.model';
import {MatIconModule} from '@angular/material/icon';
import { RoleService } from '../configuration/user/role/role.service';
import { ActivatedRoute, Router } from '@angular/router';
import { UserPostServices } from '../configuration/user/user.posts.service';
import { AuthService } from 'src/app/auth.service';
import { relative } from '@angular/compiler-cli/private/localize';
import { CookieService } from 'ngx-cookie-service';

@Component({
  selector: 'app-vertical-navbar',
  templateUrl: './vertical-navbar.component.html',
  styleUrls: ['./vertical-navbar.component.css']
})
export class VerticalNavbarComponent implements OnInit {

  public currentUser;

  sizeOfComponents : number;
  startIndex = 0;

  components : ComponentModel[] = [new ComponentModel("Configuration","configuration")];

  constructor(private roleService : RoleService,private route : Router,private userService : UserPostServices,private authService:AuthService,
              private activeRoute:ActivatedRoute,private cookieService:CookieService) { }

  ngOnInit(): void {
    this.currentUser=JSON.parse(atob(localStorage.getItem("user")));
  }

  displayProfile(){
    this.route.navigate(['profile'],{relativeTo : this.activeRoute});
  }

  logoutOnClick(){
    this.authService.logout(this.currentUser).subscribe(()=>{
      localStorage.clear(); //djkfk
      this.cookieService.delete('user');
      this.route.navigate(['']);
    },error=>{
      console.log("Error in logging out",error);
    });
    
  }

}
