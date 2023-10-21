import {Component, EventEmitter, OnDestroy, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {FormBuilder, FormGroup} from "@angular/forms";
import {FuncionaryService} from "@soa/funcionary/services/funcionary.service";
import {MatDialog} from "@angular/material/dialog";
import {TeenService} from "@soa/teen/services/teen.service";

@Component({
  selector: 'app-teen-form',
  templateUrl: './teen-form.component.html',
  styleUrls: ['./teen-form.component.scss']
})
export class TeenFormComponent implements OnInit, OnDestroy {

  teenDataForm: FormGroup = new FormGroup({});
  teenData: any[] = [];

  constructor(private router: Router,
              private fb: FormBuilder,
              public teenServices: TeenService,
              public dialog: MatDialog) {}

  ngOnInit(): void {
    this.initTeenForm();
    this.findAllDataActive();
  }

  navigateToTeenList() {
    this.router.navigate(['adolescente/teen-list']).then(() => {
      console.log('Se está redirigiendo a la pestaña de listado de datos');
    });
  }

  findAllDataActive() {
    this.teenServices.findAllDataActive().subscribe((dataTeenActive: any) => {
      console.log('Estos son los datos en modo activos que se están recibiendo de la Base de Datos: ', dataTeenActive);
      this.teenData = dataTeenActive;
    })
  }

  initTeenForm() {
    this.teenDataForm = this.fb.group({
      id_program: [null],
      name: [''],
      type: [''],
      duration: [''],
      responsible: [''],
      description: [''],
      beneficiary: [''],
      condition: ['A'],
    });
    if (this.teenServices.teenSelected) {
      this.teenDataForm.patchValue(this.teenServices.teenSelected);
    }
  }

  saveTeen() {
    if (this.teenServices.teenSelected) {
      // Actualizar || Modificar
      this.updateDataTeen();
    } else {
      // Registrar || Crear
      this.registerNewDataTeen();
    }
  }

  registerNewDataTeen() {
    console.log('Datos ingresados en el formulario: ', this.teenDataForm.value);
    this.teenServices.saveNewTeen(this.teenDataForm.value).subscribe((dataRegister) => {
      console.log('Los datos ingresados dentro del formulario para registrar || crear son: ', dataRegister);
      this.teenDataForm.reset();
      this.navigateToTeenList();
      this.findAllDataActive();
      this.dialog.closeAll();
    })
  }

  updateDataTeen() {
    console.log('Datos ingresados en el formulario: ', this.teenDataForm.value);
    this.teenServices.updateDataTeen(this.teenDataForm.value).subscribe((dataUpdate) => {
      console.log('Los datos ingresados dentro del formulario para modificar || actualiazr son: ', dataUpdate);
      this.teenDataForm.reset();
      this.navigateToTeenList();
      this.dialog.closeAll();
    })
  }

  ngOnDestroy(): void {
    this.teenServices.teenSelected = undefined;
  }
}
