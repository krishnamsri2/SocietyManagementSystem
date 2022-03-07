import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';
import { ComplaintService } from 'src/app/service/complaints.service';
import { FlatDetailsService } from '../configuration/user/flat-details/flat-details.service';

@Component({
  selector: 'app-complaints',
  templateUrl: './complaints.component.html',
  styleUrls: ['./complaints.component.css']
})
export class ComplaintsComponent implements OnInit {

  public flatsOfAUser:any;

  private flatsOfAUserSubs:Subscription;

  private currentUser:any;

  constructor(public activeRoute: ActivatedRoute,private flatDetailsService:FlatDetailsService,private complaintService:ComplaintService) { }

  ngOnInit(): void {

    this.currentUser=JSON.parse(atob(localStorage.getItem('user')));
    
    this.flatDetailsService.setUserDetailId(this.currentUser.userDetailId);
    
    this.flatsOfAUserSubs = this.flatDetailsService.getFlatsOfAUser(this.currentUser.userDetailId).subscribe((responseData) => {
      this.flatsOfAUser = responseData;
    }, error => {
      console.log("Error in retrieving flats of a user with user-id", error, this.flatsOfAUser);
    });
  }

  setFlatId(flatId:number){
    this.complaintService.setFlatId(flatId);
    console.log("hello, I'm setting the flat Id");
  }

}
