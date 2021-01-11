import { TestBed } from '@angular/core/testing';

import { AfficherTableServiceService } from './afficher-table-service.service';

describe('AfficherTableServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AfficherTableServiceService = TestBed.get(AfficherTableServiceService);
    expect(service).toBeTruthy();
  });
});
