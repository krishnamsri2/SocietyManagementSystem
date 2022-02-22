import { Injectable } from "@angular/core";

@Injectable({
    providedIn:'root'
})
export class FlatDetailsObject{
    public flatDetailsRequest = {
        token: {
            societyId: 1,
            userId : 112
        },

        requestObject:{
            userDetailId : '',
            towerName : '',
            flatNo : '',
            isOwner : '',
            isTenant : ''
        }
    }

    setFlatDetailsRequestObject(newFlat){
        this.flatDetailsRequest.requestObject.userDetailId=newFlat.userDetailId;
        this.flatDetailsRequest.requestObject.towerName=newFlat.towerName;
        this.flatDetailsRequest.requestObject.flatNo=newFlat.flatNo;
        this.flatDetailsRequest.requestObject.isOwner=newFlat.isOwner;
        this.flatDetailsRequest.requestObject.isTenant=newFlat.isTenant;
    }

    getFlatDetailsRequestObject(){
        return this.flatDetailsRequest;
    }
}