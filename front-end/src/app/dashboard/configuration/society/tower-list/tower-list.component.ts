import { Component, EventEmitter, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-tower-list',
  templateUrl: './tower-list.component.html',
  styleUrls: ['./tower-list.component.css']
})
export class TowerListComponent implements OnInit {
  constructor() { }

  ngOnInit(): void {
  }
  towers = [
    {
      id:1,
      name:'Tower A',
      address:'Tower Address',
      description:'Some Description'
    },
    {
      id:2,
      name:'Tower B',
      address:'Tower Address',
      description:'Some Description'
    },
    {
      id:3,
      name:'Tower C',
      address:'Tower Address',
      description:'Some Description'
    },
    {
      id:4,
      name:'Tower D',
      address:'Tower Address',
      description:'Some Description'
    }
  ]
}
