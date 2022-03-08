import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";

import {throwError} from 'rxjs';
import { RoleModel } from "./role.model";
import {catchError, map} from 'rxjs/operators';
//import { RequestrequestObject } from "src/app/request-objects/requestRole.service";
import { RequestObject } from "src/app/service/request.service";


@Injectable({
    providedIn:'root'
})
export class RoleService{
    
    private userDetailId : number;

    constructor( private http : HttpClient, private requestObj : RequestObject){}

    setUserDetailId(userDetailId: number) {
      this.userDetailId=userDetailId;
    }

    getUserDetailID() {
        return this.userDetailId;
    }

    getAllRolesOfAUser(userDetailId : number){
      return this.http.get<any>(`http://localhost:9191/roles/${userDetailId}`,
      {
          responseType:'json'
      }).
      pipe(map((responseData:any)=>{
          const rolesOfUser  = [];

          responseData.forEach(element => {
              rolesOfUser.push(element);
          });

          return rolesOfUser;

      }),catchError((errResponse)=>{
        return throwError(errResponse); 
      }));
    }

    getRoleDetailsByRoleId(roleId: number) {
        return this.http.get(`http://localhost:9191/role/${roleId}`,{
            responseType : 'json'
        }).pipe(map((responseData:any)=>{
            return responseData;
        }),catchError((errResponse)=>{
            return throwError(errResponse); 
        }));
    }

    addRole(newRole:RoleModel,userDetailId : number){
        this.requestObj.putRequestObject(newRole);
        let roleRequestObj = this.requestObj.getRequestObject();

        console.log(roleRequestObj,userDetailId);
        

        return this.http.post<any>(`http://localhost:9191/userDetails/${userDetailId}/role`,roleRequestObj);
    }

    activateDeactivateRole(roleId : number){
            return this.http.delete(`http://localhost:9191/role/deactivate_activate/${roleId}`);
    }

    updateRoleDetailsByRoleId(updatedRoles: RoleModel,roleId : number) {

        this.requestObj.putRequestObject(updatedRoles);
        let updatedRole = this.requestObj.getRequestObject();

        return this.http.put(`http://localhost:9191/role/${roleId}`,updatedRole);
    }
}