import { TestBed } from '@angular/core/testing';

import { DescobertaService } from './descoberta.service';

describe('DescobertaService', () => {
  let service: DescobertaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DescobertaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
