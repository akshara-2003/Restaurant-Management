import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';
import { NgToastService } from 'ng-angular-popup';
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  registerForm! :FormGroup;
  constructor(private fb:FormBuilder,private authService:AuthService,private router:Router,private toast:NgToastService){
    this.registerForm=this.fb.group({
      email:['',Validators.required],
      password:['',Validators.required],
      name:['',Validators.required],
      mobile:['',Validators.required]
    })
  }
  register(){
    if(this.registerForm.valid){
      const registrationData=this.registerForm.value;
      this.authService.register(registrationData).subscribe(response=>{
        this.authService.currentUser=response;
        console.log(response);
        if(response=="User already exists with this email address")
        {
          this.toast.error({detail:"Error message",summary:"User already exists",duration:5000});
        }
        if(response=="done")
        {
          this.toast.success({detail:"Success Message",summary:"Registration successful",duration:5000});
          this.router.navigate(['/home']);
        }
        else
        {
          this.toast.error({detail:"Error Message",summary:"Login Failed",duration:5000});
          alert("Registration failed");
        }
       
      })
    }
    else{
      this.toast.error({detail:"Registration Failed",summary:"Please Enter All the data",duration:5000})
    }
    // this.router.navigate(['/home']);
  }
}

