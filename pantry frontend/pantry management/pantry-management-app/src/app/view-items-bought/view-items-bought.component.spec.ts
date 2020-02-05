import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewItemsBoughtComponent } from './view-items-bought.component';

describe('ViewItemsBoughtComponent', () => {
  let component: ViewItemsBoughtComponent;
  let fixture: ComponentFixture<ViewItemsBoughtComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewItemsBoughtComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewItemsBoughtComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
