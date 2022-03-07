import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { RequestObjectService } from "./requestObject.service";
import { MenuModel } from "../shared/menu.model";
import { map } from "rxjs";
@Injectable({
    providedIn:'root'
})
export class MenuService{
    constructor(private http:HttpClient,private requestObject:RequestObjectService){

    }
    addMenu(newMenu){
        this.requestObject.putRequestObject(newMenu);
        //console.log(this.requestObject.getRequestObject());
        return this.http.post(`http://localhost:9191/addMenu`,this.requestObject.getRequestObject());
    }
    fetchMenus() {
        return this.http
          .get<{ [key: string]: MenuModel }>(
            `http://localhost:9191/menus`,
            {
              responseType: 'json',
            }
          )
          .pipe(
            map((responseData: { [key: string]: MenuModel }) => {
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
      updateMenu(menu){
        this.requestObject.putRequestObject(menu);
        return this.http.put(`http://localhost:9191/updateMenu/${menu.menuId}`,this.requestObject.getRequestObject());
      }
}