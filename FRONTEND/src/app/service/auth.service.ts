import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  loginUrl='http://localhost:8080/api/auth/signin';
  signupUrl='http://localhost:8080/api/auth/signup';
  constructor(private http: HttpClient) {
  }

  // JwtResponse(accessToken,type,username,authorities)
  attemptAuth(credentials: any): Observable<any> {
    return this.http.post<any>(this.loginUrl, credentials);
  }

  // SignUpInfo(name,username,email,role,password)
  signUp(info: any): Observable<any> {
    return this.http.post<any>(this.signupUrl, info);
  }
}
