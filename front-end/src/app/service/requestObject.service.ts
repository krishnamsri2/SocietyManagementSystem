import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class RequestObjectService {
  private request = {
    token: {
      societyId: 11,
      userId: 12,
    },
    requestObject: {},
  };
  putRequestObject(object) {
    this.request.requestObject = object;
  }
  getRequestObject() {
    return this.request;
  }
}
