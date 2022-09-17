package com.miraz.universitybackend.services;

import com.miraz.universitybackend.models.Student;
import com.miraz.universitybackend.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component

public class StudentService {

    @Autowired
    private StudentRepo repo;

    //add or update student info
    public Student addOrUpdateStudent(Student student){
        repo.save(student);
        return student;
    }

    // return all the student of the database
    public List<Student> getAllStudents(){
        return  repo.findAll();
    }

    // delete a student from the database
    public Optional<Student> deleteStudent(int id){
        Optional<Student> student = repo.findById(id);
        repo.deleteById(id);
        return student;
    }

    //find a student with their assign id
    public Optional<Student> findById(int id){
        return repo.findById(id);
    }

    // find a student with their name
    public List<Optional<Student>> findByName(String name){
        return repo.findByFirstNameStartingWithIgnoreCase(name);
    }
}
