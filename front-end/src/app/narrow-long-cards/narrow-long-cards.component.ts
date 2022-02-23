import { Component, Input, OnInit } from '@angular/core';
import { MenuModel } from '../shared/menu.model';

@Component({
  selector: 'app-narrow-long-cards',
  templateUrl: './narrow-long-cards.component.html',
  styleUrls: ['./narrow-long-cards.component.css']
})
export class NarrowLongCardsComponent implements OnInit {

  constructor() { }
  @Input() data:MenuModel;
  ngOnInit(): void {
    console.log(this.data);
  }

}
