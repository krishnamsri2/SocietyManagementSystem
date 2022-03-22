export class RaiseComplaintModel{
    private flatId : number;
    private userId: number;
    private complaintDetails:string;
    private type:string;
    private complaintId?:number;

    constructor(flatId:number,userId:number, complaintDetails:string, type:string, complaintId?:number){
        this.flatId=flatId;
        this.userId = userId;
        this.complaintDetails=complaintDetails;
        this.type=type;
        this.complaintId=complaintId;
    }
}