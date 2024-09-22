import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';


@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.css']
})



export class CreateEmployeeComponent {
  employeesarray: any[]=[];
  departmentsarray: any[]=[];
  isResultLoaded = false;
  isUpdateFormActive = false;

  id : number =0;
  prenom : string ="";
  nom : string="";
  email : string="";
  password : string="";
  role : string =""
  
  dep: { id: number,nom:string} = {
    id:1,
    nom: ""
  };

  adminnom:string=""
  adminprenom:string=""

  //form validation
  //HTML / type="submit" [disabled]="isSaveButtonDisabled"
  isSaveButtonDisabled: boolean = true;

  updateSaveButtonState() {
    this.isSaveButtonDisabled = this.nom.trim() === '' ||
    this.prenom.trim() === '' ||
    this.email.trim() === '' ||
    this.password.trim() === ''
  }


  constructor(private http: HttpClient,private router:Router ){
    this.getallemployees();
    this.getalldepartments();
    this.adminnom = localStorage.getItem('adminnom') || this.adminnom
    this.adminprenom = localStorage.getItem('adminprenom') || this.adminprenom

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

  enregistrer(){

    this.dep.id = this.departmentsarray.find(dep => dep.nom === this.dep.nom)?.id; 

    let bodyData = {
      "nom" : this.nom,
      "prenom" : this.prenom,
      "email" : this.email,
      "password" : this.password,
      "dep": { id: this.dep.id },
      "role" : this.role
    };


    this.http.post("http://localhost:8084/api/v1/employee/save",bodyData,{responseType: 'text'}).subscribe((resultData: any)=>
    {
        this.getallemployees();
 
        this.nom = '';
        this.prenom = '';
        this.email  = '';
        this.password  = '';
        this.dep.id ;
        this.role
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
  admin (){this.router.navigateByUrl("/admin")}
}

