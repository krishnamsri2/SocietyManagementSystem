import { HttpClient } from "@angular/common/http";
import { Inject, Injectable } from "@angular/core";
import { RaiseComplaintModel } from "../modals/complaints/raise-complaint/raise-complaint.model";
import { RequestObject } from "./request.service";

@Injectable({
    providedIn:'root'
})
export class ComplaintService{
    
    private flatId:number;

    setFlatId(flatId: number) {
        this.flatId=flatId
    }

    getFlatId() {
        return this.flatId;
    }

    constructor(private http:HttpClient,private requestObj:RequestObject){}

    //POST
    raiseComplaint(complaint:RaiseComplaintModel){
        this.requestObj.putRequestObject(complaint);
        let complaintTO=this.requestObj.getRequestObject();

        return this.http.post('http://localhost:9191/addComplaint',complaintTO);
    }

    //GET
    getComplaints(flatId){
        return this.http.get(`http://localhost:9191/myComplaints/${flatId}`);
    }

    getComplaintHistory(complaintId : number) {
        return this.http.get<any[]>(`http://localhost:9191/complaintHistory/${complaintId}`);
    }
}