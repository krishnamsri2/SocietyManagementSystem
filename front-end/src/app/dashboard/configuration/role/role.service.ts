import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Subject } from "rxjs";
import {throwError} from 'rxjs';
import { RoleModel } from "./role.model";
import {catchError, map} from 'rxjs/operators';


@Injectable({
    providedIn:'root'
})
export class RoleService{
    
    
    private userId = '-Mw5jTs2jQ0XrBBgwc0B';

    constructor( private http : HttpClient ){}

    setUserId(userId: string) {
      this.userId=userId;
    }

    getUserID(): string {
        return this.userId;
    }

    getAllRolesOfAUser(userId : string){
    //   return this.http.get<any>(`https://ng-society-management-default-rtdb.firebaseio.com/users/${userId}/roles.json`,
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
        //return this.http.get(`https://ng-society-management-default-rtdb.firebaseio.com/users/${this.userId}/roles.json`);
    }

    addRole(newRole:RoleModel){
        return this.http.post<any>(`https://ng-society-management-default-rtdb.firebaseio.com/users/${this.userId}/roles.json`,newRole);
    }

    deleteRole(roleId : string){
            return this.http.delete(`https://ng-society-management-default-rtdb.firebaseio.com/users/${this.userId}/roles/${roleId}.json`);
    }

    updateRoleDetailsByRoleId(updatedRoles: RoleModel) {
        return this.http.put(`https://ng-society-management-default-rtdb.firebaseio.com/users/${this.userId}/roles.json`,updatedRoles);
    }
}