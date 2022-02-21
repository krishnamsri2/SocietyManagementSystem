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

    getAllRolesOfAUser(userDetailId : string){
    //   return this.http.get<any>(`https://ng-society-management-default-rtdb.firebaseio.com/users/${userDetailId}/roles.json`,
    //   {
    //       responseType:'json'
    //   }).
    //   pipe(map((responseData : { [key:string] : RoleModel})=>{
    //       const rolesOfUser  = [];

    //       for(const key in responseData){
    //           if(responseData.hasOwnProperty(key)){
    //               rolesOfUser.push(...rolesOfUser[key]);
    //           }
    //       }
    //       return rolesOfUser;
    //   }),catchError((errResponse)=>{
    //     return throwError(errResponse); 
    //   }));
    }

    getRoleDetailsByRoleId(roleId: string) {
        //return this.http.get(`https://ng-society-management-default-rtdb.firebaseio.com/users/${this.userDetailId}/roles.json`);
    }

    addRole(newRole:RoleModel,userDetailId : number){
        this.roleObj.setRoleRequestObject(newRole);
        let roleRequestObj = this.roleObj.getRoleRequestObject();

        console.log(roleRequestObj,userDetailId);
        

        return this.http.post<any>(`http://localhost:9191/userDetails/${userDetailId}/role`,roleRequestObj);
    }

    deleteRole(roleId : string){
            return this.http.delete(`https://ng-society-management-default-rtdb.firebaseio.com/users/${this.userDetailId}/roles/${roleId}.json`);
    }

    updateRoleDetailsByRoleId(updatedRoles: RoleModel) {
        return this.http.put(`https://ng-society-management-default-rtdb.firebaseio.com/users/${this.userDetailId}/roles.json`,updatedRoles);
    }
}