import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisteredComplaintsComponent } from './registered-complaints.component';

describe('RegisteredComplaintsComponent', () => {
  let component: RegisteredComplaintsComponent;
  let fixture: ComponentFixture<RegisteredComplaintsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegisteredComplaintsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RegisteredComplaintsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
