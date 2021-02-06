import { HttpParams } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Offre } from '../model/offre';
import { Organisme } from '../model/organisme';
import { OffreServiceService } from '../service/offre-service.service';
import { OrganismeServiceService } from '../service/organisme-service.service';
import { RapportService } from '../service/rapport.service';

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
  selectedFiles: any;
  currentFileUpload: any;
  path: any;
  sender:any;
  constructor(private route: ActivatedRoute,private offreService:OffreServiceService,private tost:ToastrService,
    private organismeService:OrganismeServiceService,private service: RapportService) { }

  ngOnInit(): void {
    console.log(this.route.snapshot.paramMap.get('id'));
    //this.getOffreByIdPrganisme(this.route.snapshot.paramMap.get('id'));
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

      },
      ()=>{
        this.getOffreByIdPrganisme(id);
      }
    )


  }
  showPositionDialog(position: string) {
    this.position = position;
    this.displayPosition = true;
}
selectFile(event:any) {
  this.selectedFiles = event.target.files;
}
postuler(){
  let name =this.selectedFiles.item(0).name;

  this.currentFileUpload = this.selectedFiles.item(0);

  this.service.pushFileToStorage(this.currentFileUpload,name).subscribe(
    res=> {
      this.path = res.body;
      console.log(this.path);
    },
    err=>console.log(err.error),
    ()=>{
      let body = new HttpParams();
      body = body.set('email', this.organisme.email);
      body = body.set('path', this.path);
      body = body.set('sender',this.sender)
      this.organismeService.sendCandidature(body).subscribe(
       res=>this.tost.success('Votre candidature a été envoyé avec success'),
       err =>this.tost.error('Erreur lors de la demande de candidature veuillez ressayer ulterieurement'),
       () => {
         this.displayPosition = false;
       }
       
     )
    }
  )
}

}
