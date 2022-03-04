import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { NgForm } from '@angular/forms';
import { NgbModal, ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';
import { AnnouncementService } from '../../../service/announcement.service';

@Component({
  selector: 'app-edit-announcement-modal',
  templateUrl: './edit-announcement-modal.component.html',
  styleUrls: ['./edit-announcement-modal.component.css'],
})
export class EditAnnouncementModalComponent implements OnInit {
  closeResult = '';
  ngOnInit(): void {}
  constructor(
    private modalService: NgbModal,
    private announcementService: AnnouncementService
  ) {}
  @Input() announcement: any;
  @Output() reloadPage = new EventEmitter<boolean>();
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
    this.announcement.announcementDetail = form.value.announcementDetail;
    this.announcementService
      .updateAnnouncement(this.announcement.announcementId, this.announcement)
      .subscribe(() => {
        this.reloadPage.emit(true);
      });
  }
}
