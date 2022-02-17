import { Injectable, OnDestroy, OnInit } from "@angular/core";
import { Subscription } from "rxjs";
import { SocietyPostService } from "../dashboard/configuration/society/society.post.service";
import { SocietyModel } from "../shared/society.model";

@Injectable({
    providedIn:'root'
})
export class SocietyService implements OnDestroy{
    
    societySubscription : Subscription;
    societies : SocietyModel[] = [];

    constructor(private userPostService : SocietyPostService){}

    setSocieties(societies : SocietyModel[]){
        this.societies=societies;
    }

    ngOnDestroy(){
        this.societySubscription.unsubscribe();
    }
    
}