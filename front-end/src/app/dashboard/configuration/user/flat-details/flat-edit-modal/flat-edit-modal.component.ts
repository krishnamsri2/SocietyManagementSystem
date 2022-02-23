import { Component, Input, OnInit, Output } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { EventEmitter } from '@angular/core';
import { FlatDetailsService } from '../flat-details.service';
import { FlatEditModel } from './flat-edit.model';
import { Subscription } from 'rxjs';
import { FlatDetailsModel } from '../flat-details.model';

@Component({
  selector: 'app-flat-edit-modal',
  templateUrl: './flat-edit-modal.component.html',
  styleUrls: ['./flat-edit-modal.component.css']
})
export class FlatEditModalComponent implements OnInit {

  @Input() flatResId: number;
  @Output() reloadPage1 = new EventEmitter<boolean>();
  
  private flatDetailsSubs : Subscription;

  public isOwner='false'; 
  public isTenant='false';

  closeResult = '';
  ngOnInit(): void {

  }
  constructor(private modalService: NgbModal, private flatDetailsService: FlatDetailsService) { }

  open(content) {
    this.modalService.open(content, { ariaLabelledBy: 'modal-basic-title' }).result.then((result) => {
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

  onClick() {

    //console.log(this.isOwner,this.isTenant);

    let boolean_owner=false, boolean_tenant=false;

    if(this.isOwner==='owner'){
      boolean_owner=true;
      boolean_tenant=false;
    }
    
    else if(this.isTenant==='tenant'){
      boolean_tenant=true;
      boolean_owner=false;
    }

    console.log(boolean_owner,boolean_tenant);
    
    this.isOwner='false';
    this.isTenant='false';

    this.flatDetailsSubs=this.flatDetailsService.updateFlat(new FlatDetailsModel(null,null,null,boolean_owner,boolean_tenant,this.flatResId))
      .subscribe(() => {
        //alert("Flat details updated successfully");
        this.reloadPage1.emit(true);
      }, error => {
        console.log("Error in updating flat details of a flat with flatResId", this.flatResId,
          " respectively", error);
      });
  }

}
