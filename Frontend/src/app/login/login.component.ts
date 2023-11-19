import { Component,OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';
import { NgToastService } from 'ng-angular-popup';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
 loginForm! : FormGroup;
 constructor(private fb:FormBuilder,private authService:AuthService,private router:Router,private toast:NgToastService){
  this.loginForm=this.fb.group({
    email:['',Validators.required],
    password:['',Validators.required]
  });
 }
 
 login(){
  if(this.loginForm.valid){
    const credentials = this.loginForm.value;
    this.authService.login(credentials).subscribe((response:any)=>{
      this.authService.currentUser=response;
      if(response===null){
        this.toast.error({detail:"Invalid credentils",summary:"Login Failed",duration:5000});
      }
      if(response.role==='manager'){
        this.toast.success({detail:"Success Message",summary:"Login successful",duration:5000});
        this.router.navigate(['/manager']);
      }
      else if(response.role==='staff'){
        this.toast.success({detail:"Success Message",summary:"Login successful",duration:5000});
        this.router.navigate(['/staff']);
       
      }
      else if(response.role==='customer'){
        this.toast.success({detail:"Success Message",summary:"Login successful",duration:5000});
        this.router.navigate(['/home']);
      }
      
    },error=>{
      this.toast.error({detail:"Error Message",summary:"Login Failed",duration:5000});
    }
    )
  }
  else
  {
    this.toast.error({detail:"Login Failed",summary:"Please Enter All the data",duration:5000})
  }
 }
}
