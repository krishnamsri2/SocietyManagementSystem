export class RoleModel{
    private roleId:number;
    private roleType:string;
    private role:string;
    private roleDescription:string;
    private serialNo:string;

    constructor(roleId:string,roleType:string,role:string,roleDescription:string){
        this.roleId = +roleId;
        this.roleType = roleType;
        this.role = role;
        this.roleDescription = roleDescription;
    }
}