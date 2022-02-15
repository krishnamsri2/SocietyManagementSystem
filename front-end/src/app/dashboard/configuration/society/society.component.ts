import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-society',
  templateUrl: './society.component.html',
  styleUrls: ['./society.component.css']
})
export class SocietyComponent implements OnInit {
  
  constructor(public route:ActivatedRoute) { 
    
  }

  ngOnInit(): void {
    
  }
  
}
