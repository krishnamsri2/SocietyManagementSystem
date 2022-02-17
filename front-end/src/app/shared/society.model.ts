export class SocietyModel{
    private Id:string;
    private societyId:string;
    private societyName:string;
    private societyAddress:string;

    constructor(Id:string,societyId:string,societyName:string,societyAddress:string){
        this.Id=Id;
        this.societyId=societyId;
        this.societyName=societyName;
        this.societyAddress=societyAddress;
    }
}