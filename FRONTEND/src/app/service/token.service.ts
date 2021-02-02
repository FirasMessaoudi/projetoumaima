import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import {JwtHelperService} from "@auth0/angular-jwt";
import { BehaviorSubject } from 'rxjs';

const TOKEN_KEY = 'AuthToken';
const helper = new JwtHelperService();
@Injectable({
  providedIn: 'root'
})
export class TokenService {

  private statusSource = new BehaviorSubject<boolean>(localStorage.getItem(TOKEN_KEY) != null);
  currentStatus = this.statusSource.asObservable();


  constructor(private router:Router) { }

  signOut() {
    localStorage.removeItem(TOKEN_KEY);
    this.statusSource.next(false);
    this.router.navigate(['']);


  }

  public saveToken(token: string) {

    localStorage.removeItem(TOKEN_KEY);
    localStorage.setItem(TOKEN_KEY, token);
    this.statusSource.next(true);




  }

  public getToken():any {
    return localStorage.getItem(TOKEN_KEY);
  }

  // public saveUsername(username: string) {
  //   window.sessionStorage.removeItem(USERNAME_KEY);
  //   window.sessionStorage.setItem(USERNAME_KEY, username);
  // }

  public getUsername(){
    if(localStorage.getItem(TOKEN_KEY) != null){
    return helper.decodeToken(this.getToken()).sub;
    }
   }

   public getRole(){
    if(localStorage.getItem(TOKEN_KEY) != null){
    return helper.decodeToken(this.getToken()).auth;
    }
   }

  // public saveAuthorities(authorities: string[]) {
  //   window.sessionStorage.removeItem(AUTHORITIES_KEY);
  //   window.sessionStorage.setItem(AUTHORITIES_KEY, JSON.stringify(authorities));
  // }

  // public getAuthorities(): string {
  //   this.roles = '';

  //     this.roles=sessionStorage.getItem(AUTHORITIES_KEY)

  //   return this.roles;
  // }
  validToken(): boolean {
    if ( localStorage.getItem(TOKEN_KEY) !== null ) {

      if (!helper.isTokenExpired(this.getToken())) {
        return true;
      } else  {
        this.signOut();
        return false; }
    } else {

      return false;
    }
  }



  getDecodeToken(){
    if(localStorage.getItem(TOKEN_KEY) != null)
      return helper.decodeToken(this.getToken());
  }
}
