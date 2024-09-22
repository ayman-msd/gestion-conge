import { Component } from '@angular/core';
import { Router, RouterLink } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})

export class EmployeeComponent {

  employeesarray: any[]=[];
  departmentsarray: any[]=[];
  isResultLoaded = false;
  isUpdateFormActive = false;

  id : number =0;
  prenom : string ="";
  nom : string="";
  email :string="";

  dep: { nom: string} = {
    nom: "",
  };




  constructor(private http: HttpClient,private router:Router ){
    this.getallemployees();
    this.nom = localStorage.getItem('adminnom') || this.nom
    this.prenom = localStorage.getItem('adminprenom') || this.prenom

    let email = localStorage.getItem('adminEmail')
    let password = localStorage.getItem('adminpassword')

    if (email == undefined || password == undefined) {
      this.router.navigateByUrl("/error_404")
    }
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

  logout(){
    //this.infos.logout()
    this.router.navigateByUrl("/login")
    localStorage.removeItem('adminEmail')
    localStorage.removeItem('adminpassword')
    localStorage.removeItem('adminnom')
    localStorage.removeItem('adminprenom')
  }
}
