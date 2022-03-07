import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExpandNoticeComponent } from './expand-notice.component';

describe('ExpandNoticeComponent', () => {
  let component: ExpandNoticeComponent;
  let fixture: ComponentFixture<ExpandNoticeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ExpandNoticeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ExpandNoticeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
