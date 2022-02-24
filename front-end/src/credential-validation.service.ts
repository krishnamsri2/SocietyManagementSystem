// import { HttpHandler, HttpInterceptor, HttpRequest, HttpResponse } from "@angular/common/http";
// import { EmptyExpr } from "@angular/compiler";
// import { Injectable } from "@angular/core";
// import { appendFile } from "fs";
// import { Observable } from "rxjs";
// import { Subscription } from "rxjs";

// @Injectable()
// export class PutTokenService implements HttpInterceptor{
//     tokenSubs : Subscription;
//     token : {
//         societyId : number,
//         userId : number
//     };

//     intercept(req : HttpRequest<any>, next : HttpHandler) : Observable<HttpResponse<any>>{
//         if(req.url.includes("/login")){
//             this.tokenSubs.subscribe((responseData)=>{
//                 //localStorage.setItem(this.token,responseData.token);
//             },error=>{
//                 console.log("Error in receiving token",error);
//             });
//         }
//         else{
//              req = req.clone({body : appendFile});
//         }
//     }
// }