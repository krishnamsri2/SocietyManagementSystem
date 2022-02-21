import { Injectable } from "@angular/core";

@Injectable({
    providedIn: 'root'
})
export class RequestRoleObject {
    
    public roleRequest = {
        token: {
            societyId: 1,
            userId : 112
        },

        requestObject:{
            roleType : '',
            role : '',
            roleDescription : ''
        }
    }

    setRoleRequestObject(newRole){
        this.roleRequest.requestObject.roleType=newRole.roleType;
        this.roleRequest.requestObject.role=newRole.role;
        this.roleRequest.requestObject.roleDescription=newRole.roleDescription;
    }

    getRoleRequestObject(){
        return this.roleRequest;
    }
}