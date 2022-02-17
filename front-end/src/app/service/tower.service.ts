import { Subscription } from "rxjs";

import { UserPostServices } from "../dashboard/configuration/user/user.posts.service";
import { TowerModel } from "../shared/tower.model";
import { Injectable,OnDestroy } from "@angular/core";
@Injectable({
    providedIn:'root'
})
export class UserService implements OnDestroy{
    
    towerSubscription : Subscription;
    towers : TowerModel[] = [];

    constructor(private userPostService : UserPostServices){}

    setUsers(towers : TowerModel[]){
        this.towers=towers;
        console.log(towers);
    }

    ngOnDestroy(){
        this.towerSubscription.unsubscribe();
    }
    
}