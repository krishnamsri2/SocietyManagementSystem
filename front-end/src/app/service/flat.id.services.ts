import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";

@Injectable({
    providedIn:'root'
})
export class FlatIdServices{
    constructor(private http:HttpClient){
        
    }
    societyId:string;
    putSocietyId(societyId:string){
        this.societyId=societyId;
    }
    getSocietyId(){
        return this.societyId;
    }
    // addFlat(newFlat){
    //     this.http.post(``).subscribe(()=>{
    //         alert("Flat Added")
    //     })
    // }
}