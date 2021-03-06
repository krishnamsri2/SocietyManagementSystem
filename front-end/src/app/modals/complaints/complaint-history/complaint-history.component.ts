import { Component, Input, OnInit } from '@angular/core';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ComplaintService } from 'src/app/service/complaints.service';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-complaint-history',
  templateUrl: './complaint-history.component.html',
  styleUrls: ['./complaint-history.component.css']
})
export class ComplaintHistoryComponent implements OnInit {

  @Input() complaintId: number;

  private flatId: number;

  public complaintHistory: any;

  closeResult = '';
  ngOnInit(): void {
    this.flatId = this.complaintService.getFlatId();
    this.complaintService.getComplaintHistory(this.complaintId).subscribe((responseData) => {
      //console.log(responseData);
      this.complaintHistory = responseData;
      this.complaintHistory.reverse();
      this.complaintHistory.forEach(element => {
        element.modifiedStatus=this.datePipe.transform(element.modifiedStatus,'long');
      });
      console.log(this.complaintHistory);
    }, error => {
      console.log("Error in getting complaint History", error);
    });
  }
  constructor(private modalService: NgbModal, private complaintService: ComplaintService,private datePipe:DatePipe) { }

  open(content) {
    this.modalService.open(content, {size:'lg', ariaLabelledBy: 'modal-basic-title' }).result.then((result) => {
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



}
