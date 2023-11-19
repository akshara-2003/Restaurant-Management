import { Component,OnInit } from '@angular/core';
import { MenuService } from '../menu.service';
import { AuthService } from '../auth.service';
import { NgToastService } from 'ng-angular-popup';
@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit{
  cartItems:Array<any> = []
  totalValue=0;
  constructor(public menuService: MenuService,public authService:AuthService,private toast:NgToastService) {
  }
  ngOnInit(){
   this.getCartItems();
  }
  getCartItems():any{
    this.authService.getCartItems().subscribe(items=>{
      console.log(this.cartItems)
      console.log(this.cartItems.length)
      this.cartItems=items;
      this.calculateTotalValue();
    });
  }
  removeFromCart(cartItem: any) {
    this.authService.removeFromCart(cartItem).subscribe(response=>{
      const index=this.cartItems.indexOf(cartItem);
      if(index!==-1)
      {
        this.cartItems.splice(index,1);
      }
    });
    // this.calculateTotalValue();
  }
  increaseQuantity(cartItem: any,index:number) {
    this.authService.increaseQuantity(cartItem).subscribe((response:any)=>{
      this.cartItems[index].quantity+=1;
      // cartItem.quantity++;
      // console.log('Cart item quantity incremented:', response);
    }
    )
  //  this.calculateTotalValue();
  }
  decreaseQuantity(cartItem: any,index:number) {
    this.authService.decreaseQuantity(cartItem).subscribe((response:any)=>{
     this.cartItems[index].quantity-=1;
     if(this.cartItems[index].quantity==0)
     {
      this.cartItems.splice(index,1);
     }
      console.log('Cart item quantity decremented:', response);
    }
    )
    // this.calculateTotalValue();
  }
  calculateTotalValue(){
    let totalValue=0;
    for(var item of this.cartItems){
      totalValue =  totalValue + item.quantity*item.menuItem.itemPrice;
    }
    return totalValue;
        }
  getTotalValue(){
    return this.totalValue;
  }
  // updateTotalValue() {
  //   this.totalValue = this.menuService.getTotalValue();
  // }
  checkout() {
    this.toast.success({detail:"Success Message",summary:"Order placed successfully",duration:5000});
  }
}
