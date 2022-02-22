import { HttpClient } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { NgbModal, ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';
import { FlatModel } from '../../../shared/flat.model';
import { FlatIdServices } from '../../../service/flat.id.services';
import { FlatService } from '../../../service/flat.service';
import { NgForm } from '@angular/forms';
import { RequestObjectService } from '../../../service/requestObject.service';

@Component({
  selector: 'app-edit-flat-modal',
  templateUrl: './edit-flat-modal.component.html',
  styleUrls: ['./edit-flat-modal.component.css'],
})
export class EditFlatModalComponent implements OnInit {
  parentId: string;
  @Input() flatId: string;
  flatObj: any;
  closeResult = '';
  ngOnInit(): void {
    this.http
      .get(
        `http://localhost:9191/society/${this.flatIdService.getSocietyId()}/tower/${
          this.route.snapshot.params.id
        }/flat/${this.flatId}`
      )
      .subscribe((data) => {
        this.flatObj = data;
        this.flatObj.flatStatus = '';
        if (this.flatObj.status == true) this.flatObj.flatStatus = 'occupied';
        else this.flatObj.flatStatus = 'unoccupied';
        console.log(this.flatObj);
      });
  }
  constructor(
    private modalService: NgbModal,
    private flatIdService: FlatIdServices,
    private flatService: FlatService,
    private route: ActivatedRoute,
    private http: HttpClient,
    private requestObject: RequestObjectService
  ) {}

  open(content) {
    this.modalService
      .open(content, { ariaLabelledBy: 'modal-basic-title' })
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
    if (form.value.formStatus === 'occupied') this.flatObj.status = true;
    else this.flatObj.status = false;
    this.flatObj.flatNo = form.value.flatNo;
    this.flatObj.numberOfOccupants = form.value.numberOfOccupant;
    this.flatObj.formStatus = null;
    this.requestObject.putRequestObject(this.flatObj);
    this.flatService.updateFlatDetails(
      this.flatId,
      this.route.snapshot.params.id,
      this.flatIdService.getSocietyId(),
      this.requestObject.getRequestObject()
    );
    //console.log(this.requestObject.getRequestObject())
    //console.log(this.flatObj);
  }
}
