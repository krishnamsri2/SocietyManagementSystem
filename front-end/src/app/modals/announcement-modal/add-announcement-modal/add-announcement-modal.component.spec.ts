import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddAnnouncementModalComponent } from './add-announcement-modal.component';

describe('AddAnnouncementModalComponent', () => {
  let component: AddAnnouncementModalComponent;
  let fixture: ComponentFixture<AddAnnouncementModalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddAnnouncementModalComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddAnnouncementModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
