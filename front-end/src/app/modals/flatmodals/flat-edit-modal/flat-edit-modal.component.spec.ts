import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FlatEditModalComponent } from './flat-edit-modal.component';

describe('FlatEditModalComponent', () => {
  let component: FlatEditModalComponent;
  let fixture: ComponentFixture<FlatEditModalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FlatEditModalComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FlatEditModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
