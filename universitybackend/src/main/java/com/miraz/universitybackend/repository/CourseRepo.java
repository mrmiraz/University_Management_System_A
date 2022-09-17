package com.miraz.universitybackend.repository;

import com.miraz.universitybackend.models.Course;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;
//Course Crud repository
public interface CourseRepo extends MongoRepository<Course, String> {
    public List<Optional<Course>> findByCodeStartingWithIgnoreCase(String code);
}
