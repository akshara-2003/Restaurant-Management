import { Component,OnInit  } from '@angular/core';
import { MenuService } from '../menu.service';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit{
  breakfastData:Array<any> = []
  starterData:Array<any> = []
  maincourseData:Array<any>=[]
  dessertData:Array<any>=[]
  constructor(private menuService:MenuService,public authService:AuthService){

  }
  ngOnInit(): void {
    this.menuService.getCategoryItems("Breakfast").subscribe(items=>{
      this.breakfastData=items;
      // console.log(this.breakfastData)
    });
    this.menuService.getCategoryItems("Starter").subscribe(items=>{
      this.starterData=items;
      // console.log(this.breakfastData)
    });
    this.menuService.getCategoryItems("Main course").subscribe(items=>{
      this.maincourseData=items;
      // console.log(this.breakfastData)
    });
    this.menuService.getCategoryItems("Dessert").subscribe(items=>{
      this.dessertData=items;
      // console.log(this.breakfastData)
    });
  }
}
