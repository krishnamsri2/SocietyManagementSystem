import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Subject } from "rxjs";
import {throwError} from 'rxjs';
import { RoleModel } from "./role.model";
import {catchError, map} from 'rxjs/operators';
import { RequestRoleObject } from "src/app/request-objects/requestRole.service";


@Injectable({
    providedIn:'root'
})
export class RoleService{
    
    private userDetailId : number;

    constructor( private http : HttpClient, private roleObj : RequestRoleObject){}

    setUserId(userDetailId: number) {
      this.userDetailId=userDetailId;
    }

    getUserID() {
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
        this.roleObj.setRoleRequestObject(newRole);
        let roleRequestObj = this.roleObj.getRoleRequestObject();

        console.log(roleRequestObj,userDetailId);
        

        return this.http.post<any>(`http://localhost:9191/userDetails/${userDetailId}/role`,roleRequestObj);
    }

    deleteRole(roleId : string){
            return this.http.delete(`http://localhost:9191/role/${roleId}`);
    }

    updateRoleDetailsByRoleId(updatedRoles: RoleModel,roleId : number) {

        this.roleObj.setRoleRequestObject(updatedRoles);
        let updatedRole = this.roleObj.getRoleRequestObject();

        return this.http.put(`http://localhost:9191/role/${roleId}`,updatedRole);
    }
}