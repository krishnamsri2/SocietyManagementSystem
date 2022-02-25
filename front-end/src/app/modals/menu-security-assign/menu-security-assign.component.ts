import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import { MenuSecurityService } from '../../service/menu-security.service';
import { RoleModel } from '../../shared/roles.model';
import {MatIconModule} from '@angular/material/icon';


@Component({
  selector: 'app-menu-security-assign',
  templateUrl: './menu-security-assign.component.html',
  styleUrls: ['./menu-security-assign.component.css']
})
export class MenuSecurityAssignComponent implements OnInit {

  closeResult = '';
  //roles:RoleModel[]=[];
  roles:any = [];
  roleList:any = [];
  heading:string = 'All Roles';
  searchText:any;
  getRoles(){
    this.menuSecurityService.fetchAllRoles().subscribe((data)=>{
      // this.roles=data;
      console.log(data);
    })
  }
  getAllRoles(){
    this.roles = [
      {roleId:1,roleName:'Admin',roleType:'ADMIN',isAssigned:false},
      {roleId:2,roleName:'Owner',roleType:'RESIDENT',isAssigned:true},
      {roleId:3,roleName:'Tenant',roleType:'RESIDENT',isAssigned:false},
      {roleId:4,roleName:'Electrician',roleType:'WORKER',isAssigned:false},
      {roleId:5,roleName:'Secratary',roleType:'RESIDENT',isAssigned:false},
      {roleId:6,roleName:'Incharge',roleType:'WORKER',isAssigned:false},
      {roleId:7,roleName:'Guard',roleType:'WORKER',isAssigned:false},
    ]
    this.roleList = this.roles;
  }
  ngOnInit(): void {
    this.getAllRoles();
    this.getRoles();
  }
  constructor(private modalService: NgbModal,private http:HttpClient,private menuSecurityService:MenuSecurityService) {}

  open(content) {
    this.modalService.open(content, {size:'xl',ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });
  }

  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return `with: ${reason}`;
    }
  }
  onDropdownMenuClick(e){
    this.heading=e.target.innerText;
    this.roleList=this.roles;
    if(this.heading === 'Assigned Roles'){
      let newRoleList = this.roles.filter((role)=>{
        return role.isAssigned;
      })
      this.roleList = newRoleList;
    }
    else if(this.heading === 'Unassigned Roles'){
      let newRoleList = this.roles.filter((role)=>{
        return !role.isAssigned;
      })
      this.roleList = newRoleList;
    }
    else{
      this.roleList = this.roles;
    }
  }
  searchFilter=()=>{
    if(this.searchText==='')this.ngOnInit();
    else{
      let newRoleList = this.roles.filter((role)=>{
        return role.roleName.toLowerCase().includes(this.searchText.toLowerCase());
      });
      this.roleList = newRoleList;
    }
  }
}
