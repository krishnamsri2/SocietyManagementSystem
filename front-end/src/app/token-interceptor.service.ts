import { HttpHandler, HttpHeaders, HttpInterceptor, HttpRequest, HttpResponse } from "@angular/common/http";

import { Injectable } from "@angular/core";

@Injectable()
export class PutTokenService implements HttpInterceptor{
    
    intercept(req,next){

        if(req.url.includes("login"))
        return next.handle(req);
        
        const newRequest=req.clone({
            headers : req.headers.set('societyId',`${+atob(localStorage.getItem("societyId"))}`).set('userId',`${+atob(localStorage.getItem("userId"))}`).
            set('Access-Control-Allow-Origin','*').set('Access-Control-Allow-Credentials','true').set('Access-Control-Allow-Methods' , 'GET, POST, OPTIONS')
            .set('Access-Control-Allow-Headers' , 'Origin, Content-Type, Accept, X-Custom-Header, Upgrade-Insecure-Requests')

            
        });
        //console.log(newRequest);
        
        return next.handle(newRequest);
        
    }
}