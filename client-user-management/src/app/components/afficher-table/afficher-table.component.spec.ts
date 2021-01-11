import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AfficherTableComponent } from './afficher-table.component';

describe('AfficherTableComponent', () => {
  let component: AfficherTableComponent;
  let fixture: ComponentFixture<AfficherTableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AfficherTableComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AfficherTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
