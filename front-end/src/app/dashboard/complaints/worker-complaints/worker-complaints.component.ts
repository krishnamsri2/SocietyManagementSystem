import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ComplaintService } from '../../../service/complaints.service';

@Component({
  selector: 'app-worker-complaints',
  templateUrl: './worker-complaints.component.html',
  styleUrls: ['./worker-complaints.component.css']
})
export class WorkerComplaintsComponent implements OnInit {

  constructor(private http:HttpClient,private complaintService:ComplaintService) { }
  disable = false;
  allComplaints:any;
  userDetailId:any;
  ngOnInit(): void {
    this.http.get(`http://localhost:9191/AvailableWorks`).subscribe((data)=>{
      this.allComplaints = data;
      console.log(data);
    })
    this.userDetailId = JSON.parse(atob(localStorage.getItem('user'))).userDetailId;
  }
  assign(status,complaintId:any){
    this.disable = true;
    this.complaintService.taskActions(this.userDetailId,complaintId,status).subscribe(()=>{
      this.ngOnInit();
    })
  
  }
  enableBtn(){
    this.disable = false;
  }
}
