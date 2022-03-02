import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { FlatDetailsService } from '../../configuration/user/flat-details/flat-details.service';
import { UserPostServices } from '../../configuration/user/user.posts.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  public currentUser;

  public flatDetails;
  
  constructor(private activeRoute:ActivatedRoute,private flatDetailsService : FlatDetailsService,private userService : UserPostServices) { }

  setCurrentUser(){
    this.userService.getUserById(this.currentUser.userDetailId).subscribe((response)=>{
      this.currentUser=response;
      localStorage.setItem("user",btoa(JSON.stringify(this.currentUser)));
    },error=>{
      console.log("Error in getting the updated user",error);
    });

  }

  setCurrentUserFlats(){
    this.flatDetailsService.setUserDetailId(this.currentUser.userDetailId);
    this.flatDetailsService.getFlatsOfAUser().subscribe((response)=>{
      this.flatDetails=response;
    },error=>{
      console.log("Error in retrieving flats of a user");
    });

  }

  ngOnInit(): void {

    this.currentUser=JSON.parse(atob(localStorage.getItem("user")));

    this.setCurrentUser();

    this.setCurrentUserFlats();

    this.currentUser=JSON.parse(atob(localStorage.getItem("user")));
  }

  onReload(reloadPage:boolean){
    this.ngOnInit();
    //location.reload();
  }
  
}
