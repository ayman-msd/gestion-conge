import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { LoginService } from '../login.service';
import { Router } from '@angular/router';
import { PdfGeneratorService } from '../pdf-generator.service';
import { Chart } from 'chart.js';



@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css'],
})
export class AdminComponent {
  
  congesarray: any[]=[];
  departmentsarray: any[]=[];
  isResultLoaded = false;
  isUpdateFormActive = false;

  id : number =0;
  nature : string ="";
  date_d : string="";
  date_f :string="";
  date_rep :string="";
  etat : string="en attente"

  nom : string=""
  prenom : string=""
  email : string=""
  password : string=""
  

  constructor(private http: HttpClient,private infos:LoginService,private router :Router,private pdfGeneratorService: PdfGeneratorService){
    this.getallconges();
    this.getalldepartments()
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

  nb_conges(){
    return this.congesarray.length;
  }
  
  p_conges(){
    return (this.congesarray.length*60)/100
  }

  logout(){
    //this.infos.logout()
    this.router.navigateByUrl("/login")
    localStorage.removeItem('adminEmail')
    localStorage.removeItem('adminpassword')
    localStorage.removeItem('adminnom')
    localStorage.removeItem('adminprenom')
  }

  update_conge(){
    this.http.get("http://localhost:8084/api/v1/conge/update")
  }


  createPieChart(): void {
   /* const colors = this.generateRandomColors(this.departmentsarray.length);

    new Chart('departmentPieChart', {
      type: 'pie',
      data: {
        labels: this.departmentsarray,
        datasets: [{
          data: [/* Your data values here ],
          backgroundColor: colors,
        }]
      },
      options: {
        responsive: true,
        maintainAspectRatio: false,

        title: {
          display: true,
          text: 'Department Distribution'
        } 
      } 
    });
  }

  generateRandomColors(numColors: number): string[] {
    const colors = [];
    for (let i = 0; i < numColors; i++) {
      const randomColor = `#${Math.floor(Math.random() * 16777215).toString(16)}`;
      colors.push(randomColor);
    }
    return colors;
  }*/
}
}
