import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})


export class LoginComponent {

  employeesarray: any[]=[];
  departmentsarray: any[]=[];
  isResultLoaded = false;
  isUpdateFormActive = false;

  id : number =0;
  prenom : string ="";
  nom : string="";
  email :string="";
  password :string="";
  

  dep: { nom: string} = {
    nom: "",
  };

  loginobj : {email:string,password:string} ={
    email:"",
    password:""
  }

  constructor(private http: HttpClient , private router:Router,private infos:LoginService){
    this.getallemployees();
    //console.log(localStorage.getItem('userEmail'))
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

  //login assli
  login( ){

    let exist = this.employeesarray.find (m=> m.email == this.loginobj.email && m.password == this.loginobj.password)

    if (exist != undefined){
      
      if(exist.role == "employé"){
        localStorage.setItem('userid',exist.id)
        localStorage.setItem('userEmail', exist.email);
        localStorage.setItem('userpassword',exist.password);
        localStorage.setItem('usernom',exist.nom);
        localStorage.setItem('userprenom',exist.prenom);
      this.router.navigateByUrl("/conge_depose")}
      
      else if (exist.role == "admin"){this.router.navigateByUrl("/admin")
        localStorage.setItem('adminEmail', exist.email);
        localStorage.setItem('adminpassword',exist.password);
        localStorage.setItem('adminnom',exist.nom);
        localStorage.setItem('adminprenom',exist.prenom);
      }

      else alert("vous n'avez auccun role sur cette entreprise")

      //1 sending loging infos to the service variables (go check loginservice.ts for step 2)
      this.infos.id = exist.id
      this.infos.nom = exist.nom
      this.infos.prenom = exist.prenom
      this.infos.email = exist.email
      this.infos.password= exist.password
    }
    
    else alert("infos incorrectes")
    
  }

  
  
}

