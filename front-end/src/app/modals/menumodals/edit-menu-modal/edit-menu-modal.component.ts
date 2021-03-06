import { Content } from '@angular/compiler/src/render3/r3_ast';
import { Component, Input, OnInit } from '@angular/core';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import { MenuService } from '../../../service/menu.service';

@Component({
  selector: 'app-edit-menu-modal',
  templateUrl: './edit-menu-modal.component.html',
  styleUrls: ['./edit-menu-modal.component.css']
})
export class EditMenuModalComponent implements OnInit {

  closeResult = '';
  ngOnInit(): void {
    
  }
  @Input() menu:any;
  constructor(private modalService: NgbModal,private menuService:MenuService) {}

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
  onClick(){
    this.menuService.updateMenu(this.menu).subscribe(()=>{
      this.modalService.dismissAll();
    })
  }
}
