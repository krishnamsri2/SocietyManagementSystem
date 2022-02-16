import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuSecurityComponent } from './menu-security.component';

describe('MenuSecurityComponent', () => {
  let component: MenuSecurityComponent;
  let fixture: ComponentFixture<MenuSecurityComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MenuSecurityComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MenuSecurityComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
