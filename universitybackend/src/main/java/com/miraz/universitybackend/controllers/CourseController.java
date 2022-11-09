package com.miraz.universitybackend.controllers;

import com.miraz.universitybackend.models.Course;
import com.miraz.universitybackend.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/course")
@CrossOrigin("*")

public class CourseController {

    @Autowired
    private CourseService courseService;

    //creating api for add a course in the database
    @PostMapping("/add")
    public ResponseEntity<Course> addOrUpdateCourse(@RequestBody Course course){
        return new ResponseEntity<>(courseService.addOrUpdateCourse(course), HttpStatus.OK);
    }

    // creating api for finding all the course from the database
    @GetMapping("/find/all")
    public ResponseEntity<List<Course>> getAllCourse(){
        return  new ResponseEntity<>(courseService.getAllCourse(), HttpStatus.OK);
    }

    // creating api for deleting a course
    @DeleteMapping("/delete/{code}")
    public ResponseEntity<Optional<Course>> deleteCourse(@PathVariable("code") String code){
        return new ResponseEntity<>(courseService.deleteCourse(code), HttpStatus.OK);
    }

    //creating api for finding course with their course code
    @GetMapping("/find/{code}")
    public ResponseEntity<List<Optional<Course>>> findByCode(@PathVariable("code") String code){
        return new ResponseEntity<>(courseService.findByCode(code), HttpStatus.OK);

    }

    //creating api for updating course
    @PutMapping("/update/")
    public ResponseEntity<Course> updateCourse(@RequestBody Course course){
        return  new ResponseEntity<>(courseService.addOrUpdateCourse(course), HttpStatus.OK);
    }
}
