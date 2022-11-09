import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AppComponent } from '../app.component';
import { Admin } from '../models/admin';
import { AdminService } from '../services/admin.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  constructor(private service:AdminService) { 
    this.getAllAdmin();
  }

  ngOnInit(): void {
  }

  //resister an admin
  register(resisterAdminForm:any){
    if(resisterAdminForm.userName == "" || resisterAdminForm.password == ""){
      alert("Field is Empty!");
      return;
    }
    this.service.addOrUpdateAdmin(resisterAdminForm).subscribe(
      (res)=>{
        alert("Successfully register");
        this.getAllAdmin();
        console.log(res);
      },
      (error)=>{
        console.log(error);
      }
    )
  }

  // find all admins function
  admins:any;
  getAllAdmin(){
    this.service.getAllAdmin().subscribe(
      (res)=>{
        this.admins = res;
        console.log(res);
      },
      (error)=>{
        console.log(error);
      }
    )
  }

  // delete admin from here
  deleteAdmin(userName:String){
    this.service.deleteAdmin(userName).subscribe(
      (res)=>{
        if(res != null){
          alert("Success fully deleted!");
          
        }
        this.getAllAdmin();
        console.log(res);
      },
      (error)=>{
        console.log(error);
      }
    )
  }

  //update admin from here
  updateAdmin(admin:Admin){
    console.log(admin);
    this.service.updateAdmin(admin).subscribe(
      (res)=>{
        this.getAllAdmin();
        alert("Successfully updated!");
        console.log(res);
      },
      (error)=>{
        console.log(error);
      }
    )
  }

  admin = {

    "userName":"",
    "password":"",
  };

  // show object value which are going to updated in update form
  setAdmin(admin:any){
    this.admin = admin;
  }

  //search admin by their username
  searchByUserName(userName:String){
    if(userName == ""){
      this.getAllAdmin();
      return;
    }
    this.service.searchByUserName(userName).subscribe(
      (res)=>{
        if(res != null){
          this.admins = res;
        }
        console.log(res);
      },
      (error)=>{
        this.getAllAdmin();
        console.log(error);
      }
    )
  }
}
