import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WorkerComplaintsComponent } from './worker-complaints.component';

describe('WorkerComplaintsComponent', () => {
  let component: WorkerComplaintsComponent;
  let fixture: ComponentFixture<WorkerComplaintsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WorkerComplaintsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(WorkerComplaintsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
