import { Component } from '@angular/core';
import { Router, RouterLink } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-conge',
  templateUrl: './conge.component.html',
  styleUrls: ['./conge.component.css']
})
export class CongeComponent {

  congesarray: any[]=[];
  employeesarray: any[]=[];
  isResultLoaded = false;
  isUpdateFormActive = false;

  id : number =0;
  idd : number=0
  nature : string ="";
  date_d : string="";
  date_f :string="";
  date_rep :string="";
  etat :string="en attent"
  
  emp:{id:number,nom:string,prenom:string}={
    id:1,
    nom:"",
    prenom:""
  }

  nom:string=""
  prenom:string=""
  



  constructor(private http: HttpClient,private router:Router ){
    this.getallconges();
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
  
    .subscribe((resultconge: any)=>
    {
        this.isResultLoaded = true;
        console.log(resultconge);
        this.congesarray = resultconge;
    });
  }

  getallemployees()
  {
    
    this.http.get("http://localhost:8084/api/v1/employee/getallemployees")
  
    .subscribe((resultconge: any)=>
    {
        this.isResultLoaded = true;
        console.log(resultconge);
        this.employeesarray = resultconge;
    });
  }

  update(conge: any, etat:string){
    this.nature = conge.nature;
    this.date_d = conge.date_d;
    this.date_f = conge.date_f;
    this.date_rep = conge.date_r;
    this.etat = etat;
    this.emp.id = conge.emp.id
    this.idd = conge.id;

    console.log(this.emp.id)
    let bodyconge = {
      "id" : this.idd,
      "etat" : this.etat
    };
    
    this.http.put("http://localhost:8084/api/v1/conge/update",bodyconge,{responseType: 'text'}).subscribe((resultconge: any)=>
    {
        console.log(this.congesarray);
        alert("conge "+etat)
        this.getallconges();
        this.etat  = '';
    }
    );
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
