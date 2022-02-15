import { Injectable, OnDestroy, OnInit } from "@angular/core";
import { Subscription } from "rxjs";

import { UserPostServices } from "./dashboard/configuration/user/user.posts.service";
import { UserModel } from "./shared/user.model";

@Injectable({
    providedIn:'root'
})
export class UserService implements OnDestroy{
    
    userSubscription : Subscription;
    users : UserModel[] = [];

    constructor(private userPostService : UserPostServices){}

    setUsers(users : UserModel[]){
        this.users=users;
        console.log(users);
    }

    ngOnDestroy(){
        this.userSubscription.unsubscribe();
    }
    
}