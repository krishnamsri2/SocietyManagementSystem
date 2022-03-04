import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { TowerModel } from '../../../../shared/tower.model';
import { map } from 'rxjs/operators';
//import { ActivatedRoute } from "@angular/router";
@Injectable({
  providedIn: 'root',
})
export class TowerListPostService {
  towers: TowerModel[] = [];
  constructor(private http: HttpClient) {}
  addTower(newTower, parentId) {
    return this.http.post(
      `http://localhost:9191/society/${parentId}/addTower`,
      newTower
    );
  }
  fetchTowers(parentId: string) {
    return this.http
      .get<{ [key: string]: TowerModel }>(
        `http://localhost:9191/society/${parentId}/tower`,
        {
          responseType: 'json',
        }
      )
      .pipe(
        map((responseData: { [key: string]: TowerModel }) => {
          const tower = [];

          for (const key in responseData) {
            if (responseData.hasOwnProperty(key)) {
              tower.push({ ...responseData[key], serialNo: key });
            }
          }
          return tower;
        })
      );
  }
  updateTowerDetails(parentId: number, newName: any) {
    console.log(parentId);
    return this.http
      .put(`http://localhost:9191/society/${parentId}/updateTower`, newName)
      
  }
}
