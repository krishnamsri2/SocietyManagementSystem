import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AnnouncementModel } from '../../../shared/announcement.model';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import { AnnouncementService } from '../../../service/announcement.service';

@Component({
  selector: 'app-add-announcement-modal',
  templateUrl: './add-announcement-modal.component.html',
  styleUrls: ['./add-announcement-modal.component.css']
})
export class AddAnnouncementModalComponent implements OnInit {

  closeResult = '';
  ngOnInit(): void {
    
  }
  @Output() reloadPage = new EventEmitter<boolean>();
  constructor(private modalService: NgbModal,private announcementService:AnnouncementService) {}

  open(content) {
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
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
    let announcement:AnnouncementModel = new AnnouncementModel(null,form.value.announcementDetail);
    this.announcementService.addAnnouncement(announcement).subscribe(()=>{
      this.reloadPage.emit(true);
    });
  }
}
