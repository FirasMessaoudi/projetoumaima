import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ServiceorganismeService {

  URL = 'http://localhost:8080/organisme/getall/';

  constructor(private httpClient : HttpClient) { }

  findAllOrganismes():Observable<any[]>
  {
    return this.httpClient.get<any[]>(this.URL)
  }
  addOrganisme(organisme : any):Observable<any>{
    return this.httpClient.post<any>(this.URL, organisme)
  }

  updateOrganisme(organisme : any):Observable<any>{
    return this.httpClient.put(this.URL, organisme)
  }
  deleteOrganisme(id : number){
    return this.httpClient.delete(this.URL+id)
  }

}
