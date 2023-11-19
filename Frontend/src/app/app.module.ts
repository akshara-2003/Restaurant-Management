import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { UserHomeComponent } from './user-home/user-home.component';
import { ManagerHomeComponent } from './manager-home/manager-home.component';
import { StaffHomeComponent } from './staff-home/staff-home.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { MenuComponent } from './menu/menu.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatDialog, MAT_DIALOG_DATA, MatDialogRef, MatDialogModule} from '@angular/material/dialog';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import { InstructionsDialogComponent } from './instructions-dialog/instructions-dialog.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CartComponent } from './cart/cart.component';
import { BookTableComponent } from './book-table/book-table.component';
import { ManagerHeaderComponent } from './manager-header/manager-header.component';
import { LoginComponent } from './login/login.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { RegisterComponent } from './register/register.component';
import { HttpClientModule } from '@angular/common/http';
import { LoginWarningDialogComponent } from './login-warning-dialog/login-warning-dialog.component';
import { CategoryComponent } from './category/category.component';
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
import { ShiftFormComponent } from './shift-form/shift-form.component';
import { NgToastModule } from 'ng-angular-popup';


@NgModule({
  declarations: [
    AppComponent,
   
    UserHomeComponent,
    ManagerHomeComponent,
    StaffHomeComponent,
    HeaderComponent,
    FooterComponent,
    MenuComponent,
    InstructionsDialogComponent,
    CartComponent,
    BookTableComponent,
    ManagerHeaderComponent,
    LoginComponent,
    RegisterComponent,
    LoginWarningDialogComponent,
    CategoryComponent,
    BreakfastComponent,
    StarterComponent,
    MaincourseComponent,
    DessertComponent,
    MenuManagementComponent,
    ShiftManagementComponent,
    SalesReportsComponent,
    PayroleManagementComponent,
    AddMenuComponent,
    EditMenuComponent,
    ShiftFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule, 
    MatDialogModule,
    MatInputModule,
    MatFormFieldModule,
    FormsModule, 
    ReactiveFormsModule,
    NgbModule,
    HttpClientModule,
    NgToastModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
