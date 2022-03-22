import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-completed-task',
  templateUrl: './completed-task.component.html',
  styleUrls: ['./completed-task.component.css']
})
export class CompletedTaskComponent implements OnInit {

  constructor(private http:HttpClient) { }
  closedTasks:any[]=[];
  ngOnInit(): void {
    let workerId = JSON.parse(atob(localStorage.getItem('user'))).userDetailId;
    this.http.get<any>(`http://localhost:9191/completedWorks/${workerId}`).subscribe((data)=>{
      this.closedTasks = data;
    })
  }

}
