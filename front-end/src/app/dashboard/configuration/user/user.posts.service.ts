import { Injectable } from "@angular/core";
import { NgForm } from "@angular/forms";
import { UserModel } from "src/app/shared/user.model";
import { HttpClient } from '@angular/common/http';
import {map} from "rxjs/operators";

@Injectable({providedIn : 'root'})
export class UserPostServices{

    constructor(private http: HttpClient){}

    addUsers(newUser :{
        firstName: string,
        lastName: string,
        email: string,
        towerNumber: string,
        flatNumber: number,
        roleType:string,
        phoneNumber: number
    }){
        this.http.post<any>('https://ng-society-management-default-rtdb.firebaseio.com/users.json',newUser).
        subscribe((newUser)=>{
            alert('User registered successfully');
        });
        
        
    }

    fetchUsers(){
        return this.http.get<{[ key : string ] : UserModel}>('https://ng-society-management-default-rtdb.firebaseio.com/users.json',
        {
            responseType:'json'
        }).
        pipe(map((responseData : {[key:string] : UserModel})=>{
            const users = [];

            for(const key in responseData){
                if(responseData.hasOwnProperty(key)){
                    users.push({...responseData[key], userId : key});
                }
            }
            return users;
        }));
    }
}