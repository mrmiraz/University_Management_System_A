import { Component, enableProdMode, OnInit } from '@angular/core';
import { Route, Router } from '@angular/router';
import { AppComponent } from '../app.component';
import { Admin } from '../models/admin';
import { AdminService } from '../services/admin.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private adminService: AdminService, private router: Router, private root: AppComponent) {
    sessionStorage.setItem("loginSession", "0");
    root.loginSuccess = false;
    router.navigate(["admin-login"]);
   }

  ngOnInit(): void {
    
  }

  admin ={
    userName :"",
    password :""
  };

  //find a admin
  findAdmin(userName:String){
    this.adminService.searchByUserName(userName).subscribe(
      (res)=>{
        console.log(res);
      },
      (error)=>{
        console.log(error);
      }
    )
  }

  //login authentication here
  login(admin:Admin){
    if(admin.userName == ""|| admin.password == ""){
      alert("Field is Empty!");
      return;
    }
    // console.log(admin.password);
    this.adminService.login(admin).subscribe(
      (res)=>{
        // console.log(admin.userName);
        if(res == null){
          alert("username or password is wrong");
          return;
        }
        //login success and go to student dashboard
        this.router.navigate(["/student-dashboard"]);
        sessionStorage.setItem('loginSession', '1');
        this.root.loginSuccess = true;
        // console.log(res);
      },
      (error)=>{
        console.log(error);
      }
    )
  }

}
