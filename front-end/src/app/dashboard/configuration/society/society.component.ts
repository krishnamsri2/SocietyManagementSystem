import { HttpClient } from '@angular/common/http';
import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { SocietyService } from '../../../service/society.service';
import { SocietyModel } from '../../../shared/society.model';
import { SocietyPostService } from './society.post.service';
import { Location } from '@angular/common';
//import { MatIconModule } from '@angular/material/icon';
@Component({
  selector: 'app-society',
  templateUrl: './society.component.html',
  styleUrls: ['./society.component.css'],
})
export class SocietyComponent implements OnInit, OnDestroy {
  societies: SocietyModel[] = [];
  societySubscription: Subscription;
  constructor(
    public route: ActivatedRoute,
    private http: HttpClient,
    private societyPostService: SocietyPostService,
    private societyService: SocietyService,
    private router:Router,
    private location:Location
  ) {}

  ngOnInit(): void {
    this.societySubscription = this.societyPostService
      .fetchSocieties()
      .subscribe((societyData) => {
        this.societies = societyData;
        this.societyService.setSocieties(this.societies);
        // console.log(this.societies);
        console.log(societyData);
      });
  }
  ngOnDestroy(): void {
    this.societySubscription.unsubscribe();
  }
  navigateIn(societyId){
    this.router.navigate(['towerlist',societyId],{relativeTo:this.route})
  }
  goBack(){
    this.router.navigate(['../'],{relativeTo:this.route})
  }
  reloadPage(){
    this.ngOnInit();
  }
}
