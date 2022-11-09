import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AppComponent } from '../app.component';
import { Student } from '../models/student';
import { StudentService } from '../services/student.service';

@Component({
  selector: 'app-student-dashboard',
  templateUrl: './student-dashboard.component.html',
  styleUrls: ['./student-dashboard.component.css']
})
export class StudentDashboardComponent implements OnInit {

  constructor(private service:StudentService) {
    this.getAllStudent();
   }

  ngOnInit(): void {

  }

  //resister a new student here
  register(registerForm:any){
    if(registerForm.id == "" || registerForm.firstName== "" || registerForm.lastName == "" || registerForm.phoneNumber1 == ""|| registerForm.email1 == "" ||
    registerForm.gender == "", registerForm.address == "" || registerForm.batch == "" || registerForm.cgpa == ""){
      alert("Field is Empty!");
      return;
    }
    
    this.service.addOrUpdateStudent(registerForm).subscribe(
      (res)=>{
        alert("Successfully register");
        this.getAllStudent();
        console.log(res);
      },
      (error)=>{
        console.log(error);
      }
    )
  }

  // find all student function
  students:any;
  getAllStudent(){
    this.service.getAllStudents().subscribe(
      (res)=>{
        this.students = res;
        console.log(res);
      },
      (error)=>{
        console.log(error);
      }
    )
  }

  // delete student from here
  deleteStudent(id:number){
    this.service.deleteStudent(id).subscribe(
      (res)=>{
        if(res != null){
          alert("Success fully deleted!");
          
        }
        this.getAllStudent();
        console.log(res);
      },
      (error)=>{
        console.log(error);
      }
    )
  }

  //update student from here
  updateStudent(student:Student){
    console.log(student);
    this.service.updateStudent(student).subscribe(
      (res)=>{
        this.getAllStudent();
        alert("Successfully updated!");
        // this.setStudentNull();
        console.log(res);
      },
      (error)=>{
        console.log(error);
      }
    )
  }

  student = {
    "id":0,
    "firstName":"",
    "lastName":"",
    "phoneNumber1":"",
    "phoneNumber2":"",
    "email1":"",
    "email2":"",
    "gender":"",
    "address":"",
    "batch":"",
    "cgpa":""
  };

  // show object value which are going to updated in update form
  setStudent(student:any){
    this.student = student;
  }

  //search student by their id
  searchById(id:String){
    if(id == ""){
      this.getAllStudent();
      return;
    }

    this.students = new Array();
    this.service.searchById(Number(id)).subscribe(
      (res)=>{
        if(res != null){
          this.students.push(res);
        }
        console.log(res);
      },
      (error)=>{
        this.getAllStudent();
        console.log(error);
      }
    )
  }

  // search student by their name letter
  searchByName(name:String){
    if(name ==""){
      this.getAllStudent();
      return;
    }
    this.service.searchByName(name).subscribe(
      (res)=>{
        this.students = res;
        console.log(res);
      },
      (error)=>{
        console.log(error);
      }
    )
  }
}
