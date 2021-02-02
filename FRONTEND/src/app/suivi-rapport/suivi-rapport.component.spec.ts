import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SuiviRapportComponent } from './suivi-rapport.component';

describe('SuiviRapportComponent', () => {
  let component: SuiviRapportComponent;
  let fixture: ComponentFixture<SuiviRapportComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SuiviRapportComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SuiviRapportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
