import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FlatService } from '../../../../service/flat.service';
import { FlatIdServices } from '../../../../service/flat.id.services';
import { FlatModel } from '../../../../shared/flat.model';

@Component({
  selector: 'app-tower',
  templateUrl: './tower.component.html',
  styleUrls: ['./tower.component.css']
})
export class TowerComponent implements OnInit {
  id:number = 1;
  towerId:string;
  societyId:string;
  flats:FlatModel[] = [];
  constructor(private router:Router,public route:ActivatedRoute,private http:HttpClient,private flatIdService:FlatIdServices,private flatServices:FlatService) {
    this.towerId=this.route.snapshot.params.id;
    this.societyId = flatIdService.getSocietyId();
  }

  ngOnInit(): void {
    this.flatServices.fetchFlats(this.towerId).subscribe((data)=>{
      this.flats = data;
      console.log(this.flats);
    })
  }
  onFlatClick(flatId:string){
    //this.router.navigate([`/dashboard/configuration/society/towerlist/1/flat/${this.id}`]);
    console.log(console.log())
  }
}
