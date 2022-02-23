import { Component, OnInit } from '@angular/core';
import { MenuModel } from '../../../shared/menu.model';
import { MenuService } from '../../../service/menu.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  constructor(private menuServices:MenuService) { }
  menus:MenuModel[]=[];
  ngOnInit(): void {
    this.menuServices.fetchMenus().subscribe((data)=>{
      this.menus = data;
      console.log(this.menus);
    })
  }

}
