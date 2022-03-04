import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { NgbModal, ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';
import { TowerListPostService } from '../../../dashboard/configuration/society/tower-list/tower-list.post-services';
import { v4 as uuid } from 'uuid';
@Component({
  selector: 'app-add-tower',
  templateUrl: './add-tower.component.html',
  styleUrls: ['./add-tower.component.css'],
})
export class AddTowerComponent implements OnInit {
  closeResult = '';
  @Output() reloadPage = new EventEmitter<boolean>();
  ngOnInit(): void {}
  constructor(
    private modalService: NgbModal,
    private route: ActivatedRoute,
    private towerListPostService: TowerListPostService
  ) {}
  towerReqObj = {
    token: {
      societyId: 11,
      userId: 12,
    },
    requestObject: {
      towerName: '',
    },
  };
  open(content) {
    this.modalService
      .open(content, { size: 'lg', ariaLabelledBy: 'modal-basic-title' })
      .result.then(
        (result) => {
          this.closeResult = `Closed with: ${result}`;
        },
        (reason) => {
          this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
        }
      );
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
  onSubmit(form: NgForm) {
    this.towerReqObj.requestObject.towerName = form.value.towerName;
    this.towerListPostService.addTower(
      this.towerReqObj,
      this.route.snapshot.params.id
    ).subscribe(()=>{
      this.reloadPage.emit(true);
    });
    form.reset();
  }
}
