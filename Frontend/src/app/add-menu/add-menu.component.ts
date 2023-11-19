import { Component ,OnInit,Inject} from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { MenuService } from '../menu.service';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { NgToastService } from 'ng-angular-popup';
@Component({
  selector: 'app-add-menu',
  templateUrl: './add-menu.component.html',
  styleUrls: ['./add-menu.component.css']
})
export class AddMenuComponent implements OnInit{
  addItemForm! : FormGroup;
  constructor(private fb:FormBuilder,private menuService:MenuService,private router:Router,public dialogRef: MatDialogRef<AddMenuComponent>, @Inject(MAT_DIALOG_DATA) public data: any,private toast:NgToastService){
    this.addItemForm=this.fb.group({
      itemName:['',Validators.required],
      category:['',Validators.required],
      itemPrice:['',Validators.required],
      imageUrl:['',Validators.required]
    });
  }
  ngOnInit(){

  }
  addItem(){
    if(this.addItemForm.valid){
      this.toast.success({detail:"Success Message",summary:"Item added successfully",duration:5000})
      const newItem = {
        itemName: this.addItemForm.value.itemName,
        category: this.addItemForm.value.category,
        itemPrice:this.addItemForm.value.itemPrice,
        imageUrl:this.addItemForm.value.imageUrl
      };
      const itemData=this.addItemForm.value;
      this.menuService.addMenuItem(newItem).subscribe(response=>{
        this.menuService.currentItem=response;
        this.dialogRef.close(response);
      })
      this.closeDialog();
    }
    else
    this.toast.warning({detail:"Warning Message",summary:"Please enter all the fields",duration:5000})
    // this.router.navigate(['/menuManagement']);
  }
  closeDialog() {
    this.dialogRef.close();
  }
}
