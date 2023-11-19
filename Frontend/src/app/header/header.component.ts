import { Component } from '@angular/core';
import { Router,NavigationEnd } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { LoginComponent } from '../login/login.component';
import { AuthService } from '../auth.service';
@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {
  public isNavbarOpen = false;
  constructor(private router:Router,private modalService: NgbModal,public authService:AuthService){
    this.router.events.subscribe(event => {
      if (event instanceof NavigationEnd) {
        this.closeNavbar();
      }
    });

  }
  ngOnInit(): void {}

  toggleNavbar() {
    this.isNavbarOpen = !this.isNavbarOpen;
  }
  closeNavbar() {
    this.isNavbarOpen = false;
  }
  logout(){
    this.authService.currentUser=null;
  }
}
