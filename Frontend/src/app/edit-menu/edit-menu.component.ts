import { Component ,Inject,OnInit} from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { MenuService } from '../menu.service';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { NgToastService } from 'ng-angular-popup';
@Component({
  selector: 'app-edit-menu',
  templateUrl: './edit-menu.component.html',
  styleUrls: ['./edit-menu.component.css']
})
export class EditMenuComponent implements OnInit{
  selectedItem: any;
  editItemForm! : FormGroup;
  constructor(private fb:FormBuilder,private menuService:MenuService,private router:Router,public dialogRef: MatDialogRef<EditMenuComponent>, @Inject(MAT_DIALOG_DATA) public data: any,private toast:NgToastService){
    this.selectedItem = data.item;
    this.editItemForm=this.fb.group({
      itemName:[this.selectedItem.itemName,Validators.required],
      category:[this.selectedItem.category,Validators.required],
      itemPrice:[this.selectedItem.itemPrice,Validators.required],
      imageUrl:[this.selectedItem.imageUrl,Validators.required]
    });
  }
  ngOnInit(){

  }
  editItem(){
    if (this.editItemForm.valid) {
      const updatedItem = {
        ...this.selectedItem,
        ...this.editItemForm.value
      };
      this.toast.success({detail:"Success Message",summary:"Updated successfully",duration:5000})
      this.dialogRef.close(updatedItem);
    } else {
        this.toast.warning({detail:"Warning Message",summary:"Please fill all the fields",duration:5000})
    }
  }
  closeDialog() {
    this.dialogRef.close(null);
  }
}
