import { TestBed } from '@angular/core/testing';

import { OrganismeServiceService } from './organisme-service.service';

describe('OrganismeServiceService', () => {
  let service: OrganismeServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(OrganismeServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
