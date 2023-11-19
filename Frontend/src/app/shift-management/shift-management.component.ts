import { Component , OnInit } from '@angular/core';
import { StaffService } from '../staff.service';
import { MatDialog } from '@angular/material/dialog';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ShiftFormComponent } from '../shift-form/shift-form.component';
import { NgToastService } from 'ng-angular-popup';
@Component({
  selector: 'app-shift-management',
  templateUrl: './shift-management.component.html',
  styleUrls: ['./shift-management.component.css']
})
export class ShiftManagementComponent implements OnInit{
  staffData:Array<any> = []
  selectedItem: any;
  editStaffForm! : FormGroup;
  currIndex=0;
  constructor(private staffService:StaffService,private dialog: MatDialog,private fb:FormBuilder,private router:Router,private toast:NgToastService){}
  ngOnInit(){
    this.staffService.getStaff().subscribe(staff=>{
      this.staffData=staff;
      console.log(this.staffData)
    });
  }
  openEditFormDialog(item: any,index:number) {
    this.currIndex=index;
    const dialogRef = this.dialog.open(ShiftFormComponent, {
      data: {
        item: item
      }
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.staffData[this.currIndex]=result;
        this.toast.success({detail:"Success Message",summary:"Updated successfully",duration:5000});
        this.selectedItem = result;
        this.staffService.editStaff(result).subscribe(
          (response: any) => {
            console.log('Updated successfully:', response);
          }
        );
      }
    });
  }
}
