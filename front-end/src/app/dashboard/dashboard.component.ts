import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  public tokenValueSocietyId=localStorage.getItem("societyId");
  public tokenValueUserId=localStorage.getItem("userId");
  
  constructor(private route:Router) { }

  ngOnInit(): void {
    if(!this.tokenValueSocietyId&&!this.tokenValueUserId)
    {
      this.route.navigate(['']);
      
      
    }
  }

}
