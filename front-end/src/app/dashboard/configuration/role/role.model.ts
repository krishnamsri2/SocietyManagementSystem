export class RoleModel{
    private roleType: string;
    private role : string;
    private roleId : string;
    private roleDescription: string;
    private userId : string;

    constructor(roleType:string,role:string,roleDescription:string,userId:string,roleId?:string){
        this.roleId=roleId;
        this.roleType=roleType;
        this.role=role;
        this.roleDescription=roleDescription;
        this.userId=userId;
    }

    
}