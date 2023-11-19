import { Component, OnInit } from '@angular/core';
import { MenuService } from '../menu.service';
import { MatDialog } from '@angular/material/dialog';
import { InstructionsDialogComponent } from '../instructions-dialog/instructions-dialog.component';
import { LoginWarningDialogComponent } from '../login-warning-dialog/login-warning-dialog.component';
import { AuthService } from '../auth.service';
interface menu{
  id:number,
  name:string,
  category:string,
  price:number,
  image:string,
}
@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit{
  menuData:Array<any> = []
  constructor(private menuService: MenuService,private dialog: MatDialog,public authService:AuthService){
    // this.menuData= this.menuService.menuList
  }
  ngOnInit(){
    this.menuService.getMenuItems().subscribe(items=>{
      this.menuData=items;
      console.log(this.menuData)
    });
  }
  openLoginWarning():void{
    const dialogRef= this.dialog.open(LoginWarningDialogComponent);
  }
  openInstructionsDialog(item:any): void {
    const dialogRef = this.dialog.open(InstructionsDialogComponent);
    dialogRef.componentInstance.item = item;
    dialogRef.afterClosed().subscribe((instructions)=>{
      if(instructions!="do not add to cart")
      {
        this.authService.addToCart(item,instructions).subscribe((response:any)=>{
          console.log(response);
        })
      }
        
      
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
