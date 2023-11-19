import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginWarningDialogComponent } from './login-warning-dialog.component';

describe('LoginWarningDialogComponent', () => {
  let component: LoginWarningDialogComponent;
  let fixture: ComponentFixture<LoginWarningDialogComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [LoginWarningDialogComponent]
    });
    fixture = TestBed.createComponent(LoginWarningDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
