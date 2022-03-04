import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NarrowLongCardsComponent } from './narrow-long-cards.component';

describe('NarrowLongCardsComponent', () => {
  let component: NarrowLongCardsComponent;
  let fixture: ComponentFixture<NarrowLongCardsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NarrowLongCardsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NarrowLongCardsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
