import { Component, OnInit } from '@angular/core';
import { ComponentModel } from './component.model';
import {MatIconModule} from '@angular/material/icon';

@Component({
  selector: 'app-vertical-navbar',
  templateUrl: './vertical-navbar.component.html',
  styleUrls: ['./vertical-navbar.component.css']
})
export class VerticalNavbarComponent implements OnInit {

  isAdmin : boolean;
  sizeOfComponents : number;
  startIndex = 0;

  components : ComponentModel[] = [
    new ComponentModel('Configuration',"configuration"),
    new ComponentModel("Dummy","dummy"),
    new ComponentModel("Item3","item3")
  ];

  constructor() { }

  ngOnInit(): void {

    this.isAdmin=true; // To load components dynamically, use UserService and get the Roletype of the user. If its admin

    if(!this.isAdmin)
    this.startIndex=1;

    this.sizeOfComponents=this.components.length;

  }

}
