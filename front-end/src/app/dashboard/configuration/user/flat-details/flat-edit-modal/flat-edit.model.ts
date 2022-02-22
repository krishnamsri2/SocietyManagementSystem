export class FlatEditModel{
    public isOwner : boolean;
    public isTenant : boolean;
    public flatResId : number;

    constructor(flatResId : number, isOwner : boolean, isTenant : boolean){
        this.isOwner=isOwner;
        this.isTenant=isTenant;
        this.flatResId=flatResId;
    }
}