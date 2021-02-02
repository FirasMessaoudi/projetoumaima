import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Offre } from '../model/offre';
import { Organisme } from '../model/organisme';
import { OffreServiceService } from '../service/offre-service.service';
import { OrganismeServiceService } from '../service/organisme-service.service';

@Component({
  selector: 'app-detail-organisme',
  templateUrl: './detail-organisme.component.html',
  styleUrls: ['./detail-organisme.component.scss']
})
export class DetailOrganismeComponent implements OnInit {
  public id!: number;
  offres!:Offre[];
  organisme!:Organisme;
  displayPosition!: boolean;

  position!: string;

  private readonly newProperty = this;

  constructor(private route: ActivatedRoute,private offreService:OffreServiceService,
    private organismeService:OrganismeServiceService) { }

  ngOnInit(): void {
    console.log(this.route.snapshot.paramMap.get('id'));
    this.getOffreByIdPrganisme(this.route.snapshot.paramMap.get('id'));
    this.findorganismebyID(this.route.snapshot.paramMap.get('id'));

  }

  getOffreByIdPrganisme(id:any){
    this.offreService.getOffreStageByIdOrganisme(id).subscribe(
      res => {
     this.offres=res;
     console.log(this.offres);
      },


    )
  }

  findorganismebyID(id:any){
    this.organismeService.getOrganisme(id).subscribe(
      res=>{
        this.organisme=res;
        console.log(this.organisme);
      },
      err=>{

      }
    )


  }
  showPositionDialog(position: string) {
    this.position = position;
    this.displayPosition = true;
}

}
