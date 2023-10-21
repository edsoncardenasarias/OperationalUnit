import { Injectable } from '@angular/core';
import { environment } from "@soa/env/environment.development";
import { Asignation } from "@soa/asignation/model/asignation.model";
import { HttpClient } from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class AsignationService {

  private urlAsignation = `${environment.apiUrlAsignation}/api/transaccionalData`;
  asignationSelected: Asignation | undefined = undefined;

  constructor(private _http: HttpClient) { }

  findAll() {
    return this._http.get(this.urlAsignation + '/listData');
  }

  saveNewAsignation(asignation: Asignation) {
    return this._http.post(this.urlAsignation, asignation);
  }

  updateDataAsignation(asignation: Asignation) {
    return this._http.put(this.urlAsignation + '/' + asignation.id_funcionaryteend, asignation);
  }

}
