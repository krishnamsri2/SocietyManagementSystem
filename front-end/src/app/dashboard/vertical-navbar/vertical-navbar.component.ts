import { Component, OnInit } from '@angular/core';
import { ComponentModel } from './component.model';
import {MatIconModule} from '@angular/material/icon';
import { RoleService } from '../configuration/user/role/role.service';
import { ActivatedRoute, Router } from '@angular/router';
import { UserPostServices } from '../configuration/user/user.posts.service';
import { AuthService } from 'src/app/auth.service';
import { relative } from '@angular/compiler-cli/private/localize';

@Component({
  selector: 'app-vertical-navbar',
  templateUrl: './vertical-navbar.component.html',
  styleUrls: ['./vertical-navbar.component.css']
})
export class VerticalNavbarComponent implements OnInit {

  public firstName:string;
  public lastName:string;
  isAdmin : boolean;
  sizeOfComponents : number;
  startIndex = 0;

  components : ComponentModel[] = [new ComponentModel("Configuration","configuration")];

  constructor(private roleService : RoleService,private route : Router,private userService : UserPostServices,private authService:AuthService,
              private activeRoute:ActivatedRoute) { }

  ngOnInit(): void {
    this.firstName=this.userService.getCurrentUser().firstName;
    this.lastName=this.userService.getCurrentUser().lastName;
    //this.components=this.userService.getMenuofAUser(this.currentUserId);
  }

  displayProfile(){
    this.route.navigate(['profile'],{relativeTo : this.activeRoute});
  }

  logoutOnClick(){
    this.authService.logout().subscribe(responseData=>{
      localStorage.clear();
      this.userService.deleteCurrentUser();
      this.route.navigate(['']);
    },error=>{
      console.log("Error in logging out",error);
    });
    
  }

}
