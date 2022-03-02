import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { catchError } from "rxjs/operators";
import {throwError} from "rxjs";
import { RequestObject } from "./service/request.service";
import { LoginModel } from "./home-page/login.model";

@Injectable({
    providedIn:'root'
})
export class AuthService{
    

    constructor(private http: HttpClient,private requestObj:RequestObject){}

    login(userName : string, password:string){
        
        this.requestObj.putRequestObject(new LoginModel(userName,password,null));
        console.log(this.requestObj.getRequestObject());

        return this.http.post('http://localhost:9191/login',this.requestObj.getRequestObject()).
        pipe(catchError(responseData=>{
            return throwError(responseData);
        }));
    }

    logout(currentUser) {
        this.requestObj.putRequestObject(currentUser);
        return this.http.put("http://localhost:9191/logout",this.requestObj.getRequestObject());
    }
}