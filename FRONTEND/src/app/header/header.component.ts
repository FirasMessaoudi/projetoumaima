import { Component, OnInit } from '@angular/core';
import {MenuItem} from 'primeng/api';
import { TokenService } from '../service/token.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {
  private _items!: MenuItem[];
  isLoggedIn: boolean=false;

  public get items(): MenuItem[] {
    return this._items;
  }
  public set items(value: MenuItem[]) {
    this._items = value;
  }
  constructor(private tokenService:TokenService) { }

  ngOnInit(): void {
    this.tokenService.currentStatus.subscribe(status => {

      this.isLoggedIn = status;
      console.log(this.isLoggedIn);



    })
    this.items = [

      {
          label:'LOGIN',
          icon:'pi pi-users',
          routerLink:'/connect'
      },

  ];

  }

}
