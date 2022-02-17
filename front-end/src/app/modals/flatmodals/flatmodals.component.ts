import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
@Component({
  selector: 'app-flatmodals',
  templateUrl: './flatmodals.component.html',
  styleUrls: ['./flatmodals.component.css']
})
export class FlatmodalsComponent implements OnInit {

  closeResult = '';
  ngOnInit(): void {
    
  }
  constructor(private modalService: NgbModal) {}
  newFlat = {
    flat_Id:'',
    parentId:'',
    flatId:'',
    flatName:'',
    flatStatus:'',
    flatAddress:'',
    ownerName:'',
    numberOfOccupants:''
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
    let obj = form.value;
    this.newFlat.flatName=obj.flatName;
    this.newFlat.numberOfOccupants=obj.numberOfOccupants;
    this.newFlat.ownerName=obj.ownerName;
    this.newFlat.flatAddress = obj.flatAddress;
    this.newFlat.flatStatus = obj.flatStatus;
  }
}
