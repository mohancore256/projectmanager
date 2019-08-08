import { Task } from './task';

export class ParentTask {
    id:number;
    parentTaskId:number;
    parentTaskName:string;
    tasks:Task[];
}
