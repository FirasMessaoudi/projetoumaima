import { TestBed } from '@angular/core/testing';

import { JuryServiceService } from './jury-service.service';

describe('JuryServiceService', () => {
  let service: JuryServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(JuryServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
