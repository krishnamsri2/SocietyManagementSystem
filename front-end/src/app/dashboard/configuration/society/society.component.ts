import { HttpClient } from '@angular/common/http';
import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';
import { SocietyService } from '../../../service/society.service';
import { SocietyModel } from '../../../shared/society.model';
import { SocietyPostService } from './society.post.service';

@Component({
  selector: 'app-society',
  templateUrl: './society.component.html',
  styleUrls: ['./society.component.css']
})
export class SocietyComponent implements OnInit,OnDestroy {
  societies:SocietyModel[]=[];
  societySubscription:Subscription
  constructor(
    public route:ActivatedRoute,
    private http:HttpClient,
    private societyPostService:SocietyPostService,
    private societyService:SocietyService
    ) { 
  }

  ngOnInit(): void {
    this.societySubscription = this.societyPostService.fetchSocieties().subscribe((societyData)=>{
      this.societies = societyData;
      this.societyService.setSocieties(this.societies);
      // console.log(this.societies);
      console.log(societyData);
    })
  }
  ngOnDestroy(): void {
    this.societySubscription.unsubscribe();
  }
  
}
