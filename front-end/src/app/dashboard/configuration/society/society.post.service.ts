import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { SocietyModel } from "../../../shared/society.model";
import { TowerListPostService } from "./tower-list/tower-list.post-services";
import {map} from "rxjs/operators";
@Injectable({
    providedIn:'root'
})
export class SocietyPostService{
    constructor(private http:HttpClient,private towerListPostService:TowerListPostService){

    }
    addSociety(newSociety:{
        societyId:string,
        societyName:String,
        societyAddress:string
    })
    {
        this.http.post('https://societymanagementsystem-8a82b-default-rtdb.firebaseio.com/society.json',newSociety)
        .subscribe((newUser)=>{
            alert('ADDED Society');
        })
    }
    fetchSocieties(){
        return this.http.get<{[ key : string ] : SocietyModel}>('https://societymanagementsystem-8a82b-default-rtdb.firebaseio.com/society.json',
        {
            responseType:'json'
        }).
        pipe(map((responseData : {[key:string] : SocietyModel})=>{
            const societies = [];

            for(const key in responseData){
                if(responseData.hasOwnProperty(key)){
                    societies.push({...responseData[key], Id : key});
                }
            }
            return societies;
        }));
    }
    deleteSociety(Id:string){
        let link:string = `https://societymanagementsystem-8a82b-default-rtdb.firebaseio.com/society/${Id}.json`;
        return this.http.delete(link);
    }
}