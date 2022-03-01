import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-back-btn',
  templateUrl: './back-btn.component.html',
  styleUrls: ['./back-btn.component.css']
})
export class BackBtnComponent implements OnInit {
  // @Input() thisRoute:any;
  constructor(private router:Router,private route:ActivatedRoute) { }

  ngOnInit(): void {
  }
  goBack(){
    this.router.navigate(['.'],{relativeTo:this.route.parent})
  }
}
