import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { RoleModel } from "../shared/roles.model";
import { map } from "rxjs";
@Injectable({
    providedIn:'root'
})
export class MenuSecurityService{
    constructor(private http:HttpClient){

    }
    fetchAllRoles() {
        return this.http
          .get<{ [key: string]: RoleModel }>(
            `http://localhost:9191/getAllRoles`,
            {
              responseType: 'json',
            }
          )
          .pipe(
            map((responseData: { [key: string]: RoleModel }) => {
              const flat = [];
    
              for (const key in responseData) {
                if (responseData.hasOwnProperty(key)) {
                  flat.push({ ...responseData[key], serialNo: key });
                }
              }
              return flat;
            })
          );
      }
}