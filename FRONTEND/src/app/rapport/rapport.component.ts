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
  url: string = '';

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
downloadFile($event:any) {
  let file;
  let blob: any;
  let path: string = $event;
  let type:any;
  console.log(path)
  let ext = path.substr(path.lastIndexOf('.') + 1);
  console.log(ext);
  if (ext.toLowerCase() === 'pdf')
    type = 'application/pdf';
  if (ext.toLowerCase() === 'png')
    type = 'image/png';
  if (ext.toLowerCase() === 'jpg' || ext === 'jpeg')
    type = 'image/jpeg';
  if (ext.toLowerCase() === 'gif')
    type = 'image/gif';
    if (ext.toLowerCase() === 'docx' || ext.toLowerCase() === 'doc')
    type = 'application/vnd.openxmlformats-officedocument.wordprocessingml.document';
  this.rapportService.getFile($event, type).subscribe(
    (result) => {

      blob = result;

    },
    (error) => {console.log(error);
    },
    () => {
      file = new Blob([blob], {type: type});
      this.url = window.URL.createObjectURL(file);
      let a = document.createElement('a');
      document.body.appendChild(a);
      a.setAttribute('style', 'display: none');
        a.href = this.url;
        a.download = 'rappport.'+ext;
        a.click();
     // window.open(this.url)
    }
  )

}

}
