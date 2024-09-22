import { Component, Input } from '@angular/core';
import { LoginService } from 'src/app/login.service';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';


@Component({
  selector: 'app-conge-depose',
  templateUrl: './conge-depose.component.html',
  styleUrls: ['./conge-depose.component.css']
})


export class CongeDeposeComponent {

  congesarray: any[]=[];
  employeesarray: any[]=[];
  isResultLoaded = false;
  isUpdateFormActive = false;

  id : number =0;
  nature : string ="";
  date_d : string="";
  date_f :string="";
  date_rep :string="";
  etat :string="";
  
  emp:{nom:string,prenom:string,email:string}={
    nom:"",
    prenom:"",
    email:""
  }

  exist:any

  constructor(private infos:LoginService,private http:HttpClient,private router:Router) { 

    //3 reading the variables from the service (variables saved from login component)
    this.emp.nom = localStorage.getItem('usernom') || this.emp.nom
    this.emp.prenom = localStorage.getItem('userprenom') || this.emp.prenom
    this.getallconges()

    let email = localStorage.getItem('userEmail')
    let password = localStorage.getItem('userpassword')

    if (email == undefined || password == undefined) {
      this.router.navigateByUrl("/error_404")
    }

  }


  getallconges()
  {
    let email = localStorage.getItem('userEmail')
    
      this.http.get("http://localhost:8084/api/v1/conge/getallconges")
    
      .subscribe((resultData: any)=>
      {
          this.isResultLoaded = true;
          console.log(resultData);
          this.congesarray = resultData.filter((conge: any) => conge.emp.email === email);
   });
  
  }

  deposer (){
    this.router.navigateByUrl("/deposer_conge")
  }

 logout (){
  this.infos.logout()
  localStorage.removeItem('userEmail')
  localStorage.removeItem('password')
  localStorage.removeItem('nom')
  localStorage.removeItem('prenom')
 }
}

