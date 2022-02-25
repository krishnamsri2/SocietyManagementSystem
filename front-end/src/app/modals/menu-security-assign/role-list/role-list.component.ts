import { Component, Input, OnInit } from '@angular/core';
import { MenuSecurityService } from '../../../service/menu-security.service';

@Component({
  selector: 'app-role-list',
  templateUrl: './role-list.component.html',
  styleUrls: ['./role-list.component.css']
})
export class RoleListComponent implements OnInit {
  @Input() roleList:any = [];
  @Input() menuId:any;
  constructor(private menuSecurityService:MenuSecurityService) { }
  mapObj = {
    roleId:'',
    menuId:'',
  }
  ngOnInit(): void {
  }
  onClick(e,roleId){
    this.roleList.forEach((role)=>{
      if(role.roleId===roleId){
        role.menuAssigned = !role.menuAssigned;
      }
    })
    this.mapObj.roleId = roleId;
    this.mapObj.menuId = this.menuId;
    if(e.target.innerText==='Assign')
      this.menuSecurityService.assignRoles(this.mapObj);
    else
      this.menuSecurityService.deAssignRoles(this.mapObj);
  }
}
