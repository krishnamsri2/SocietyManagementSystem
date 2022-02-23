import { HttpClient, HttpClientModule } from "@angular/common/http";
import { Injectable } from "@angular/core";
import {catchError, map} from 'rxjs/operators';
import {throwError} from 'rxjs';
import { FlatDetailsModel } from "./flat-details.model";
//import { FlatDetailsObject } from "src/app/request-objects/FlatDetailsRequestObj.service";
import { FlatEditModel } from "./flat-edit-modal/flat-edit.model";
import { RequestObject } from "src/app/service/request.service";

@Injectable({
    providedIn:'root'
})
export class FlatDetailsService{
    
    private userDetailId : number;

    constructor(private http:HttpClient,private requestObj : RequestObject){}

    setUserDetailId(userDetailId : number){
        this.userDetailId=userDetailId;
    }

    getUserDetailId(){
        return this.userDetailId;
    }

    //GET
    getFlatsOfAUser(){
    
        return this.http.get(`http://localhost:9191/users/${this.userDetailId}/flatResidents`).pipe(map((responseData:any)=>{
            return responseData;
        }),catchError((errResponse)=>{
            return throwError(errResponse);
        }));
    }

    //POST
    addFlatForAUser(newFlat: FlatDetailsModel) {
        this.requestObj.putRequestObject(newFlat);
        let flatPostObject=this.requestObj.getRequestObject();

        console.log(flatPostObject);
        

        return this.http.post(`http://localhost:9191/users/flatResidents/addFlatResidents`,flatPostObject);
    }

    //DELETE
    deleteFlatOfAUser(flatResId: number) {
        return this.http.delete(`http://localhost:9191/users/flatResidents/delete/${flatResId}`);
    }

    //PUT
    updateFlat(updatedFlat : FlatDetailsModel){

        this.requestObj.putRequestObject(updatedFlat);
        let flatObjWithToken=this.requestObj.getRequestObject();

        console.log(flatObjWithToken);
        

        return this.http.put(`http://localhost:9191/users/flatResidents/update`,flatObjWithToken);
    }
}