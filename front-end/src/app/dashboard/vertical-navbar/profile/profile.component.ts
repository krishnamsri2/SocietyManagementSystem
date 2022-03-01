import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  public currentUser;
  
  constructor(private activeRoute:ActivatedRoute) { }

  ngOnInit(): void {
      this.currentUser=JSON.parse(atob(localStorage.getItem("user")));
  }

  
}
