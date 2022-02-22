import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { SocietyModel } from '../../../shared/society.model';
import { TowerListPostService } from './tower-list/tower-list.post-services';
import { map } from 'rxjs/operators';
@Injectable({
  providedIn: 'root',
})
export class SocietyPostService {
  constructor(
    private http: HttpClient,
    private towerListPostService: TowerListPostService
  ) {}
  addSociety(newSociety) {
    this.http.post('http://localhost:9191/addSociety', newSociety).subscribe(
      (newUser) => {
        alert('ADDED Society');
      },
      (error) => {
        console.log('');
      }
    );
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