import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-tower',
  templateUrl: './tower.component.html',
  styleUrls: ['./tower.component.css']
})
export class TowerComponent implements OnInit {
  id:number = 1;
  constructor(private router:Router,public route:ActivatedRoute) { }

  ngOnInit(): void {
  }
  onFlatClick(){
    this.router.navigate([`/dashboard/configuration/society/towerlist/1/flat/${this.id}`]);
  }
}
