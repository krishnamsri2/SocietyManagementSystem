import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-flat',
  templateUrl: './flat.component.html',
  styleUrls: ['./flat.component.css']
})
export class FlatComponent implements OnInit {

  constructor(private route:ActivatedRoute) {
    console.log(this.route.snapshot);
   }

  ngOnInit(): void {
  }

}
