import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})

export class LoginService {

  employeesarray: any[]=[];
  private localStorageKey = 'loggedInUser';



  //2 the variables that will hold the infos coming from the loging component and send them to the conge-depose component (go check the conge-depose.ts for the 3 step)
  id : number=0
  nom : string=""
  prenom : string=""
  email : string=""
  password : string=""


  


  constructor(private http:HttpClient,private router : Router,) { 
    /*this.id = this.login_info.id
    this.nom = this.login_info.nom
    this.prenom = this.login_info.prenom
    this.email = this.login_info.email
    this.password = this.login_info.password*/
  }
  

  /*Login(email:string,password:string){
    let exist = this.employeesarray.find (m=> m.email == this.email && m.password == this.password)
    
    if (exist != undefined){
      
    }
  }*/


  logout (){
    //localStorage.removeItem(this.localStorageKey);
    this.router.navigateByUrl("/login")
  }

  
}
