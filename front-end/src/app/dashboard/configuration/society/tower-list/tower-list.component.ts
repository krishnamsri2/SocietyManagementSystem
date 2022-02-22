import { HttpClient } from '@angular/common/http';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { FlatIdServices } from '../../../../service/flat.id.services';
import { TowerModel } from '../../../../shared/tower.model';
import { TowerListPostService } from './tower-list.post-services';
//import { SocietyModel } from '../society.component';
@Component({
  selector: 'app-tower-list',
  templateUrl: './tower-list.component.html',
  styleUrls: ['./tower-list.component.css'],
})
export class TowerListComponent implements OnInit {
  towers: TowerModel[] = [];
  parentId: string;
  societyName: string = '';
  constructor(
    public route: ActivatedRoute,
    private towerListPostService: TowerListPostService,
    private http: HttpClient,
    private flatIdServices: FlatIdServices
  ) {
    this.parentId = this.route.snapshot.params.id;
  }

  ngOnInit(): void {
    this.towerListPostService
      .fetchTowers(this.route.snapshot.params.id)
      .subscribe((towerData) => {
        this.towers = towerData;
        console.log(this.towers);
      });
    this.http
      .get<any>(`http://localhost:9191/society/${this.parentId}`)
      .subscribe((societyData) => {
        this.societyName = societyData.societyName;
      });
    this.flatIdServices.putSocietyId(this.parentId);
  }
}
