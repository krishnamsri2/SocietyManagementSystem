import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { FlatDetailsService } from './flat-details.service';

@Component({
  selector: 'app-flat-details',
  templateUrl: './flat-details.component.html',
  styleUrls: ['./flat-details.component.css']
})
export class FlatDetailsComponent implements OnInit {

  public flatsOfAUser;
  public userDetailId : number;
  private flatsOfAUserSubs : Subscription;

  constructor(private flatDetailsService : FlatDetailsService) { }

  ngOnInit(): void {
    this.userDetailId=this.flatDetailsService.getUserDetailId();
    this.flatsOfAUserSubs=this.flatDetailsService.getFlatsOfAUser().subscribe((responseData)=>{
      this.flatsOfAUser=responseData;
    },error=>{
      console.log("Error in retrieving flats of a user with user-id ",this.userDetailId,error);
    });
  }


}
