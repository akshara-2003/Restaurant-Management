import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'
import { MenuService } from './menu.service';
@Injectable({
  providedIn: 'root'
})
export class AuthService {
  currentUser :any;
  private apiUrl ='http://localhost:8080/api/auth';
  constructor(private http:HttpClient,private menuService : MenuService) { }
  total_value=0;
  login(credentials:{email:string,password:string}){
    return this.http.post(`${this.apiUrl}/login`,credentials);
  }
  addToCart(item : any,instructions:any){
    const obj = {
      menuItem : item,
      quantity : this.currentUser.cartItems.quantity,
      instructions:instructions
    }
    console.log(obj);
    const apiUrl =`http://localhost:8080/customers/${this.currentUser.customerId}/cartItems`;
    return this.http.post(apiUrl,obj);
  }
  
  getCartItems(){
    console.log(this.currentUser.customerId);
    const cartUrl =`http://localhost:8080/customers/${this.currentUser.customerId}/cartItems`;
    return this.http.get<any>(cartUrl);
  }
  removeFromCart(cartItem:any){
      console.log(cartItem)
        const cartUrl=`http://localhost:8080/customers/${this.currentUser.customerId}/cartItems/${cartItem.itemId}`;
        return this.http.delete<any>(cartUrl);
    }
    increaseQuantity(cartItem:any){
      const incUrl = `http://localhost:8080/customers/${this.currentUser.customerId}/cartItems/increment/${cartItem.menuItem.itemId}`;
      return this.http.post(incUrl,{});
          // this.calculateTotalValue();
      }
      decreaseQuantity(cartItem:any){
        const incUrl = `http://localhost:8080/customers/${this.currentUser.customerId}/cartItems/decrement/${cartItem.menuItem.itemId}`;
        return this.http.post(incUrl,{});
        // this.calculateTotalValue();
      }
      
  register(registrationData:any){
    return this.http.post(`${this.apiUrl}/register`,registrationData);
  }
}
