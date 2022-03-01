import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import { FlatService } from '../../service/flat.service';
import { RequestObjectService } from '../../service/requestObject.service';
@Component({
  selector: 'app-flatmodals',
  templateUrl: './flatmodals.component.html',
  styleUrls: ['./flatmodals.component.css']
})
export class FlatmodalsComponent implements OnInit {

  closeResult = '';
  @Output() reloadPage = new EventEmitter<boolean>();
  ngOnInit(): void {
    
  }
  flatData = {
    flatNo:'',
    status:false,
    numberOfOccupant:''
  }

  constructor(private modalService: NgbModal,private requestObjectService:RequestObjectService,private flatService:FlatService,private route:ActivatedRoute) {
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
    this.flatData.flatNo = form.value.flatNo;
    //console.log(form.value.status);
    if(form.value.status === "occupied")this.flatData.status=true;
    this.flatData.numberOfOccupant = form.value.numberOfOccupant;
    this.requestObjectService.putRequestObject(this.flatData);
    this.flatService.addFlat(this.requestObjectService.getRequestObject(),this.route.snapshot.params.id).subscribe(()=>{
      this.reloadPage.emit(true);
    });
    form.reset();
  }
}
