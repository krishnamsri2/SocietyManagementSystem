export class SocietyModel{
    public serialNo:string;
    public societyId:number;
    public societyName:string;
    public createdBy:number;
    public createdDate:string;

    constructor(serialNo:string,societyId:number,societyName:string,createdBy:number,createdDate:string){
        this.serialNo=serialNo;
        this.societyId=societyId;
        this.societyName=societyName;
        this.createdBy=createdBy;
        this.createdDate=createdDate;
        
    }
}