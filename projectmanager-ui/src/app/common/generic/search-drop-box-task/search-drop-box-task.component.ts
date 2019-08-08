import { Component, OnInit, EventEmitter, Output, Input } from '@angular/core';
import { ComboBoxPipe } from '../search-drop-box/search-drop-box.pipe';
import { Task } from 'src/app/task/model/task';

@Component({
  selector: 'app-search-drop-box-task',
  templateUrl: './search-drop-box-task.component.html',
  styleUrls: ['./search-drop-box-task.component.css'],
  providers: [ComboBoxPipe]
})
export class SearchDropBoxTaskComponent implements OnInit {

  @Input()
  dataList: Task[];

  @Input()
  columnName: string;

  @Output()
  selectedTask = new EventEmitter<Task>();

  dummyDataList: Task[];
  showDropDown: boolean;
  textToSort: string;

  constructor(private ComboBoxPipe: ComboBoxPipe) {
    this.reset();
  }

  ngOnInit() {
    this.reset();
  }

  onKeyDownAction(): void {
    this.showDropDown = true;
  }
  reset(): void {
    this.showDropDown = false;
    this.dummyDataList = this.dataList;
  }

  textChange(value) {
    this.dummyDataList = [];
    if (value.length > 0) {
      this.dummyDataList = this.ComboBoxPipe.transformTask(this.dataList, this.columnName, value);
      if (this.dummyDataList) {
        this.showDropDown = true;
      }
    } else {
      this.reset();
    }
  }

  updateTextBox(valueSelected) {
    this.textToSort = valueSelected[this.columnName];
    this.selectedTask.emit(valueSelected);
    this.showDropDown = false;
  }

}
