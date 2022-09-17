package com.miraz.universitybackend.repository;

import com.miraz.universitybackend.models.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;
//Student Crud repository
public interface StudentRepo extends MongoRepository<Student, Integer> {
//    List<Optional<Student>> findByName(String name);
    List<Optional<Student>> findByFirstNameStartingWithIgnoreCase(String firstName);
}
