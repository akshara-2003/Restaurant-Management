import { Component } from '@angular/core';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-login-warning-dialog',
  templateUrl: './login-warning-dialog.component.html',
  styleUrls: ['./login-warning-dialog.component.css']
})
export class LoginWarningDialogComponent {
  constructor(private dialogRef: MatDialogRef<LoginWarningDialogComponent>){
  }
  closeDialog(){
    this.dialogRef.close();
  }
}
