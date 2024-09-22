import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/login.service';
import * as $ from 'jquery'; // Import jQuery (if needed)

@Component({
  selector: 'app-deposer-conge',
  templateUrl: './deposer-conge.component.html',
  styleUrls: ['./deposer-conge.component.css']
})
export class DeposerCongeComponent {
  congesarray: any[]=[];
  employeesarray: any[]=[];
  isResultLoaded = false;
  isUpdateFormActive = false;

  id : number =0;
  nature : string ="Autre...";
  date_d : string="";
  date_f :string="";
  date_rep :string="";
  etat :string="en attente";
  emp : { id :number} = {
    id : 1
  };

  nom:string=""
  prenom:string=""

  isSaveButtonDisabled: boolean = true;

  updateSaveButtonState() {
    this.isSaveButtonDisabled = this.date_d.trim() === '' ||
    this.date_f.trim() === '' ||
    this.date_rep.trim() === '' 
  }

  constructor(private http: HttpClient,private infos : LoginService, private router : Router){
    this.getallconges();
    this.nom = localStorage.getItem('usernom') || this.nom
    this.prenom = localStorage.getItem('userprenom') || this.prenom

    let email = localStorage.getItem('userEmail')
    let password = localStorage.getItem('userpassword')

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

  enregistrer(){

    let bodyData = {
      "nature" : this.nature,
      "date_d" : this.date_d,
      "date_f" : this.date_f,
      "date_rep" : this.date_rep,
      "emp" : {id: localStorage.getItem('userid')},
      "etat": this.etat
    };
    console.log("idddd:"+bodyData.emp.id)
    this.http.post("http://localhost:8084/api/v1/conge/save",bodyData,{responseType: 'text'}).subscribe((resultData: any)=>
    {
        this.getallconges();
 
        this.nature = '';
        this.date_d = '';
        this.date_rep  = '';
        this.emp.id ;
        this.etat='';
        alert("Congé bien déposé et sera traité par votre admin")
    });
    this.router.navigateByUrl("/conge_depose")
    console.log("id emp: "+this.infos.id)
  }
}
