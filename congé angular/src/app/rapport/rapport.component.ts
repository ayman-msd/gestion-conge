import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { LoginService } from '../login.service';
import { PdfGeneratorService } from '../pdf-generator.service';

@Component({
  selector: 'app-rapport',
  templateUrl: './rapport.component.html',
  styleUrls: ['./rapport.component.css']
})
export class RapportComponent {

  employeesarray: any[]=[];
  departmentsarray: any[]=[];
  congesarray: any[]=[];

  isResultLoaded = false;
  isUpdateFormActive = false;

  nom : string=""
  prenom : string=""
  email : string=""
  password : string=""

  constructor(private http: HttpClient,private infos:LoginService,private router :Router,private pdfGeneratorService: PdfGeneratorService){
    this.getallconges();
    this.getalldepartments();
    this.getallemployees();

    this.nom = localStorage.getItem('adminnom') || this.nom
    this.prenom = localStorage.getItem('adminprenom') || this.prenom

    let email = localStorage.getItem('adminEmail')
    let password = localStorage.getItem('adminpassword')

    if (email == undefined || password == undefined) {
      this.router.navigateByUrl("/error_404")
    }
    
  }

  getallconges()
  {
    
    this.http.get("http://localhost:8084/api/v1/conge/getallconges")
  
    .subscribe((resultData: any)=>
    {
        this.isResultLoaded = true;
        console.log(resultData);
        this.congesarray = resultData;
    });
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

  getallemployees()
  {
    
    this.http.get("http://localhost:8084/api/v1/employee/getallemployees")
  
    .subscribe((resultData: any)=>
    {
        this.isResultLoaded = true;
        console.log(resultData);
        this.employeesarray = resultData;
    });
  }

  generatePdf() {
    const pdfContent = document.getElementById('pdf-content'); 
    console.log(pdfContent)
  
    if (pdfContent) {
      this.pdfGeneratorService.generatePdf(pdfContent);
    }
  }

  
}


