import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MenuComponent } from './menu/menu.component';
import { UserHomeComponent } from './user-home/user-home.component';
import { CartComponent } from './cart/cart.component';
import { BookTableComponent } from './book-table/book-table.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { ManagerHomeComponent } from './manager-home/manager-home.component';
import { StaffHomeComponent } from './staff-home/staff-home.component';
import { BreakfastComponent } from './breakfast/breakfast.component';
import { StarterComponent } from './starter/starter.component';
import { MaincourseComponent } from './maincourse/maincourse.component';
import { DessertComponent } from './dessert/dessert.component';
import { MenuManagementComponent } from './menu-management/menu-management.component';
import { ShiftManagementComponent } from './shift-management/shift-management.component';
import { SalesReportsComponent } from './sales-reports/sales-reports.component';
import { PayroleManagementComponent } from './payrole-management/payrole-management.component';
import { AddMenuComponent } from './add-menu/add-menu.component';
import { EditMenuComponent } from './edit-menu/edit-menu.component';

const routes: Routes = [
  {
    path:'',
    component:UserHomeComponent
  },
  {
    path:'home',
    component:UserHomeComponent
  },
  {
    path:'menu',
    component:MenuComponent
  },
  {
    path:'cart',
    component:CartComponent
  },
  {
    path:'bookTable',
    component:BookTableComponent
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path:'register',
    component:RegisterComponent
  },
  {
    path:'manager',
    component:ManagerHomeComponent
  },
  {
    path:'staff',
    component:StaffHomeComponent
  },
  {
    path:'breakfast',
    component:BreakfastComponent
  },
  {
    path:'starter',
    component:StarterComponent
  },
  {
    path:'maincourse',
    component:MaincourseComponent
  },
  {
    path:'dessert',
    component:DessertComponent
  },
  {
    path:'menuManagement',
    component:MenuManagementComponent
  },
  {
    path:'shiftManagement',
    component:ShiftManagementComponent
  },
  {
    path:'salesReports',
    component:SalesReportsComponent
  },
  {
    path:'perfoemance',
    component:PayroleManagementComponent
  },
  {
    path:'addItem',
    component:AddMenuComponent
  },
  {
    path:'editItem',
    component:EditMenuComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
