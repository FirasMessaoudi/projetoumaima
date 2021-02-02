import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailOrganismeComponent } from './detail-organisme.component';

describe('DetailOrganismeComponent', () => {
  let component: DetailOrganismeComponent;
  let fixture: ComponentFixture<DetailOrganismeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DetailOrganismeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailOrganismeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
