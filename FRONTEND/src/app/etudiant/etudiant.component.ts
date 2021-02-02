import { Component, OnInit } from '@angular/core';
import { TokenService } from '../service/token.service';

@Component({
  selector: 'app-etudiant',
  templateUrl: './etudiant.component.html',
  styleUrls: ['./etudiant.component.scss']
})
export class EtudiantComponent implements OnInit {

  constructor(private tokenService:TokenService) { }

  ngOnInit(): void {
  }
  logout(){
    this.tokenService.signOut();

  }
}
