import { HttpClient } from '@angular/common/http';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { NgForm } from '@angular/forms';
//import { ActivatedRoute } from '@angular/router';
import { NgbModal, ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';
import { SocietyPostService } from 'src/app/dashboard/configuration/society/society.post.service';
@Component({
  selector: 'app-edit-society',
  templateUrl: './edit-society.component.html',
  styleUrls: ['./edit-society.component.css'],
})
export class EditSocietyComponent implements OnInit {
  @Input() id: number;
  @Output() reloadPage = new EventEmitter<boolean>();
  closeResult = '';
  ngOnInit(): void {}
  editSocietyReqObj = {
    token: {
      societyId: 11,
      userId: 12,
    },
    requestObject: {
      societyName: '',
    },
  };
  constructor(
    private modalService: NgbModal,
    private societyPostService: SocietyPostService,
    private http: HttpClient
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
    this.editSocietyReqObj.requestObject.societyName = form.value.societyName;
    //console.log(this.editSocietyReqObj);
    //this.societyPostService.updateSocietyName(this.id, this.editSocietyReqObj);
    this.http.put(`http://localhost:9191/society/updates/${this.id}`,this.editSocietyReqObj).subscribe(()=>{
      this.reloadPage.emit(true);
    })
  }
}
