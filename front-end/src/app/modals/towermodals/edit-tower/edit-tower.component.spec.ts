import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditTowerComponent } from './edit-tower.component';

describe('EditTowerComponent', () => {
  let component: EditTowerComponent;
  let fixture: ComponentFixture<EditTowerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditTowerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditTowerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
