package com.miraz.universitybackend.services;

import com.miraz.universitybackend.models.Admin;
import com.miraz.universitybackend.models.Student;
import com.miraz.universitybackend.repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Component
public class AdminService {
    @Autowired
    private AdminRepo adminRepo;

    //add an admin to the database
    public Admin addOrUpdateAdmin(Admin admin){
        return adminRepo.save(admin);
    }

    // return all the admins info
    public List<Admin> findAll(){
        return adminRepo.findAll();
    }

    // admin find by their assign username starting letter observation
    public List<Optional<Admin>> findByUsername(String userName){
        return adminRepo.findByUserNameStartingWithIgnoreCase(userName);
    }

    //delete a admin from the database
    public Optional<Admin> delete(String userName){
        Optional<Admin> admin = adminRepo.findById(userName);
        adminRepo.deleteById(userName);
        return  admin;
    }

    // find by username full match
    public  Optional<Admin> findUser(String userName){
        return adminRepo.findById(userName);
    }


}
