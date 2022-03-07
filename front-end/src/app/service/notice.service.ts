import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { RequestObject } from "./request.service";
import { NoticeModel } from "../shared/notice.model";
import { map } from "rxjs";

@Injectable({
    providedIn:'root'
})
export class NoticeService{
    constructor(private http:HttpClient,private requestObj:RequestObject){

    }
    addNotice(newNotice){
        this.requestObj.putRequestObject(newNotice);
        return this.http.post('http://localhost:9191/addNotice',this.requestObj.getRequestObject());
    }
    fetchNotices() {
        return this.http
          .get<{ [key: string]: NoticeModel }>(
            `http://localhost:9191/notices`,
            {
              responseType: 'json',
            }
          )
          .pipe(
            map((responseData: { [key: string]: NoticeModel }) => {
              const notice = [];
    
              for (const key in responseData) {
                if (responseData.hasOwnProperty(key)) {
                  notice.push({ ...responseData[key], serialNo: key });
                }
              }
              return notice;
            })
          );
      }
      updateNotice(noticeId:any,notice:any){
        this.requestObj.putRequestObject(notice);
        return this.http.put(`http://localhost:9191/update/${noticeId}`,this.requestObj.getRequestObject())
      }
}