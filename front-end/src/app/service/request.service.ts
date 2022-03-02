import { Injectable } from "@angular/core";

@Injectable({
    providedIn: 'root'
})
export class RequestObject {

    // private societyId=+btoa(localStorage.getItem("societyId"));
    // private userId=+btoa(localStorage.getItem("userId"));

    public request = {
        token: {
            societyId: 11,
            userId: 12
        },
        requestObject: {
        }
    }

    putRequestObject(object){
        this.request.requestObject=object;
    }

    getRequestObject(){
        return this.request;
    }

}