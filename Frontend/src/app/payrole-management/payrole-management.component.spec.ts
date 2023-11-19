import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PayroleManagementComponent } from './payrole-management.component';

describe('PayroleManagementComponent', () => {
  let component: PayroleManagementComponent;
  let fixture: ComponentFixture<PayroleManagementComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PayroleManagementComponent]
    });
    fixture = TestBed.createComponent(PayroleManagementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
