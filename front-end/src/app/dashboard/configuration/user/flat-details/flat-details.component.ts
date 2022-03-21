import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';

import { FlatDetailsModel } from './flat-details.model';
import { FlatDetailsService } from './flat-details.service';

@Component({
  selector: 'app-flat-details',
  templateUrl: './flat-details.component.html',
  styleUrls: ['./flat-details.component.css']
})
export class FlatDetailsComponent implements OnInit, OnDestroy {

  public flatsOfAUser: any;
  public userDetailId: number;
  private flatsOfAUserSubs: Subscription;
  private flatDeleteSubs : Subscription;

  constructor(private flatDetailsService: FlatDetailsService,private route:ActivatedRoute) { }

  flatDetails() {
    
    this.flatsOfAUserSubs = this.flatDetailsService.getFlatsOfAUser(this.userDetailId).subscribe((responseData) => {
      this.flatsOfAUser = responseData;
      console.log(this.flatsOfAUser);
    }, error => {
      console.log("Error in retrieving flats of a user with user-id", this.userDetailId, error, this.flatsOfAUser);
    });

  }

  ngOnInit(): void {
    this.userDetailId = this.route.snapshot.params['userDetailId'];
    console.log(this.userDetailId);
    console.log("hello everyoneeee")
    this.flatDetails();
  }

  deleteFlatOnClick(flatResId: number) {
    this.flatDeleteSubs=this.flatDetailsService.deleteFlatOfAUser(flatResId).subscribe(() => {
      //alert("Flat Deleted successfully");
      this.flatDetails();
    }, error => {
      console.log("Flat not deleted, flatResId is ", flatResId, error);
    });;
    
  }

  ngOnDestroy() {
    this.flatsOfAUserSubs.unsubscribe();
  }

}
