import { HttpClient, HttpClientModule } from "@angular/common/http";
import { Injectable } from "@angular/core";
import {catchError, map} from 'rxjs/operators';
import {throwError} from 'rxjs';
import { FlatDetailsModel } from "./flat-details.model";
import { FlatDetailsObject } from "src/app/request-objects/FlatDetailsOfUser.service";

@Injectable({
    providedIn:'root'
})
export class FlatDetailsService{
    
    private userDetailId : number;

    constructor(private http:HttpClient,private flatObj : FlatDetailsObject){}

    setUserDetailId(userDetailId : number){
        this.userDetailId=userDetailId;
    }

    getUserDetailId(){
        return this.userDetailId;
    }

    getFlatsOfAUser(){
        return this.http.get('',{
            responseType:'json'
        }).pipe(map((responseData:any)=>{
            return responseData;
        }),catchError((errResponse)=>{
            return throwError(errResponse);
        }));
    }

    addFlatForAUser(newFlat: FlatDetailsModel) {
        this.flatObj.setFlatDetailsRequestObject(newFlat);
        let flatPostObject=this.flatObj.getFlatDetailsRequestObject();

        this.http.post(``,flatPostObject).subscribe(()=>{
            alert("Flat added successfully");
        },error=>{
            console.log("Error in adding flat for a user with userDetailId ",this.userDetailId,error);
        });
    }
}