import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { RoleService } from '../configuration/user/role/role.service';

@Component({
  selector: 'app-complaints',
  templateUrl: './complaints.component.html',
  styleUrls: ['./complaints.component.css'],
})
export class ComplaintsComponent implements OnInit {
  constructor(public activeRoute: ActivatedRoute,private roleService:RoleService) {}
  roles:any[] = [];
  isUser:boolean=false;
  isWorker:boolean=false;;
  ngOnInit(): void {
    let currentUser = JSON.parse(atob(localStorage.getItem('user')));
    this.roleService.getAllRolesOfAUser(currentUser.userDetailId).subscribe((data)=>{
      this.roles = data;
      console.log(this.roles);
      this.roles.forEach((role)=>{
        if(role.roleType==='RESIDENT'){
          this.isUser = true;
        }
        if(role.roleType==='WORKER'){
          this.isWorker = true;
        }
      })
    })
  }
}
