import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  public inUser:boolean;
  
  constructor(private activeRoute:ActivatedRoute) { }

  ngOnInit(): void {
    if(this.activeRoute.url.toString().includes('/profile'))
    {
      this.inUser=true;
      console.log("Yes possible");
    }  
  }

  currentUser(){

  }
}
