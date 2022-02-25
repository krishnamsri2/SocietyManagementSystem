import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { SocietyModel } from '../../shared/society.model';
@Component({
  selector: 'app-long-card',
  templateUrl: './long-card.component.html',
  styleUrls: ['./long-card.component.css']
})
export class LongCardComponent implements OnInit {

  @Input() object:SocietyModel;
  ngOnInit(): void {
    
  }
  constructor(private router:Router,private route:ActivatedRoute){}
  onClick(societyId){
    this.router.navigate(['towerlist',societyId],{relativeTo:this.route})
  }
}
