import { Component, Input, OnInit } from '@angular/core';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import { AnnouncementModel } from '../../../shared/announcement.model';

@Component({
  selector: 'app-expand-announcement-modal',
  templateUrl: './expand-announcement-modal.component.html',
  styleUrls: ['./expand-announcement-modal.component.css']
})
export class ExpandAnnouncementModalComponent implements OnInit {

  closeResult = '';
  ngOnInit(): void {
    
  }
  @Input() announcementObj:AnnouncementModel;
  constructor(private modalService: NgbModal) {}

  open(content) {
    this.modalService.open(content, {size:'xl',ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
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
