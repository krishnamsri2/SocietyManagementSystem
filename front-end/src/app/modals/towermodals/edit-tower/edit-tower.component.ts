import { Component, Input, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import { TowerListPostService } from '../../../dashboard/configuration/society/tower-list/tower-list.post-services';
@Component({
  selector: 'app-edit-tower',
  templateUrl: './edit-tower.component.html',
  styleUrls: ['./edit-tower.component.css']
})
export class EditTowerComponent implements OnInit {
  @Input() towerId:number ;
  closeResult = '';
  ngOnInit(): void {
  }
  constructor(private modalService: NgbModal,private route:ActivatedRoute,private towerListPostService:TowerListPostService) {

  }
  editTowerReqObj = {
    token:{
    societyId:11,
    userId:12
    },
    requestObject:{
    towerId:0,
    towerName:''
    }
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
    this.editTowerReqObj.requestObject.towerName = form.value.towerName;
    this.editTowerReqObj.requestObject.towerId = this.towerId;
    this.towerListPostService.updateTowerDetails(this.towerId,this.editTowerReqObj);
    form.reset();
  }


}
