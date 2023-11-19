import { Component } from '@angular/core';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-staff-home',
  templateUrl: './staff-home.component.html',
  styleUrls: ['./staff-home.component.css']
})
export class StaffHomeComponent {
  currentUser:any;
  totalSalary:any;
  bonus:any;
  constructor(private authService:AuthService){
    this.currentUser=this.authService.currentUser;
    this.bonus= (this.currentUser.salary*this.currentUser.rating)/100;
    this.totalSalary = this.currentUser.salary + this.bonus;
  }
  calculateBonus(){
    
  }
   calculateTotalSalary(){
    
  }
}
