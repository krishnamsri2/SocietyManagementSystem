import { Component, OnInit } from '@angular/core';
import { ComponentModel } from './component.model';

@Component({
  selector: 'app-vertical-navbar',
  templateUrl: './vertical-navbar.component.html',
  styleUrls: ['./vertical-navbar.component.css']
})
export class VerticalNavbarComponent implements OnInit {

  components : ComponentModel[] = [];

  constructor() { }

  ngOnInit(): void {
  }

}
