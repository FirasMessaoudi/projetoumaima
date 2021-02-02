import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Offre } from '../model/offre';

@Injectable({
  providedIn: 'root'
})
export class OffreServiceService {

  URL = 'http://localhost:8080/offre/';

  constructor(private httpclient:HttpClient) { }

  getOffreStageByIdOrganisme(id:number):Observable<Offre[]>{
    return this.httpclient.get<Offre[]>(this.URL+'offreByorganisme/'+id);
  }
}
