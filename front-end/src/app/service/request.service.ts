import { Injectable } from "@angular/core";

@Injectable({
    providedIn: 'root'
})
export class RequestObject {

    public request = {
        token: {
            societyId: 20,
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