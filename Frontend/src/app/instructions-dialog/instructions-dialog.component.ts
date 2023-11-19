import { Component, OnInit  } from '@angular/core';
import {  FormControl, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';
@Component({
  selector: 'app-instructions-dialog',
  templateUrl: './instructions-dialog.component.html',
  styleUrls: ['./instructions-dialog.component.css']
})
export class InstructionsDialogComponent implements OnInit{
item:any;
instructions='';
instructionForm !:FormGroup;
constructor(private dialogRef: MatDialogRef<InstructionsDialogComponent>){
  this.instructionForm= new FormGroup({
    instructions :new FormControl(''),
  })
}
ngOnInit(): void {
} 
onSubmit(){
  console.log(this.instructionForm.value)
  this.instructions = this.instructionForm.value.instructions;
  if(this.instructions.trim())
    this.dialogRef.close(this.instructions);
  else
    this.dialogRef.close()

}
closeDialog(){
  
  this.dialogRef.close("do not add to cart");
}
}