import { Content } from '@angular/compiler/src/render3/r3_ast';
import { Component, Input, OnInit } from '@angular/core';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import { NoticeService } from '../../../service/notice.service';
import { NoticeModel } from '../../../shared/notice.model';

@Component({
  selector: 'app-edit-notice',
  templateUrl: './edit-notice.component.html',
  styleUrls: ['./edit-notice.component.css']
})
export class EditNoticeComponent implements OnInit {

  closeResult = '';
  @Input() notice:any;
  
  userId:any;
  ngOnInit(): void {
    this.userId  = JSON.parse(atob(localStorage.getItem('user'))).userId;
  }
  constructor(private modalService: NgbModal,private noticeService:NoticeService) {}

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
  onClick(modal){
    this.noticeService.updateNotice(this.notice.noticeId,this.notice).subscribe(()=>{
      modal.close();
    });
  }
}
