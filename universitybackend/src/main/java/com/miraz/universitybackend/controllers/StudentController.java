package com.miraz.universitybackend.controllers;

import com.miraz.universitybackend.models.Student;
import com.miraz.universitybackend.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService service;

    //creating api for add a student to the database
    @PostMapping("/add")
    public ResponseEntity<Student> addOrUpdateStudent(@RequestBody Student student){
        return new ResponseEntity<>(service.addOrUpdateStudent(student), HttpStatus.OK);
    }

    // creating api for find all the students
    @GetMapping("/find/all")
    public ResponseEntity<List<Student>> getAllStudents(){
        return  new ResponseEntity<>(service.getAllStudents(), HttpStatus.OK);
    }

    // creating api for delete a student
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Optional<Student>> deleteStudent(@PathVariable("id") int id){
        return new ResponseEntity<>(service.deleteStudent(id), HttpStatus.OK);
    }

    //creating api for update a student
    @PutMapping("/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student){
        return new ResponseEntity<>(service.addOrUpdateStudent(student), HttpStatus.OK);
    }

    //creating api for find a student by their id
    @GetMapping("/find/id/{id}")
    public ResponseEntity<Optional<Student>> findById(@PathVariable("id") int id){
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    // creating api for finding student with their name
    @GetMapping("find/name/{name}")
    public ResponseEntity<List<Optional<Student>>> findByName(@PathVariable("name") String name){
        return new ResponseEntity<>(service.findByName(name), HttpStatus.OK);
    }

}
