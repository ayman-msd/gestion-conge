import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-create-department',
  templateUrl: './create-department.component.html',
  styleUrls: ['./create-department.component.css']
})

export class CreateDepartmentComponent {

  departmentsarray: any[]=[];
  isResultLoaded = false;
  isUpdateFormActive = false;

  id : number =0;
  nom : string="";
  nomm:string=""
  prenom:string=""

  adminnom:string=""
  adminprenom:string=""

  //form validation
  isSaveButtonDisabled: boolean = true;

  updateSaveButtonState() {
    this.isSaveButtonDisabled = this.nom.trim() === '';
  }

  constructor(private http: HttpClient, private router:Router,private fb: FormBuilder ){
    this.getalldepartments();
    this.adminnom = localStorage.getItem('adminnom') || this.nomm
    this.adminprenom = localStorage.getItem('adminprenom') || this.prenom

    let email = localStorage.getItem('adminEmail')
    let password = localStorage.getItem('adminpassword')

    if (email == undefined || password == undefined) {
      this.router.navigateByUrl("/error_404")
    }
  }

  getalldepartments()
  {
    
    this.http.get("http://localhost:8084/api/v1/department/getalldepartments")
  
    .subscribe((resultData: any)=>
    {
        this.isResultLoaded = true;
        console.log(resultData);
        this.departmentsarray = resultData;
    });
  }

  enregistrer(){
    let bodyData = {
      "nom" : this.nom,
    };

    this.http.post("http://localhost:8084/api/v1/department/save",bodyData,{responseType: 'text'}).subscribe((resultData: any)=>
    {
        this.getalldepartments();
 
        this.nom = '';
    });

    this.router.navigateByUrl("/department")
  }

  logout(){
    //this.infos.logout()
    this.router.navigateByUrl("/login")
    localStorage.removeItem('adminEmail')
    localStorage.removeItem('adminpassword')
    localStorage.removeItem('adminnom')
    localStorage.removeItem('adminprenom')
  }
}
