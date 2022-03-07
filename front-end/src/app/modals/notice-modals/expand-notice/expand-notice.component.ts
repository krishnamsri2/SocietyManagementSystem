import { Component, Input, OnInit } from '@angular/core';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import { NoticeModel } from '../../../shared/notice.model';

@Component({
  selector: 'app-expand-notice',
  templateUrl: './expand-notice.component.html',
  styleUrls: ['./expand-notice.component.css']
})
export class ExpandNoticeComponent implements OnInit {

  closeResult = '';
  @Input() notice:NoticeModel;
  currentUser:any;
  ngOnInit(): void {
    this.currentUser = JSON.parse(atob(localStorage.getItem('user')));
    console.log(this.currentUser);
    console.log(this.notice);
  }
  constructor(private modalService: NgbModal) {}

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

}
