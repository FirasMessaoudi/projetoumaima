import { HttpClient, HttpHeaders, HttpRequest } from '@angular/common/http';
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
  pushFileToStorage(file: File, name: string): Observable<any> {
    const formdata: FormData = new FormData();

    formdata.append('file', file);
    formdata.append('name', name);

    const req = new HttpRequest('POST', 'http://localhost:8080/api/fileupload/post', formdata, {
      reportProgress: true,
      responseType: 'text'
    });

    return this.httpclient.request(req);
  }
  getFile(fileName: string, type: any) {
    const headers2 = new HttpHeaders().set('Accept', type);
    return this.httpclient.post('http://localhost:8080/api/fileupload/files/', fileName, {headers: headers2, responseType: 'blob'});
}
}
