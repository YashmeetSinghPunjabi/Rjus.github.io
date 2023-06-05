import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  userName="";
  passWard="";
  Str="/login";
  check()
  {
    console.log("check chala")
    if(this.userName==="dusyant"&&this.passWard==="ypunjabi")
    {
      console.log("Yashmeet");
      alert("LOggedin");
    }
    else
    {
      console.log(this.userName)
    }
  }
  constructor() { 

    
  }
  username(a:any){
 
  this.userName=a.target.value;  

  }
  
  passward(b:any)
  {
    this.passWard=b.target.value;
    console.log(this.passWard)
  }
  ngOnInit(): void {
  }

}
