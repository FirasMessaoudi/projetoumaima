import { BrowserModule } from '@angular/platform-browser';
import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {AccordionModule} from 'primeng/accordion';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { HomeComponent } from './home/home.component';
import {ContextMenuModule} from 'primeng/contextmenu';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import {MenubarModule} from 'primeng/menubar';
import {CardModule} from 'primeng/card';
import {FieldsetModule} from 'primeng/fieldset';
import { MenuComponent } from './menu/menu.component';
import {ButtonModule} from 'primeng/button';
import { LoginComponent } from './login/login.component';
import {PanelModule} from 'primeng/panel';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { EtudiantComponent } from './etudiant/etudiant.component';
import { AdministrateurComponent } from './administrateur/administrateur.component';
import { RapportComponent } from './rapport/rapport.component';
import { OrganismeComponent } from './organisme/organisme.component';
import {InputTextModule} from 'primeng/inputtext';
import {DropdownModule} from 'primeng/dropdown';
import {InputMaskModule} from 'primeng/inputmask';
import {CalendarModule} from 'primeng/calendar';
import {MultiSelectModule} from 'primeng/multiselect';
import {TreeTableModule} from 'primeng/treetable';
import {DialogModule} from 'primeng/dialog';
import {ToastModule} from 'primeng/toast';
import {TableModule} from 'primeng/table';
import {SliderModule} from 'primeng/slider';
import {ProgressBarModule} from 'primeng/progressbar';
import {DataViewModule} from 'primeng/dataview';
import { InscriptionComponent } from './inscription/inscription.component';
import { AdminAcceuilComponent } from './admin-acceuil/admin-acceuil.component';
import { JuryComponent } from './jury/jury.component';
import { SuiviRapportComponent } from './suivi-rapport/suivi-rapport.component';
import {ConfirmPopupModule} from 'primeng/confirmpopup';
import { DetailOrganismeComponent } from './detail-organisme/detail-organisme.component';
import {OrderListModule} from 'primeng/orderlist';




@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    HeaderComponent,
    FooterComponent,
    MenuComponent,
    LoginComponent,
    EtudiantComponent,
    AdministrateurComponent,
    RapportComponent,
    OrganismeComponent,
    InscriptionComponent,
    AdminAcceuilComponent,
    JuryComponent,
    SuiviRapportComponent,
    DetailOrganismeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    AccordionModule,
    BrowserAnimationsModule,
    ContextMenuModule,
    MenubarModule,
    FieldsetModule,
    CardModule,
    ButtonModule,
    PanelModule,
    FormsModule,
    HttpClientModule,
    InputTextModule,
    DropdownModule,
    InputMaskModule,
    CalendarModule,
    MultiSelectModule,
    TreeTableModule,
    DialogModule,
    ToastModule,
    TableModule,
    SliderModule,
    ProgressBarModule,
    DataViewModule,
    ReactiveFormsModule,
    ConfirmPopupModule,
    OrderListModule



  ],
  providers: [],
  schemas: [ CUSTOM_ELEMENTS_SCHEMA ],
  bootstrap: [AppComponent]
})
export class AppModule { }
