import { Component, Input, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { FlatDetailsModel } from '../flat-details.model';
import { FlatDetailsService } from '../flat-details.service';

@Component({
  selector: 'app-new-flat-modal',
  templateUrl: './new-flat-modal.component.html',
  styleUrls: ['./new-flat-modal.component.css']
})
export class NewFlatModalComponent implements OnInit {

  closeResult = '';
  @Input('userId') userDetailId : number;
  ngOnInit(): void {
    
  }
  constructor(private modalService: NgbModal,private flatDetailsService: FlatDetailsService) {}

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

  onFormSubmit(flatForm: NgForm){
    let newTowerName = flatForm.value.towerName;
    let newFlatNo=flatForm.value.flatNo;
    let newIsOwner=false , newIsTenant=false;

    if(flatForm.value.isOwner===""){
        newIsTenant=true;

    }

    else if(flatForm.value.isTenant===""){
        newIsOwner=true;
    }
    
    this.flatDetailsService.addFlatForAUser(new FlatDetailsModel(this.userDetailId,newTowerName,newFlatNo,newIsOwner,newIsTenant));

  }

}
