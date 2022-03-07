import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-profile-card',
  templateUrl: './profile-card.component.html',
  styleUrls: ['./profile-card.component.css']
})
export class ProfileCardComponent implements OnInit {

  constructor() { }
  currentUser:any;
  ngOnInit(): void {
    this.currentUser = JSON.parse(atob(localStorage.getItem('user')));
  }

}
