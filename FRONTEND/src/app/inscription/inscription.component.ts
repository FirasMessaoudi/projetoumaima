import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { AuthService } from '../service/auth.service';
import {MessageService} from 'primeng/api';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.scss'],
  providers: [MessageService]
})
export class InscriptionComponent implements OnInit {

  userForm = new FormGroup({
    nom: new FormControl(''),
    prenom: new FormControl(''),
    email: new FormControl(''),
    password: new FormControl(''),
    niveau: new FormControl(''),
  });

  constructor(private authService:AuthService, private messageService:MessageService) { }
 /* nom = new FormControl('');
  prenom = new FormControl('');
  email=new FormControl('');
  mdp=new FormControl('');
  niveau=new FormControl(''); */
  ngOnInit(): void {
  }

    addUser(){
console.log(this.userForm.value);
this.authService.signUp(this.userForm.value).subscribe(
  res =>
  {

    console.log("ajouter avec succes");

  },
  () => {
    this.messageService.add({severity:'success', summary: 'Success', detail: 'inscrit avec succées'});
}
)

  }
}
