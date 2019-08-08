import { Component, OnInit, Input } from '@angular/core';
import { Task } from '../../model/task';
import { TaskService } from '../../service/task.service';


@Component({
  selector: 'app-task-detail',
  templateUrl: './task-detail.component.html',
  styleUrls: ['./task-detail.component.css']
})

export class TaskDetailComponent implements OnInit {

  @Input() taskDetials:Task;

  constructor(private taskService:TaskService) { }



  ngOnInit() {
  }

  updatingTask(){
    this.taskService.updateTask(this.taskDetials).subscribe(response => {
      window.alert("Updated Task detials succesfully");
      console.log("update method call");
      
      //this.viewTaskComponent.loadAllTasks();
    }
    // ,err =>{
    //   window.alert("Failed to updated Task detials");
    // }
    );
  }

  completeTask(){
    this.taskDetials.status = "COMPLETE";
    this.taskService.updateTask(this.taskDetials).subscribe(response => {
      window.alert("complete Task detials succesfully");
      console.log("complete method call");
      //this.viewTaskComponent.loadAllTasks();
    }
    );
  }
}
