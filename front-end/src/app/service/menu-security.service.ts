import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { RoleModel } from '../shared/roles.model';
import { map } from 'rxjs';
import { RequestObjectService } from './requestObject.service';
@Injectable({
  providedIn: 'root',
})
export class MenuSecurityService {
  constructor(
    private http: HttpClient,
    private requestObject: RequestObjectService
  ) {}
  fetchAllRoles(menuId) {
    return this.http
      .get<{ [key: string]: RoleModel }>(`http://localhost:9191/status/${menuId}`, {
        responseType: 'json',
      })
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
  assignRoles(mapObj: any) {
    this.requestObject.putRequestObject(mapObj);
    this.http
      .post(
        `http://localhost:9191/assignMenu`,
        this.requestObject.getRequestObject()
      )
      .subscribe(() => {
        alert('Mapped');
      });
  }
  deAssignRoles(mapObj:any){
    this.requestObject.putRequestObject(mapObj);
    console.log(this.requestObject.getRequestObject());
    // this.requestObject.putRequestObject(mapObj);
    this.http.put(`http://localhost:9191/unassignMenu`,this.requestObject.getRequestObject()).subscribe(()=>{
      alert('unassigned');
    })
  }
}
