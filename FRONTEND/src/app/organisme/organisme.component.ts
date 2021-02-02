import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import {PrimeNGConfig, SelectItem, TreeNode} from 'primeng/api';
import { Offre } from '../model/offre';
import { Organisme } from '../model/organisme';
import { OffreServiceService } from '../service/offre-service.service';

import { OrganismeServiceService } from '../service/organisme-service.service';



@Component({
  selector: 'app-organisme',
  templateUrl: './organisme.component.html',
  styleUrls: ['./organisme.component.scss']
})
export class OrganismeComponent implements OnInit {

  display: boolean = false;
  organismeAcceuil!:Organisme;

  showDialog(id:any) {
      this.display = true;

      this.organismeSerivce.getOrganisme(id).subscribe(
        res=>{
          this.organismeAcceuil=res;
          console.log(this.organismeAcceuil);
        }
      )
      this.offreService.getOffreStageByIdOrganisme(id).subscribe(
        res => {
       this.offres=res;
       console.log(this.offres);
        },


      )
  }


loading: boolean = true;
offres!:Offre[];
  organismes!: Organisme[];
  sortOrder!: number;

  sortOptions!: SelectItem[];

    sortField!: string;

  representatives!: any[];

  statuses!: any[];
  constructor(private organismeSerivce:OrganismeServiceService,private offreService:OffreServiceService,
    private router:Router) { }

  ngOnInit(): void {
    this.organismeSerivce.findallOrganismes().subscribe(
      res =>
      {
        this.organismes=res;
        console.log(this.organismes);
        this.loading = false;
      },
    )

  }

  getOffreByIdPrganisme(id:any){
    this.router.navigate(['detail-organisme/id'])
    this.offreService.getOffreStageByIdOrganisme(id).subscribe(
      res => {
     this.offres=res;
      },


    )
  }





}
