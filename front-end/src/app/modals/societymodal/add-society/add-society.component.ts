import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import { SocietyPostService } from '../../../dashboard/configuration/society/society.post.service';
import {v4 as uuid} from 'uuid';
@Component({
  selector: 'app-add-society',
  templateUrl: './add-society.component.html',
  styleUrls: ['./add-society.component.css']
})
export class AddSocietyComponent implements OnInit {

  closeResult = '';
  ngOnInit(): void {
    
  }
  constructor(private modalService: NgbModal,private societyPostService:SocietyPostService) {}
  society = {
    societyId:'',
    societyName:'',
    societyAddress:''
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
  onSubmit(form:NgForm ){
    let id:string = uuid();
    this.society.societyId=id;
    this.society.societyName=form.value.societyName;
    this.society.societyAddress=form.value.societyAddress;
    this.societyPostService.addSociety(this.society);
    form.reset();
  }
}
