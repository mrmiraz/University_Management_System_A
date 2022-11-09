import { Component, OnInit } from '@angular/core';
import { Course } from '../models/course';
import { CourseService } from '../services/course.service';

@Component({
  selector: 'app-course',
  templateUrl: './course.component.html',
  styleUrls: ['./course.component.css']
})
export class CourseComponent implements OnInit {

  constructor(private service: CourseService) { 
    this.getAllCourse();
  }

  ngOnInit(): void {
  }

  //resister a new course here
  register(registerForm:any){
    if(registerForm.code == "" || registerForm.name == ""){
      alert("Field is Empty!");
      return;
    }

    this.service.addOrUpdateCourse(registerForm).subscribe(
      (res)=>{
        alert("Successfully register");
        this.getAllCourse();
        console.log(res);
      },
      (error)=>{
        console.log(error);
      }
    )
  }

  // find all course function
  courses:any;
  getAllCourse(){
    this.service.getAllCourse().subscribe(
      (res)=>{
        this.courses = res;
        console.log(res);
      },
      (error)=>{
        console.log(error);
      }
    )
  }

  // delete course from here
  deleteCourse(code:String){
    this.service.deleteCourse(code).subscribe(
      (res)=>{
        if(res != null){
          alert("Success fully deleted!");
          
        }
        this.getAllCourse();
        console.log(res);
      },
      (error)=>{
        console.log(error);
      }
    )
  }

  //update course from here
  updateCourse(course:Course){
    console.log(course);
    this.service.updateCourse(course).subscribe(
      (res)=>{
        this.getAllCourse();
        alert("Successfully updated!");
        console.log(res);
      },
      (error)=>{
        console.log(error);
      }
    )
  }

  // type = 101;
  course = {

    "code":"",
    "name":"",
  };

  // show object value which are going to updated in update form
  setCourse(course:any){
    this.course = course;
  }

  //search course by their id
  searchByCode(code:String){
    if(code == ""){
      this.getAllCourse();
      return;
    }
    this.service.searchByCode(code).subscribe(
      (res)=>{
        if(res != null){
          this.courses = res;
        }
        // console.log(res);
      },
      (error)=>{
        this.getAllCourse();
        console.log(error);
      }
    )
  }
}
