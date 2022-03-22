import { Component, OnInit, Output } from '@angular/core';
import { EventEmitter } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ComplaintService } from 'src/app/service/complaints.service';
import { RaiseComplaintModel } from './raise-complaint.model';

@Component({
  selector: 'app-raise-complaint',
  templateUrl: './raise-complaint.component.html',
  styleUrls: ['./raise-complaint.component.css'],
})
export class RaiseComplaintComponent implements OnInit {
  @Output() reloadPage = new EventEmitter<boolean>();

  public complaintDetails: string = '';
  public complaintType: string = '';

  private flatId: number;
  closeResult = '';
  ngOnInit(): void {
    this.flatId = this.route.snapshot.params['flatId']; 
  }
  constructor(
    private modalService: NgbModal,
    private complaintService: ComplaintService,
    private route: ActivatedRoute
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

  addComplaint() {
    let userId = JSON.parse(atob(localStorage.getItem('user'))).userDetailId;
    //console.log(userId)
    let raiseComplaint = new RaiseComplaintModel(
      this.flatId,
      userId,
      this.complaintDetails,
      this.complaintType,
      JSON.parse(atob(localStorage.getItem('user'))).userDetailId
    );
    console.log(raiseComplaint);
    this.complaintService.raiseComplaint(raiseComplaint).subscribe(
      () => {
        this.reloadPage.emit(true);
      },
      (error) => {
        console.log('error in raising a complaint', error);
      }
    );
  }
}
