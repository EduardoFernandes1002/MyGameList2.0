import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RecomendadoComponent } from './recomendado.component';

describe('RecomendadoComponent', () => {
  let component: RecomendadoComponent;
  let fixture: ComponentFixture<RecomendadoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RecomendadoComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RecomendadoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
