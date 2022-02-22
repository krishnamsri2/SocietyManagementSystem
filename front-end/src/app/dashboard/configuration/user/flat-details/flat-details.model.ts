export class FlatDetailsModel{
    public isOwner : boolean;
    public isTenant : boolean;
    public flatNo : string;
    public userDetailId : number;
    public towerName : string;

    constructor(userDetailId : number,towerName : string, flatNo : string, isOwner : boolean, isTenant : boolean){
        this.userDetailId=userDetailId;
        this.towerName=towerName;
        this.flatNo=flatNo;
        this.isOwner=isOwner;
        this.isTenant=isTenant;
    }
}