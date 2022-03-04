import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { RequestObject } from "./request.service";
import { AnnouncementModel } from "../shared/announcement.model";
import { map } from "rxjs"; 
@Injectable({
    providedIn:'root'
})
export class AnnouncementService{

    constructor(private http:HttpClient,private requestObject:RequestObject){

    }
    addAnnouncement(newAnncouncement){
        //console.log(newAnncouncement);
        this.requestObject.putRequestObject(newAnncouncement);
        //console.log(this.requestObject.getRequestObject());
        return this.http.post(`http://localhost:9191/addAnnouncement`,this.requestObject.getRequestObject());
    }
    fetchAnnouncements() {
        return this.http
          .get<{ [key: string]: AnnouncementModel }>(
            `http://localhost:9191/announcements`,
            {
              responseType: 'json',
            }
          )
          .pipe(
            map((responseData: { [key: string]: AnnouncementModel }) => {
              const announcement = [];
    
              for (const key in responseData) {
                if (responseData.hasOwnProperty(key)) {
                  announcement.push({ ...responseData[key], serialNo: key });
                }
              }
              return announcement;
            })
          );
      }
      updateAnnouncement(announcementId:any,newAnnouncement){
        //console.log(newAnnouncement,announcementId);
        this.requestObject.putRequestObject(newAnnouncement)
        return this.http.put(`http://localhost:9191/updateAnnouncement/${announcementId}`,this.requestObject.getRequestObject());
      }
}