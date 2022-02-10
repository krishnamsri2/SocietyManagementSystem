import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConfigurationComponentComponent } from './configuration-component.component';

describe('ConfigurationComponentComponent', () => {
  let component: ConfigurationComponentComponent;
  let fixture: ComponentFixture<ConfigurationComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ConfigurationComponentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ConfigurationComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
