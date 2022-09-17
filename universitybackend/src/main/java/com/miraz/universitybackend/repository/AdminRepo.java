package com.miraz.universitybackend.repository;

import com.miraz.universitybackend.models.Admin;
import com.miraz.universitybackend.models.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;
//Admin Crud repository
public interface AdminRepo extends MongoRepository<Admin, String> {
    List<Optional<Admin>> findByUserNameStartingWithIgnoreCase(String name);
}
