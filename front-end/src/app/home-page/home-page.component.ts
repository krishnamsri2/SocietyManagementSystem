import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {
  
  

  constructor(private router:Router) { }

  ngOnInit(): void {
  }

  

  onClick(){
    this.router.navigate(['dashboard']);
  }


}
