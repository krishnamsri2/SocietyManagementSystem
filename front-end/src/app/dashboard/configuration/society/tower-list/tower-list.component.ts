import { HttpClient } from '@angular/common/http';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { TowerModel } from '../../../../shared/tower.model';
import { TowerListPostService } from './tower-list.post-services';

@Component({
  selector: 'app-tower-list',
  templateUrl: './tower-list.component.html',
  styleUrls: ['./tower-list.component.css']
})
export class TowerListComponent implements OnInit {
  towers:TowerModel[] = [];
  societyName:string='';
  constructor(public route:ActivatedRoute,private towerListPostService:TowerListPostService,private http:HttpClient) {
    
  }

  ngOnInit(): void {
    this.towerListPostService.fetchTowers(this.route.snapshot.params.id).subscribe((towerData)=>{
      this.towers=towerData;
      console.log(this.towers);
    });
    this.http.get<string>(`https://societymanagementsystem-8a82b-default-rtdb.firebaseio.com/society/${this.route.snapshot.params.id}/societyName.json`)
    .subscribe((data)=>{
      this.societyName = data;
    })
  }
  
}
