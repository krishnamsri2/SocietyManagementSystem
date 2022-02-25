import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { catchError } from "rxjs/operators";
import {throwError} from "rxjs";

@Injectable({
    providedIn:'root'
})
export class AuthService{

    constructor(private http: HttpClient){}

    login(userName : string, password:string){
        return this.http.post('',{"userName":userName,"password":password}).
        pipe(catchError(responseData=>{
            return throwError("Invalid Credentials");
        }));
    }

    
}