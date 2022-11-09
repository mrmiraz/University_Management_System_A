import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Course } from '../models/course';

@Injectable({
  providedIn: 'root'
})

export class CourseService {
  courseApi = "http://localhost:8080/course"
  constructor(private http: HttpClient) { }

  searchByCode(code:String){
    return this.http.get(this.courseApi+"/find/"+code);
  }

  addOrUpdateCourse(course:Course){
    return this.http.post(this.courseApi+"/add", course);
  }

  getAllCourse(){
    return this.http.get(this.courseApi+"/find/all");
  }

  deleteCourse(code:String){
    return this.http.delete(this.courseApi+"/delete/"+code);

  }

  updateCourse(course:Course){
    return this.http.put(this.courseApi+"/update/",course);
  }
}
