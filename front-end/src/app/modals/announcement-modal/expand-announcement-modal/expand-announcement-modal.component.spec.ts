import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExpandAnnouncementModalComponent } from './expand-announcement-modal.component';

describe('ExpandAnnouncementModalComponent', () => {
  let component: ExpandAnnouncementModalComponent;
  let fixture: ComponentFixture<ExpandAnnouncementModalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ExpandAnnouncementModalComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ExpandAnnouncementModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
