import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { SocietyModel } from '../../../shared/society.model';
import { TowerListPostService } from './tower-list/tower-list.post-services';
import { map } from 'rxjs/operators';
//import { ReloadService } from '../../../service/reload.service';
@Injectable({
  providedIn: 'root',
})
export class SocietyPostService {
  constructor(
    private http: HttpClient,
    private towerListPostService: TowerListPostService,
  ) {}
  addSociety(newSociety) {
    return this.http.post('http://localhost:9191/addSociety', newSociety);
  }
  fetchSocieties() {
    return this.http
      .get<{ [key: string]: SocietyModel }>('http://localhost:9191/societies', {
        responseType: 'json',
      })
      .pipe(
        map((responseData: { [key: string]: SocietyModel }) => {
          const societies = [];

          for (const key in responseData) {
            if (responseData.hasOwnProperty(key)) {
              societies.push({ ...responseData[key], serialNo: key });
            }
          }
          return societies;
        })
      );
  }
  updateSocietyName(Id: number, newName: any) {
    this.http
      .put(`http://localhost:9191/society/updates/${Id}`, newName)
      .subscribe(() => {
        alert('Name changed');

      });
  }
}
