import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';

import { AuthService } from '../service/auth.service';
import { TokenService } from '../service/token.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  userForm = new FormGroup({
    nom: new FormControl(''),
    prenom: new FormControl(''),
    email: new FormControl(''),
    password: new FormControl(''),
    niveau: new FormControl(''),
  });
  showPassword = false;
   email:any;
   password:any;
  constructor(private authService:AuthService,private tokenService:TokenService,private router:Router
) { }

  ngOnInit(): void {
  }

  login(){
    let signinForm:any={};
    signinForm.email=this.email;
    signinForm.password=this.password;
this.authService.attemptAuth(signinForm).subscribe(
  res=>{
    console.log(res);
    this.tokenService.saveToken(res.token);
  },
  err=>console.log(err),
  ()=>{
    if(this.tokenService.getRole()=="Administrateur"){
this.router.navigate(['/administrateur']);
    }else{
      this.router.navigate(['/etudiant']);
    }
  }
)


  }

  addUser(){
    console.log(this.userForm.value);
    this.authService.signUp(this.userForm.value).subscribe(
      res =>
      {

        console.log("ajouter avec succes");

      },
      () => {
        //this.messageService.add({severity:'success', summary: 'Success', detail: 'inscrit avec succées'});
    }
    )

      }

}
