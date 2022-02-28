import { Component, OnInit } from '@angular/core';
import { ComponentModel } from './component.model';
import {MatIconModule} from '@angular/material/icon';
import { RoleService } from '../configuration/user/role/role.service';
import { Router } from '@angular/router';
import { UserPostServices } from '../configuration/user/user.posts.service';
import { AuthService } from 'src/app/auth.service';

@Component({
  selector: 'app-vertical-navbar',
  templateUrl: './vertical-navbar.component.html',
  styleUrls: ['./vertical-navbar.component.css']
})
export class VerticalNavbarComponent implements OnInit {

  private currentUserId : number;
  isAdmin : boolean;
  sizeOfComponents : number;
  startIndex = 0;

  components : ComponentModel[] = [new ComponentModel("Configuration","configuration")];

  constructor(private roleService : RoleService,private route : Router,private userService : UserPostServices,private authService:AuthService) { }

  ngOnInit(): void {
    //this.currentUserId=+localStorage.getItem("id");
    //this.components=this.userService.getMenuofAUser(this.currentUserId);
  }

  logoutOnClick(){
    this.authService.logout().subscribe(responseData=>{
      localStorage.removeItem("societyId");
      localStorage.removeItem("userId");
      this.route.navigate(['']);
    },error=>{
      console.log("Error in logging out",error);
    });
    
  }

}
