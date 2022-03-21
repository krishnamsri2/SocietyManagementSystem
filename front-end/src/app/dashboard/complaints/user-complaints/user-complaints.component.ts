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
  close:boolean=true;
  constructor(public activeRoute: ActivatedRoute,private flatDetailsService:FlatDetailsService,private complaintService:ComplaintService) { }
  userDetailId;
  ngOnInit(): void {
    this.flatId=this.activeRoute.snapshot.params['flatId'];
    this.getComplaints();
    this.close=true;
    this.userDetailId = JSON.parse(atob(localStorage.getItem('user'))).userDetailId;
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
  action(status,complaintId){
    this.close=false;
    this.complaintService.taskActions(this.userDetailId,complaintId,status).subscribe(()=>{
      this.ngOnInit();
    })
  }
  
}
