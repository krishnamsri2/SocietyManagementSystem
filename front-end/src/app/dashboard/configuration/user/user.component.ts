import { Component, Input, OnDestroy, OnInit, ViewChild } from '@angular/core';
import { FormGroup, NgForm } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { Subscription } from 'rxjs';
import { UserModel } from 'src/app/shared/user.model';
import { UserService } from 'src/app/user.service';
import { UserPostServices } from './user.posts.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit,OnDestroy {

  users : UserModel[];

  userSubscription : Subscription;
  
  constructor(public activeRoute : ActivatedRoute,private userService : UserService, private userPostService : UserPostServices){
  }

  ngOnInit(){
    this.userSubscription = this.userPostService.fetchUsers().subscribe((userData)=>{
      this.users=userData;
      this.userService.setUsers(this.users);
      //console.log(this.users);
    });
  }

  ngOnDestroy(){
    this.userSubscription.unsubscribe();
  }

}
