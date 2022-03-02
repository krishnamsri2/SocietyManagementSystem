import { Injectable } from "@angular/core";

@Injectable({
    providedIn: 'root'
})
export class RequestObject {

    private societyId=+atob(localStorage.getItem("societyId"));
    private userId=+atob(localStorage.getItem("userId"));

    public request = {
        token: {
            societyId: this.societyId,
            userId: this.userId
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