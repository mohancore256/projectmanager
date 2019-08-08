import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchDropBoxTaskComponent } from './search-drop-box-task.component';

describe('SearchDropBoxTaskComponent', () => {
  let component: SearchDropBoxTaskComponent;
  let fixture: ComponentFixture<SearchDropBoxTaskComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SearchDropBoxTaskComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchDropBoxTaskComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
