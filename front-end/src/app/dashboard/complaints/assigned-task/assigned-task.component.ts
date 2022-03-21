import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ComplaintService } from '../../../service/complaints.service';

@Component({
  selector: 'app-assigned-task',
  templateUrl: './assigned-task.component.html',
  styleUrls: ['./assigned-task.component.css']
})
export class AssignedTaskComponent implements OnInit {

  constructor(private complaintService:ComplaintService,private http:HttpClient) { }
  myTasks:any;
  userDetailId:any;
  ngOnInit(): void {
    this.userDetailId = JSON.parse(atob(localStorage.getItem('user'))).userDetailId;
    console.log(this.userDetailId);
    this.http.get<any>(`http://localhost:9191/assignedWorks/${this.userDetailId}`).subscribe((data)=>{
      this.myTasks = data;
    })
  }
  action(status:string,complaintId){
    //console.log(status);
    this.complaintService.taskActions(this.userDetailId,complaintId,status).subscribe(()=>{
      this.ngOnInit();
    });
  }
}
