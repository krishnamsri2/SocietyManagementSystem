import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-role-list',
  templateUrl: './role-list.component.html',
  styleUrls: ['./role-list.component.css']
})
export class RoleListComponent implements OnInit {
  @Input() roleList:any = [];
  constructor() { }

  ngOnInit(): void {
  }
  onClick(roleId){
    this.roleList.forEach((role)=>{
      if(role.roleId===roleId){
        role.isAssigned = !role.isAssigned;
      }
    })
  }
}
