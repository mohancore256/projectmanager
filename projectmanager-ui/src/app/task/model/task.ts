import { Project } from 'src/app/project/model/project';
import { User } from 'src/app/user/model/user';
import { ParentTask } from './parent-task';

export class Task {

    taskId : number;

    parentId :number;

    projectId : number;

    taskName : string;

    startDate :Date;

    endDate : Date;

    priority :number;
    status:string;
    users:User[];
    project:Project;
    parentTask:ParentTask;

}
