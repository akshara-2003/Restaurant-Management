import { Injectable } from '@angular/core';
import{HttpClient} from '@angular/common/http'
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})

export class MenuService {
  currentItem :any;

  totalValue =0;
  private apiUrl ='http://localhost:8080/menu';
  constructor(private http:HttpClient){}
  getMenuItems(){
    return this.http.get<any>(`${this.apiUrl}`);
  }
  addMenuItem(itemData:any){
    const addUrl = 'http://localhost:8080/api/item'
    return this.http.post(`${addUrl}/addItem`,itemData);
  }
  editMenuItem(menuItem:any){
    const editUrl = 'http://localhost:8080/api/item'
    return this.http.put(`${editUrl}/editItem/${menuItem.itemId}`,menuItem)
  }
  deleteMenuItem(menuItemId:String){
      const deleteUrl ='http://localhost:8080/api/item'
      return this.http.delete(`${deleteUrl}/deleteItem/${menuItemId}`)
  }
  getCategoryItems(category:string){
    return this.http.get<any>(`${this.apiUrl}/category/${category}`);
  }
  // addToCart(cartItem:any){
  //   const existingItem =this.cartItems.find((item)=>item.item===cartItem.item);
  //   if(existingItem)
  //   {
  //     existingItem.quantity++;
  //   }
  //   else{
  //     cartItem.quantity=1;
  //     this.cartItems.push(cartItem);
  //   }
  //   this.calculateTotalValue();
  // }
  // removeFromCart(cartItem:any){
  //     const index=this.cartItems.indexOf(cartItem);
  //     if(index!==-1)
  //     {
  //       this.cartItems.splice(index,1);
  //     }
  //     this.calculateTotalValue();
  // }
  // increaseQuantity(cartItem:any){
  //     cartItem.quantity++;
  //     this.calculateTotalValue();
  // }
  // decreaseQuantity(cartItem:any){
  //   if(cartItem.quantity>1)
  //   {
  //     cartItem.quantity--;
  //   }
  //   this.calculateTotalValue();
  // }
  // calculateTotalValue(){
  //   this.totalValue= this.cartItems.reduce((total,item)=>total+item.quantity*item.item.price,0);
  // }
  // getCartItems(){
  //   return this.cartItems;
  // }
  // getTotalValue(){
  //   return this.totalValue;
  // }
  
}
