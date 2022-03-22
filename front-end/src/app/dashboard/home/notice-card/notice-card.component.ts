import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { NoticeService } from '../../../service/notice.service';
@Component({
  selector: 'app-notice-card',
  templateUrl: './notice-card.component.html',
  styleUrls: ['./notice-card.component.css']
})
export class NoticeCardComponent implements OnInit {


  constructor(private noticeService:NoticeService,private datePipe:DatePipe) { }
  notices:any[]=[]
  ngOnInit(): void {
    this.noticeService.fetchNotices().subscribe((data)=>{
      this.notices=data;
      this.notices.forEach((elem)=>{
        elem.updatedDate = this.datePipe.transform(elem.updatedDate,'short');
      })
      this.notices.reverse();
    })
  }

}
