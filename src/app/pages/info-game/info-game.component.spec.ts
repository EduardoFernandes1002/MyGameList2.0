import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InfoGameComponent } from './info-game.component';

describe('InfoGameComponent', () => {
  let component: InfoGameComponent;
  let fixture: ComponentFixture<InfoGameComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [InfoGameComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InfoGameComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
