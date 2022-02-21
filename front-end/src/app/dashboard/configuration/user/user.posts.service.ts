import { Injectable } from "@angular/core";
import { NgForm } from "@angular/forms";
import { UserModel } from "src/app/shared/user.model";
import { HttpClient } from '@angular/common/http';
import {catchError, map} from "rxjs/operators";
import { Subject,throwError } from "rxjs";

@Injectable({providedIn : 'root'})
export class UserPostServices{
    

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
    
    constructor(private http: HttpClient){}
    errorMessage = new Subject<String>();

    setUserInactive(userId: number) {
        this.http.delete(`http://localhost:9191/users/delete/${userId}`).subscribe((userId)=>{
            console.log("User removed successfully with userId ",userId);
        },error=>{
            console.log("User deletion not successful",error);
        });    
    }

    addUsers(newUser){
        return this.http.post('http://localhost:9191/users/addUser',newUser,{
            responseType : 'json'
        });
    }

    updateUser(updatedUser: UserModel, userDetailId: number) {
        return this.http.put('',updatedUser).subscribe((userDetailId)=>{
            alert('User updated successfully');
        },error=>{
            alert('User not updated!!');
            console.log("Error in updating the user with id",userDetailId,error);
        });
    }

    fetchUsers(){
        return this.http.get('http://localhost:9191/users',
        {
            responseType:'json'
        }).
        pipe(map((responseData : any)=>{
            const users = [];

            for(var element in responseData){
                users.push({...responseData[element]});
                console.log(responseData[element]);
            }
            return users;
        }),catchError((errResponse)=>{
            return throwError(errResponse);
        }));
    }

    
}