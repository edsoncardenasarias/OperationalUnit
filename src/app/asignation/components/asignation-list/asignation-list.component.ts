import {Component, OnDestroy, OnInit} from '@angular/core';
import {AsignationService} from "@soa/asignation/services/asignation.service";
import {FuncionaryService} from "@soa/funcionary/services/funcionary.service";
import {TeenService} from "@soa/teen/services/teen.service";
import {Router} from "@angular/router";
import {FormBuilder} from "@angular/forms";
import {Asignation} from "@soa/asignation/model/asignation.model";

@Component({
  selector: 'app-asignation-list',
  templateUrl: './asignation-list.component.html',
  styleUrls: ['./asignation-list.component.scss']
})
export class AsignationListComponent implements OnInit, OnDestroy {

  funcionaryColumns: string[] = ['dataFuncionary', 'dniFuncionary','depaFuncionary', 'dataTeen', 'dniTeen', 'descripcionAsignacion', 'actions'];
  asignationData: any[] = [];

  constructor(private _asignationService: AsignationService,
              private _asignationDataFuncionaryService: FuncionaryService,
              private _asignationDataTeenService: TeenService,
              private _router: Router,
              private _fb: FormBuilder) {
  }

  ngOnInit(): void {
    this.findAllDataAsignation();
  }

  navigateToForm() {
    this._router.navigate(['asignacion/asignation-form']).then(() => {
      console.log('Se está redirigiendo al formulario de registro.')
    })
  }

  findAllDataAsignation() {
    this._asignationService.findAll().subscribe((dataAsignation: any) => {
      console.log('Datos de la asignación: ', dataAsignation);
      this.asignationData = dataAsignation;
    })
  }

  findAllDataFuncionary() {
    this._asignationDataFuncionaryService.findAllDataActive()
  }

  updateDataAsignation(asignation: Asignation) {
    this._asignationService.asignationSelected = asignation;
    this.navigateToForm();
  }

  deleteLogical() {

  }

  ngOnDestroy(): void {
  }
}
