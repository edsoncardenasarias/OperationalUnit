import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '@soa/env/environment.development';
import { Funcionary } from '../model/funcionary.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class FuncionaryService {

  private urlFuncionary = `${environment.apiUrl}/ms-soa`;
  funcionarySelected: Funcionary | undefined = undefined;

  private baseUrl = 'http://localhost:8080';
  private apiUrl = 'http://localhost:8080/getData';

  constructor(private http: HttpClient) {}

  findAll() {
    return this.http.get(`${this.urlFuncionary}/listData`);
  }

  findAllDataActive() {
    return this.http.get(this.urlFuncionary + '/listData/active');
  }

  findAllDataInactive() {
    return this.http.get(this.urlFuncionary + '/listData/inactive');
  }

  saveNewFuncionary(funcionary: Funcionary) {
    return this.http.post(this.urlFuncionary, funcionary);
  }

  updateDataFuncionary(funcionary: Funcionary) {
    return this.http.put(this.urlFuncionary + '/' + funcionary.id, funcionary);
  }

  deleteLogicalDataFuncionary(funcionary: Funcionary) {
    return this.http.patch(this.urlFuncionary + '/deleteLogical/' + funcionary.id, funcionary);
  }

  reactiveLogicalDataFuncionary(funcionary: Funcionary) {
    return this.http.patch(this.urlFuncionary + /reactiveLogical/ + funcionary.id, funcionary);
  }

  mergePdf(pdfUrls: string[]): Observable<Blob> {
    return this.http.post<Blob>(`${this.baseUrl}/merge-pdf`, pdfUrls, {
      responseType: 'blob' as 'json'
    });
  }

  getData(): Observable<any> {
    return this.http.get(this.apiUrl);
  }


}
