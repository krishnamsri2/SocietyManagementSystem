import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { TowerModel } from "../../../../shared/tower.model";
import {map} from 'rxjs/operators';
//import { ActivatedRoute } from "@angular/router";
@Injectable({
    providedIn:'root'
})
export class TowerListPostService{
    towers:TowerModel[] = [];
    constructor(private http:HttpClient){
    }
    addTower(newTower:{
        parentId:string,
        towerId:string,
        towerName:string,
        towerAddress:string
    }){
        this.http.post(`https://societymanagementsystem-8a82b-default-rtdb.firebaseio.com/society/${newTower.parentId}/tower.json`,newTower)
        .subscribe(()=>{
            alert('Added tower');
        })
    };
    fetchTowers(parentId:string){
        return this.http.get<{[ key : string ] : TowerModel}>(`http://localhost:9191/society/updates/${parentId}`,
        {
            responseType:'json'
        }).
        pipe(map((responseData : {[key:string] : TowerModel})=>{
            const tower = [];

            for(const key in responseData){
                if(responseData.hasOwnProperty(key)){
                    tower.push({...responseData[key], serialNo : key});
                }
            }
            return tower;
        }));
    }
}