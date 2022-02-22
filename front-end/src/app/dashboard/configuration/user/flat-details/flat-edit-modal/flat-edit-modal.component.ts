import { Component, Input, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { FlatDetailsService } from '../flat-details.service';
import { FlatEditModel } from './flat-edit.model';

@Component({
  selector: 'app-flat-edit-modal',
  templateUrl: './flat-edit-modal.component.html',
  styleUrls: ['./flat-edit-modal.component.css']
})
export class FlatEditModalComponent implements OnInit {

  @Input() flatResId : number;

  closeResult = '';
  ngOnInit(): void {
    
  }
  constructor(private modalService: NgbModal, private flatDetailsService:FlatDetailsService) {}

  open(content) {
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
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

  onFormSubmit(updateFlatForm: NgForm){

    let newIsOwner=false , newIsTenant=false;

    if(updateFlatForm.value.isOwner===""){
        newIsTenant=true;
    }

    else if(updateFlatForm.value.isTenant===""){
        newIsOwner=true;
    }

    this.flatDetailsService.updateFlat(new FlatEditModel(this.flatResId,newIsOwner,newIsTenant));
  }

}
