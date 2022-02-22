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
        return this.http.get('',{
            responseType:'json'
        }).pipe(map((responseData:any)=>{
            return responseData;
        }),catchError((errResponse)=>{
            return throwError(errResponse);
        }));
    }

    //POST
    addFlatForAUser(newFlat: FlatDetailsModel) {
        this.requestObj.putRequestObject(newFlat);
        let flatPostObject=this.requestObj.getRequestObject();

        this.http.post(``,flatPostObject).subscribe(()=>{
            alert("Flat added successfully");
        },error=>{
            console.log("Error in adding flat for a user with userDetailId ",this.userDetailId,error);
        });
    }

    //DELETE
    deleteFlatOfAUser(flatResId: number) {
        this.http.delete('').subscribe(()=>{
            alert("Flat Deleted successfully");
        },error=>{
            console.log("Flat not deleted, flatResId is ",flatResId,error);
        });    
    }

    //PUT
    updateFlat(updatedFlat : FlatEditModel){

        this.requestObj.putRequestObject(updatedFlat);
        let flatObjWithToken=this.requestObj.getRequestObject();

        this.http.put(``,flatObjWithToken).subscribe(()=>{
            alert("Flat details updated successfully");
        },error=>{
            console.log("Error in updating flat details of a flat with flatResId and userDetailId",updatedFlat.flatResId,this.userDetailId,
            " respectively",error);
        });
    }
}