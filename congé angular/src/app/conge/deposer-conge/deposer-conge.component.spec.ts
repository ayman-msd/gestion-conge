import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeposerCongeComponent } from './deposer-conge.component';

describe('DeposerCongeComponent', () => {
  let component: DeposerCongeComponent;
  let fixture: ComponentFixture<DeposerCongeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DeposerCongeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DeposerCongeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
