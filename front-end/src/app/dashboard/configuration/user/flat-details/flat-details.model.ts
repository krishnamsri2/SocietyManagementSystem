export class FlatDetailsModel{
    public isOwner : boolean;
    public isTenant : boolean;
    public flatNo : string;
    public userDetailId : number;
    public towerName : string;
    public flatResId? : number;

    constructor(userDetailId : number,towerName : string, flatNo : string, isOwner : boolean, isTenant : boolean,flatResId? : number){
        this.userDetailId=userDetailId;
        this.towerName=towerName;
        this.flatNo=flatNo;
        this.isOwner=isOwner;
        this.isTenant=isTenant;
        this.flatResId=flatResId;
    }
}