import { Injectable } from "@angular/core";
import { NgForm } from "@angular/forms";
import { UserModel } from "src/app/shared/user.model";
import { HttpClient } from '@angular/common/http';
import {catchError, map} from "rxjs/operators";
import { Subject,throwError } from "rxjs";
import { RequestObject } from "src/app/service/request.service";

@Injectable({providedIn : 'root'})
export class UserPostServices{

    public currentUser : UserModel;
    
    constructor(private http: HttpClient,private requestObj : RequestObject){}
    errorMessage = new Subject<String>();

    // setCurrentUser(user : UserModel){
    //     this.currentUser=new UserModel(user.firstName,user.lastName,user.phoneNumber,user.emailId,user.userDetailId,user.societyId);
    // }

    // getCurrentUser(){
    //     return this.currentUser;
    // }

    deleteCurrentUser(){
        delete this.currentUser;
    }
    //POST
    addUsers(newUser){
        this.requestObj.putRequestObject(newUser);
        let userObjWithToken=this.requestObj.getRequestObject();
        return this.http.post('http://localhost:9191/users/addUser',userObjWithToken,{
            responseType : 'json'
        });
    }

    //PUT
    updateUser(updatedUser: UserModel) {

        this.requestObj.putRequestObject(updatedUser);
        let updatedUserRequestObj;
        updatedUserRequestObj=this.requestObj.getRequestObject();

        return this.http.put(`http://localhost:9191/users/update`,updatedUserRequestObj);
    }


    //GET
    fetchUsers(){
        return this.http.get('http://localhost:9191/users',
        {
            responseType:'json'
        }).
        pipe(map((responseData : any)=>{
            const users = [];

            for(var element in responseData){
                users.push({...responseData[element]});
                //console.log(responseData[element]);
            }
            return users;
        }),catchError((errResponse)=>{
            return throwError(errResponse);
        }));
    }

    getUserById(userDetailId: number)  {
        return this.http.get<any>(`http://localhost:9191/users/${userDetailId}`,
        {
            responseType:'json'
        }).
        pipe(map((responseData: any)=>{
            return responseData;
        }),catchError((errResponse)=>{
            return throwError(errResponse);
        }));
    }

    getMenuofAUser(userDetailId:number){
        return this.http.get<any>('',{
            responseType:'json'
        }).pipe(map((responseData)=>{
            return responseData;
        }),catchError((errorResponse)=>{
            return throwError(errorResponse);
        }));
    }

    //DELETE
    setUserInactive(userId: number) {
        return this.http.delete(`http://localhost:9191/users/delete/${userId}`);
    }
    
}