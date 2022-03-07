import { Component, OnInit } from '@angular/core';
import { NoticeService } from '../../../service/notice.service';
import { NoticeModel } from '../../../shared/notice.model';
@Component({
  selector: 'app-create-notice',
  templateUrl: './create-notice.component.html',
  styleUrls: ['./create-notice.component.css']
})
export class CreateNoticeComponent implements OnInit {

  constructor(private noticeService:NoticeService) { }
  currentUser:any;
  ngOnInit(): void {
    this.currentUser = JSON.parse(atob(localStorage.getItem('user')));
    //console.log(this.currentUser);
  }
  noticeObj = {
    noticeDetail:'',
    userId:0
  }
  onClick(){
    let newNotice = new NoticeModel(this.noticeObj.noticeDetail,this.currentUser.userId,null);
    this.noticeService.addNotice(newNotice).subscribe(()=>{
      alert('Added');
    })
  }
}
