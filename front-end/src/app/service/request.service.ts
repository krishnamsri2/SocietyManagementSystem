import { Injectable, OnInit } from "@angular/core";

@Injectable({
    providedIn: 'root'
})
export class RequestObject implements OnInit{

    private societyId:number;
    private userId:number;

    ngOnInit(){
        
    }

    public request = {
        token: {
            societyId: null,
            userId: null
        },
        requestObject: {
        }
    }

    putRequestObject(object){

        this.societyId=+atob(localStorage.getItem("societyId"));
        this.userId=+atob(localStorage.getItem("userId"));
        console.log(this.societyId,this.userId);

        this.request.requestObject=object;

        // if(!this.societyId)
        // this.societyId=null;

        // if(!this.userId)
        // this.userId=null;

        this.request.token.societyId=this.societyId;
        this.request.token.userId=this.userId;

        console.log(this.societyId,this.userId,typeof(null));
    }

    getRequestObject(){
        return this.request;
    }

}