import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  loginSuccess:boolean = false;
  constructor(){
    this.loginSuccess = this.getSession();
  }
  title = 'UMS';

  getSession(){
    if(sessionStorage.getItem("loginSession") == null || sessionStorage.getItem("loginSession") == "0"){
      return false;
    }
    return true;
  }
  
  setLougout(){
    this.loginSuccess = false;
  }
}
