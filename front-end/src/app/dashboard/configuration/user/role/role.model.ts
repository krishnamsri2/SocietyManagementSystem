export class RoleModel{
    public roleType: string;
    public role : string;
    public roleId? : number;
    public roleDescription: string;
    public userDetailId?: number;

    constructor(roleType:string,role:string,roleDescription:string,userDetailId?:number,roleId?:number){
        this.roleId=roleId;
        this.roleType=roleType;
        this.role=role;
        this.roleDescription=roleDescription;
        this.userDetailId=userDetailId;
    }

    
}