import { Injectable } from "@angular/core";

@Injectable({
    providedIn:'root'
})
export class RoleService{

    addRole(newRole : string){
        console.log(newRole);
        
    }

    updateRole(userId : string,oldRole : string, newRole : string){
        console.log(userId,oldRole,newRole);
        
    }

    deleteRole(roleToBeDeleted : string){
        console.log(roleToBeDeleted);
        
    }

    getRoleByUserID(userId : string){
        console.log(userId);
        
    }
        
    getRoleTypeByUserId( userId : string ){
        console.log(userId);
        
    }
}