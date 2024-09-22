import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CongeDeposeComponent } from './conge-depose.component';

describe('CongeDeposeComponent', () => {
  let component: CongeDeposeComponent;
  let fixture: ComponentFixture<CongeDeposeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CongeDeposeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CongeDeposeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
