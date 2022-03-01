import { HttpClient } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { NgbModal, ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';
import { MenuSecurityService } from '../../service/menu-security.service';
import { RoleModel } from '../../shared/roles.model';
import { MatIconModule } from '@angular/material/icon';

@Component({
  selector: 'app-menu-security-assign',
  templateUrl: './menu-security-assign.component.html',
  styleUrls: ['./menu-security-assign.component.css'],
})
export class MenuSecurityAssignComponent implements OnInit {
  closeResult = '';
  //roles:RoleModel[]=[];
  roles: any = [];
  roleList: any = [];
  heading: string = 'All Roles';
  searchText: any;
  @Input() menuId: any;
  getRoles() {
    this.menuSecurityService.fetchAllRoles(this.menuId).subscribe((data) => {
    this.roles = data;
    this.roleList = this.roles;
    });
  }
  ngOnInit(): void {
    this.getRoles();
  }
  constructor(
    private modalService: NgbModal,
    private http: HttpClient,
    private menuSecurityService: MenuSecurityService
  ) {}

  open(content) {
    this.modalService
      .open(content, { size: 'xl', ariaLabelledBy: 'modal-basic-title' })
      .result.then(
        (result) => {
          this.closeResult = `Closed with: ${result}`;
        },
        (reason) => {
          this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
        }
      );
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
  onDropdownMenuClick(e) {
    this.heading = e.target.innerText;
    this.roleList = this.roles;
    if (this.heading === 'Assigned Roles') {
      let newRoleList = this.roles.filter((role) => {
        return role.status;
      });
      this.roleList = newRoleList;
    } else if (this.heading === 'Unassigned Roles') {
      let newRoleList = this.roles.filter((role) => {
        return !role.status;
      });
      this.roleList = newRoleList;
    } else {
      this.roleList = this.roles;
    }
  }
  searchFilter = () => {
    if (this.searchText === '') this.ngOnInit();
    else {
      let newRoleList = this.roles.filter((role) => {
        return role.role.toLowerCase().includes(this.searchText.toLowerCase());
      });
      this.roleList = newRoleList;
    }
  };
}
