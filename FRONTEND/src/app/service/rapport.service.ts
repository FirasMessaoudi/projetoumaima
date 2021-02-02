import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RapportService {

  URL = 'http://localhost:8080/rapport/rapports/';

  constructor(private httpclient:HttpClient) { }


  findallrapport():Observable<any[]>{
    return this.httpclient.get<any[]>(this.URL)
  }
}
