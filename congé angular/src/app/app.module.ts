import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { Router, RouterModule } from '@angular/router';
import {HttpClientModule} from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { AdminComponent } from './admin/admin.component';
import { FormsModule } from '@angular/forms';
import { EmployeeComponent } from './employee/employee.component';
import { CreateEmployeeComponent } from './employee/create-employee/create-employee.component';
import { DepartmentComponent } from './department/department.component';
import { CreateDepartmentComponent } from './department/create-department/create-department.component';
import { CongeComponent } from './conge/conge.component';
import { DeposerCongeComponent } from './conge/deposer-conge/deposer-conge.component';
import { CongeDeposeComponent } from './conge/conge-depose/conge-depose.component';
import { LoginComponent } from './login/login.component';
import { NotAllowedComponent } from './not-allowed/not-allowed.component';
import { LandingComponent } from './landing/landing.component';
import { RapportComponent } from './rapport/rapport.component';




@NgModule({
  declarations: [
    AppComponent,
    AdminComponent,
    EmployeeComponent,
    CreateEmployeeComponent,
    DepartmentComponent,
    CreateDepartmentComponent,
    CongeComponent,
    DeposerCongeComponent,
    CongeDeposeComponent,
    LoginComponent,
    NotAllowedComponent,
    LandingComponent,
    RapportComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FontAwesomeModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot([
      {path : 'admin' , component : AdminComponent},
      {path : 'employees' , component : EmployeeComponent},
      {path : 'create_employee' , component : CreateEmployeeComponent},
      {path : 'department' , component : DepartmentComponent},
      {path : 'create_department' , component : CreateDepartmentComponent},
      {path : 'conges' , component : CongeComponent},
      {path : 'deposer_conge' , component : DeposerCongeComponent},
      {path : 'conge_depose' , component : CongeDeposeComponent},
      {path : 'rapport' , component : RapportComponent},
      {path : 'login' , component : LoginComponent},
      {path : 'error_404' , component : NotAllowedComponent},
      {path : 'landing' , component : LandingComponent},
      {path : '' , component : LandingComponent},
    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
