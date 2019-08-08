import { Component, OnInit } from '@angular/core';
import { Task } from '../../model/task';
import { TaskService } from '../../service/task.service';

@Component({
  selector: 'app-view-task',
  templateUrl: './view-task.component.html',
  styleUrls: ['./view-task.component.css']
})
export class ViewTaskComponent implements OnInit {

  taskList: Task[];
  constructor(private taskService: TaskService) {
    this.loadAllTasks();
  }

  ngOnInit() {
  }

  loadAllTasks() {
    this.taskService.getAllTask().subscribe(resp => {
      this.taskList = resp as Task[];
    });
  }
}
