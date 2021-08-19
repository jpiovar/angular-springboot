import { Component } from '@angular/core';
import { catchError, map } from 'rxjs/operators';

import { HttpBaseService } from './core/services/http.base.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'angular-app';

  constructor(
    private httpBase: HttpBaseService
  ) {}

  btnClick() {
    debugger;
    console.log('btn clicked');
    const url = 'http://localhost:8080/clickme';
    this.httpBase.getCommon(`${url}`).subscribe((data: any)=>{
      console.log(data);
      debugger;
    });
  }
}
