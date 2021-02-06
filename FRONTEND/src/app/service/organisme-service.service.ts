import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Organisme } from '../model/organisme';

@Injectable({
  providedIn: 'root'
})
export class OrganismeServiceService {

  URL = 'http://localhost:8080/organisme';


  constructor(private httpclient:HttpClient) { }
  findallOrganismes():Observable<any[]>{
    return this.httpclient.get<any[]>(this.URL+'/getall')
  }
  getOrganisme(id:number):Observable<Organisme>{
    return this.httpclient.get<Organisme>(this.URL+'/getOrganisme/'+id);
  }
  sendCandidature(email:any):Observable<any>{
    return this.httpclient.post<any>(this.URL+'/sendEmail',email);
  }
}
