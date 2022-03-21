import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';
import { FlatDetailsService } from '../../../dashboard/configuration/user/flat-details/flat-details.service';
import { ComplaintService } from 'src/app/service/complaints.service';
@Component({
  selector: 'app-registered-complaints',
  templateUrl: './registered-complaints.component.html',
  styleUrls: ['./registered-complaints.component.css'],
})
export class RegisteredComplaintsComponent implements OnInit {
  public flatsOfAUser: any;

  private flatsOfAUserSubs: Subscription;

  private currentUser: any;
  constructor(
    public activeRoute: ActivatedRoute,
    private flatDetailsService: FlatDetailsService,
    private complaintService: ComplaintService
  ) {}
  ngOnInit(): void {
    this.currentUser = JSON.parse(atob(localStorage.getItem('user')));

    this.flatDetailsService.setUserDetailId(this.currentUser.userDetailId);
    this.flatsOfAUserSubs = this.flatDetailsService
      .getFlatsOfAUser(this.currentUser.userDetailId)
      .subscribe(
        (responseData) => {
          this.flatsOfAUser = responseData;
        },
        (error) => {
          console.log(
            'Error in retrieving flats of a user with user-id',
            error,
            this.flatsOfAUser
          );
        }
      );
  }
  setFlatId(flatId: number) {
    this.complaintService.setFlatId(flatId);
    console.log("hello, I'm setting the flat Id");
  }
}
