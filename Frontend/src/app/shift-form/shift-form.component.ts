import { Component,Inject,OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { StaffService } from '../staff.service';
@Component({
  selector: 'app-shift-form',
  templateUrl: './shift-form.component.html',
  styleUrls: ['./shift-form.component.css']
})
export class ShiftFormComponent implements OnInit{
  selectedItem: any;
  editStaffForm! : FormGroup;
  constructor(private staffService:StaffService,private fb:FormBuilder,private router:Router,public dialogRef: MatDialogRef<ShiftFormComponent>, @Inject(MAT_DIALOG_DATA) public data: any){
    this.selectedItem = data.item;
    this.editStaffForm=this.fb.group({
      staffName:[this.selectedItem.staffName,Validators.required],
      salary:[this.selectedItem.salary,Validators.required],
      rating:[this.selectedItem.rating],
      shift:[this.selectedItem.shift]
    });
  }
  ngOnInit(){

  }
  editStaff(){
    if (this.editStaffForm.valid) {
      const updatedItem = {
        ...this.selectedItem,
        ...this.editStaffForm.value
      };
      this.dialogRef.close(updatedItem);
    } else {
      console.error('Form is invalid');
    }

  }
  closeDialog() {
    this.dialogRef.close(null);
  }
}

