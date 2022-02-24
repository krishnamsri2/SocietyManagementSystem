import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewFlatModalComponent } from './new-flat-modal.component';

describe('NewFlatModalComponent', () => {
  let component: NewFlatModalComponent;
  let fixture: ComponentFixture<NewFlatModalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NewFlatModalComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NewFlatModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
