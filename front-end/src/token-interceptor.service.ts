import { HttpHandler, HttpInterceptor, HttpRequest, HttpResponse } from "@angular/common/http";

import { Injectable } from "@angular/core";


import { Subscription } from "rxjs";

@Injectable()
export class PutTokenService implements HttpInterceptor{
    private id_token : string;
    private tokenSubs : Subscription;
    private token : {
        societyId : number,
        userId : number
    };

    intercept(req,next){
        let token_value;
        let tokenAdded = req.clone({
            setHeaders : {
                Authorization : "Bearer Token added"
            }
        });
        localStorage.setItem(token_value,'45');
        return next.handle(tokenAdded);
    }
}