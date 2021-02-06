import { Component, OnInit } from '@angular/core';
import { JQueryStyleEventEmitter } from 'rxjs/internal/observable/fromEvent';
import { Jury } from '../model/jury';
import { JuryServiceService } from '../service/jury-service.service';
import {ConfirmationService, MessageService} from 'primeng/api';
import { FormControl, FormGroup } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-jury',
  templateUrl: './jury.component.html',
  styleUrls: ['./jury.component.scss'],
  providers: [ConfirmationService,MessageService]

})
export class JuryComponent implements OnInit {
 idJury!:any;
 displayModal!: boolean;
 newJury!:Jury;
  juryForm:FormGroup = new FormGroup({
    nom: new FormControl(''),
    prenom: new FormControl(''),
    email: new FormControl(''),
    specialite: new FormControl(''),
  });

  displayPosition!: boolean;
  displayPosition1!: boolean;
  position!: string;
  position1!: string;

  display: boolean = false;

  showModalDialog() {
    this.displayModal = true;
}

  listesJurys!: Jury[];
  constructor(private juryService:JuryServiceService, private confirmationService:ConfirmationService,
    private messageService:MessageService, private toaster: ToastrService) { }



  showPositionDialog(position: string) {
    this.position = position;
    this.displayPosition = true;
}

showPositionDialog1(position: string, jury:any) {
  this.idJury=jury;
  this.position1 = position;
  this.displayPosition1 = true;
}

  ngOnInit(): void {
    this.juryService.findallJurys().subscribe(
      res =>
      {
        this.listesJurys=res.reverse();
        console.log(this.listesJurys);

      },
    )


  }

  confirmPosition(position: string) {
    this.position = position;

    this.confirmationService.confirm({
        message: 'Do you want to delete this record?',
        header: 'Delete Confirmation',
        icon: 'pi pi-info-circle',
        accept: () => {
           // this.messageService.add({severity:'info', summary:'Confirmed', detail:'Record deleted'});
        },
        reject: () => {
            //this.messageService.add({severity:'info', summary:'Rejected', detail:'You have rejected'});
        },
        key: "positionDialog"
    });
}


addJury(){
  console.log(this.juryForm.value);
  this.juryService.addJury(this.juryForm.value).subscribe(
    res =>
    {
      this.newJury=res;
      console.log( this.newJury);
      this.displayPosition=false;
      this.listesJurys.splice(0,0,this.newJury);

    },
    err=>{

    },
    () => {
      this.juryForm.reset();

  }
  )
    }
    confirm1() {
      this.confirmationService.confirm({
          message: 'Are you sure that you want to proceed?',
          header: 'Confirmation',
          icon: 'pi pi-exclamation-triangle',

          accept: () => {
            this.messageService.add({severity:'info', summary:'Confirmed', detail:'You have accepted'});
          },
          reject: () => {
           this.messageService.add({severity:'info', summary:'Rejected', detail:'You have rejected'});
          }
      });
  }
  supprimeJury(){
    console.log(this.idJury);
  this.juryService.deleteJury(this.idJury.id).subscribe(
      res=>{
        this.listesJurys.splice(this.listesJurys.indexOf(this.idJury),1);
        this.toaster.success('Opération effectué avec succees');

      },
      err=>{
        this.toaster.error('Erreur lors de la suppression');
      },
      ()=>{
        this.displayPosition1 = false;

      }

    )
  }
}
