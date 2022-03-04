import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NoticeService } from '../../../service/notice.service';
import { NoticeModel } from '../../../shared/notice.model';

@Component({
  selector: 'app-show-notice',
  templateUrl: './show-notice.component.html',
  styleUrls: ['./show-notice.component.css']
})
export class ShowNoticeComponent implements OnInit {

  constructor(private noticeService:NoticeService) { }
  notices:NoticeModel[] = [];
  ngOnInit(): void {
    this.noticeService.fetchNotices().subscribe((data)=>{
      this.notices = data;
    })
  }

}
