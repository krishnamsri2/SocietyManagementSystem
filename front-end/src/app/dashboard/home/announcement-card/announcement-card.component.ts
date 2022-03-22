import { Component, OnInit } from '@angular/core';
import { AnnouncementService } from '../../../service/announcement.service';


@Component({
  selector: 'app-announcement-card',
  templateUrl: './announcement-card.component.html',
  styleUrls: ['./announcement-card.component.css']
})
export class AnnouncementCardComponent implements OnInit {

  constructor(private announcementService:AnnouncementService) { }
  announcements:any[]=[]
  ngOnInit(): void {
    this.announcementService.fetchAnnouncements().subscribe((data)=>{
      this.announcements = data;
    })
  }

}
