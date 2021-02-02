import { Component, OnInit } from '@angular/core';
import { RapportService } from '../service/rapport.service';

@Component({
  selector: 'app-rapport',
  templateUrl: './rapport.component.html',
  styleUrls: ['./rapport.component.scss']
})
export class RapportComponent implements OnInit {

  representatives: any[] = [];

  listesRapports: any[]=[];

    statuses: any[] = [];

    loading: boolean = true;

    activityValues: number[] = [0, 100];

  constructor(private rapportService:RapportService) { }

  ngOnInit(): void {
    this.getallrappports();
    console.log(this.listesRapports);


  }
  getallrappports()
{
  this.rapportService.findallrapport().subscribe(
    res =>
    {
      this.listesRapports=res;
      this.loading=false;
      console.log(this.listesRapports);

    },
  )
}

}
