import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class JuryServiceService {

  URL = 'http://localhost:8080/jury';

  constructor(private httpclient:HttpClient) { }
  findallJurys():Observable<any[]>{
    return this.httpclient.get<any[]>(this.URL+'/jurys')
  }

  addJury(info: any): Observable<any> {
    return this.httpclient.post<any>(this.URL+'/ajoutJury', info);
  }
  deleteJury(id: number){
    return this.httpclient.delete(this.URL+'/deleteJury'+'/'+id);
  }

}
