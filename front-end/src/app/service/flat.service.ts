import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { FlatModel } from '../shared/flat.model';
import { FlatIdServices } from './flat.id.services';
import { map } from 'rxjs';
@Injectable({
  providedIn: 'root',
})
export class FlatService {
  societyId: string;
  parentId: string;
  constructor(
    private http: HttpClient,
    private flatIdService: FlatIdServices
  ) {}
  addFlat(newFlat, parentId: string) {
    // console.log(newFlat,parentId);
    this.societyId = this.flatIdService.getSocietyId();
    return this.http
      .post(
        `http://localhost:9191/society/${this.societyId}/tower/${parentId}/addFlat`,
        newFlat
      )
      
  }
  fetchFlats(parentId: string) {
    this.societyId = this.flatIdService.getSocietyId();
    return this.http
      .get<{ [key: string]: FlatModel }>(
        `http://localhost:9191/society/${this.societyId}/tower/${parentId}/flat`,
        {
          responseType: 'json',
        }
      )
      .pipe(
        map((responseData: { [key: string]: FlatModel }) => {
          const flat = [];

          for (const key in responseData) {
            if (responseData.hasOwnProperty(key)) {
              flat.push({ ...responseData[key], serialNo: key });
            }
          }
          return flat;
        })
      );
  }
  fetchFlatById(flatId: string, parentId: string, societyId: string) {
    return this.http
      .get<{ [key: string]: FlatModel }>(
        `http://localhost:9191/society/${societyId}/tower/${parentId}/flat/${flatId}`,
        {
          responseType: 'json',
        }
      )
      .pipe(
        map((responseData: { [key: string]: FlatModel }) => {
          const flat = [];

          for (const key in responseData) {
            if (responseData.hasOwnProperty(key)) {
              flat.push({ ...responseData[key], serialNo: key });
            }
          }
          return flat;
        })
      );
  }
  updateFlatDetails(
    flatId: string,
    parentId: string,
    societyId: string,
    newFlat
  ) {
    this.http
      .put(
        `http://localhost:9191/society/${societyId}/tower/${parentId}/flat/${flatId}/updateStatus`,
        newFlat
      )
      .subscribe(() => {
        alert('Updated flats');
      });
  }
}
