import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FlatmodalsComponent } from './flatmodals.component';

describe('FlatmodalsComponent', () => {
  let component: FlatmodalsComponent;
  let fixture: ComponentFixture<FlatmodalsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FlatmodalsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FlatmodalsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
