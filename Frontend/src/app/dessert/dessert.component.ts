import { Component,OnInit } from '@angular/core';
import { MenuService } from '../menu.service';
import { AuthService } from '../auth.service';
import { MatDialog } from '@angular/material/dialog';
import { LoginWarningDialogComponent } from '../login-warning-dialog/login-warning-dialog.component';
import { InstructionsDialogComponent } from '../instructions-dialog/instructions-dialog.component';

@Component({
  selector: 'app-dessert',
  templateUrl: './dessert.component.html',
  styleUrls: ['./dessert.component.css']
})
export class DessertComponent implements OnInit{
  dessertData:Array<any> = []
  constructor(private menuService:MenuService,public authService:AuthService,private dialog: MatDialog){}
  ngOnInit(): void {
    this.menuService.getCategoryItems("Dessert").subscribe(items=>{
      this.dessertData=items;
    });
  }
  openLoginWarning():void{
    const dialogRef= this.dialog.open(LoginWarningDialogComponent);
  }
  openInstructionsDialog(item:any): void {
    const dialogRef = this.dialog.open(InstructionsDialogComponent);
    dialogRef.componentInstance.item = item;
    dialogRef.afterClosed().subscribe((instructions)=>{
     
        this.authService.addToCart(item,instructions).subscribe((response:any)=>{
          console.log(response);
        })
      
      // else
      // {
      //   // this.menuService.addToCart({item,instructions:''});
      //   this.authService.addToCart(item,'').subscribe((response:any)=>{
      //     console.log(response);
      //   })
      // }
    })
  }
}
