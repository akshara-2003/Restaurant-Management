import { Component, OnInit } from '@angular/core';
import { MenuService } from '../menu.service';
import { MatDialog } from '@angular/material/dialog';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { EditMenuComponent } from '../edit-menu/edit-menu.component';
import { AddMenuComponent } from '../add-menu/add-menu.component';
import { NgToastService } from 'ng-angular-popup';
@Component({
  selector: 'app-menu-management',
  templateUrl: './menu-management.component.html',
  styleUrls: ['./menu-management.component.css']
})
export class MenuManagementComponent implements OnInit{
  currIndex=0;
  menuData:Array<any> = []
  selectedItem: any;
  editItemForm! : FormGroup;
  constructor(private menuService: MenuService,private dialog: MatDialog,private fb:FormBuilder,private router:Router,private toast:NgToastService){
 
  }
  openEditFormDialog(item: any,index:number) {
    this.currIndex=index;
    const dialogRef = this.dialog.open(EditMenuComponent, {
      data: {
        item: item
      }
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.menuData[this.currIndex]=result;
        this.selectedItem = result;
        this.menuService.editMenuItem(result).subscribe(
          (response: any) => {
            console.log('Item updated successfully:', response);
          }
        );
      }
    });
  }
  openAddItemDialog() {
    const dialogRef = this.dialog.open(AddMenuComponent);
  
    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        console.log('New item added:', result);
        // Update local data or perform other actions based on the new item
      }
    });
  }
  deleteItem(itemId:String){
    this.toast.error({detail:"Delete message",summary:"Menu Item deleted",duration:5000});
    this.menuService.deleteMenuItem(itemId).subscribe(
      (response: any) => {
          console.log('Menu item deleted:', response);
          this.menuData = this.menuData.filter(item => item.itemId !== itemId);
      }
  );
  }
  ngOnInit(){
    this.menuService.getMenuItems().subscribe(items=>{
      this.menuData=items;
    });
  }
}
