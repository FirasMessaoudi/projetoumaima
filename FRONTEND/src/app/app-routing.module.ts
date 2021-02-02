import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminAcceuilComponent } from './admin-acceuil/admin-acceuil.component';
import { AdministrateurComponent } from './administrateur/administrateur.component';
import { DetailOrganismeComponent } from './detail-organisme/detail-organisme.component';
import { EtudiantComponent } from './etudiant/etudiant.component';
import { GuardsGuard } from './guards/guards.guard';
import { InscriptionComponent } from './inscription/inscription.component';
import { JuryComponent } from './jury/jury.component';
import { LoginComponent } from './login/login.component';
import { MenuComponent } from './menu/menu.component';
import { OrganismeComponent } from './organisme/organisme.component';
import { RapportComponent } from './rapport/rapport.component';
import { SuiviRapportComponent } from './suivi-rapport/suivi-rapport.component';

const routes: Routes = [
  {path:'',component:MenuComponent},
  {path:'connect',component:LoginComponent},
  {path:'etudiant',canActivate: [GuardsGuard],component:EtudiantComponent},
  {path:'detail-organisme/:id',component:DetailOrganismeComponent},
  {path:'administrateur',canActivate: [GuardsGuard],
  component:AdministrateurComponent,
  children: [
    {
        path: 'adminhome',
        component: AdminAcceuilComponent
    },
    {
      path: 'jury',
      component: JuryComponent
  },
  {
    path: 'suiviRapport',
    component: SuiviRapportComponent
},
  ]},
  {path:'rapport',component:RapportComponent},
  {path:'organisme',component:OrganismeComponent},
  {path:'inscription',component:InscriptionComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
