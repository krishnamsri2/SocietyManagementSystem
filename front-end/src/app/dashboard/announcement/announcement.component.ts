import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { AnnouncementModel } from '../../shared/announcement.model';
import { AnnouncementService } from '../../service/announcement.service';

@Component({
  selector: 'app-announcement',
  templateUrl: './announcement.component.html',
  styleUrls: ['./announcement.component.css']
})
export class AnnouncementComponent implements OnInit {
  announcements:AnnouncementModel[] = []
  constructor(private announcementService:AnnouncementService) { }

  ngOnInit(): void {
    this.announcementService.fetchAnnouncements().subscribe((data)=>{
      this.announcements = data;
      console.log(data);
    })
  }
  reload(){
    this.ngOnInit();
  }

}
