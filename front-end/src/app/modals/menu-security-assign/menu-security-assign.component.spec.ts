import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuSecurityAssignComponent } from './menu-security-assign.component';

describe('MenuSecurityAssignComponent', () => {
  let component: MenuSecurityAssignComponent;
  let fixture: ComponentFixture<MenuSecurityAssignComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MenuSecurityAssignComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MenuSecurityAssignComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
