export class RaiseComplaintModel{
    private flatId : number;
    private complaintDetails:string;
    private type:string;
    private complaintId?:number;

    constructor(flatId:number, complaintDetails:string, type:string, complaintId?:number){
        this.flatId=flatId;
        this.complaintDetails=complaintDetails;
        this.type=type;
        this.complaintId=complaintId;
    }
}