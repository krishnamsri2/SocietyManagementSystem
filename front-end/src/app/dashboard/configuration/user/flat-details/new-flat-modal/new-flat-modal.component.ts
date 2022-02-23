import { Component, Input, OnInit, Output } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { EventEmitter } from '@angular/core';
import { FlatDetailsModel } from '../flat-details.model';
import { FlatDetailsService } from '../flat-details.service';

@Component({
  selector: 'app-new-flat-modal',
  templateUrl: './new-flat-modal.component.html',
  styleUrls: ['./new-flat-modal.component.css']
})
export class NewFlatModalComponent implements OnInit {

  closeResult = '';
  @Input('userId') userDetailId: number;
  @Output() reloadPage = new EventEmitter<boolean>();

  public flatModel;

  ngOnInit(): void {
    this.flatModel=new FlatDetailsModel(null,'','',false,false);
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
    
    this.flatDetailsService.addFlatForAUser(this.flatModel)
      .subscribe(() => {
        alert("Flat added successfully");
        this.reloadPage.emit(true);
        setTimeout(()=>{
          this.flatModel=new FlatDetailsModel(null,'','',false,false);
        })
      }, error => {
        console.log("Error in adding flat for a user with userDetailId ", this.userDetailId, error);
      });;

  }

}
