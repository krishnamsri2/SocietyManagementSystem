import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import { MenuService } from '../../../service/menu.service';

@Component({
  selector: 'app-add-menu-modal',
  templateUrl: './add-menu-modal.component.html',
  styleUrls: ['./add-menu-modal.component.css']
})
export class AddMenuModalComponent implements OnInit {

  closeResult = '';
  ngOnInit(): void {
    
  }
  menuFormData={
    url:'',
    menuName:''
  };
  constructor(private modalService: NgbModal,private menuService:MenuService) {

  }

  open(content) {
    this.modalService.open(content, {size:'lg',ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
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
  onSubmit(form:NgForm){
    this.menuFormData.url = form.value.url;
    this.menuFormData.menuName = form.value.menuName;
    console.log(this.menuFormData);
    this.menuService.addMenu(this.menuFormData);
  }
}
