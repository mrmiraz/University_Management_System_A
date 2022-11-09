package com.miraz.universitybackend.services;

import com.miraz.universitybackend.models.Course;
import com.miraz.universitybackend.models.Student;
import com.miraz.universitybackend.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CourseService {

    @Autowired
    private CourseRepo courseRepo;

    // add or update course in the database
    public Course addOrUpdateCourse(Course course){
        courseRepo.save(course);
        return course;
    }

    // return all the courses info
    public List<Course> getAllCourse(){
        return  courseRepo.findAll();
    }

    // delete a course from the database
    public Optional<Course> deleteCourse(String code){
        Optional<Course> course = courseRepo.findById(code);
        courseRepo.deleteById(code);
        return course;
    }

    //find a course from database with their assing course code
    public List<Optional<Course>> findByCode(String code){
        return courseRepo.findByCodeStartingWithIgnoreCase(code);
    }
}
