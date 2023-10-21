import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '@soa/env/environment.development';
import {Teen} from "@soa/teen/model/teen.model";

@Injectable({
  providedIn: 'root',
})
export class TeenService {

  private urlTeen = `${environment.apiUrlTeen}/v1/programs`;

  teenSelected: Teen | undefined = undefined;

  constructor(private http: HttpClient) {}

  findAll() {
    return this.http.get(`${this.urlTeen}/list`);
  }

  findAllDataActive() {
    return this.http.get(this.urlTeen + '/listA');
  }

  saveNewTeen(teen: Teen) {
    return this.http.post(this.urlTeen + '/save', teen);
  }

  updateDataTeen(teen: Teen) {
    return this.http.put(this.urlTeen + '/update/' + teen.id_program, teen);
  }

  deleteLogicalDataTeen(teen: Teen) {
    return this.http.patch(this.urlTeen + '/delete/' + teen.id_program, teen);
  }
}
