export class SocietyModel{
    private serialNo:string;
    private societyId:number;
    private societyName:string;
    private createdBy:number;
    private createdDate:string;

    constructor(serialNo:string,societyId:number,societyName:string,createdBy:number,createdDate:string){
        this.serialNo=serialNo;
        this.societyId=societyId;
        this.societyName=societyName;
        this.createdBy=createdBy;
        this.createdDate=createdDate;
        
    }
}