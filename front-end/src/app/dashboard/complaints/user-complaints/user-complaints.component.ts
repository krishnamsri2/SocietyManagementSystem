import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';
import { ComplaintService } from 'src/app/service/complaints.service';
import { FlatDetailsService } from '../../configuration/user/flat-details/flat-details.service';
import { ComplaintsComponent } from '../complaints.component';

@Component({
  selector: 'app-user-complaints',
  templateUrl: './user-complaints.component.html',
  styleUrls: ['./user-complaints.component.css']
})
export class UserComplaintsComponent implements OnInit {

  private flatId:number;

  public complaints:any;

  constructor(public activeRoute: ActivatedRoute,private flatDetailsService:FlatDetailsService,private complaintService:ComplaintService) { }

  ngOnInit(): void {
    this.flatId=this.activeRoute.snapshot.params['flatId'];
    this.getComplaints();
  }

  getComplaints(){
    console.log(this.flatId);
    this.complaintService.getComplaints(this.flatId).subscribe((responseData)=>{
      console.log(responseData);
      this.complaints=responseData;
    },error=>{
      console.log("Error in retrieving complaints of a flat",error);
    })
  }
  
  
}
