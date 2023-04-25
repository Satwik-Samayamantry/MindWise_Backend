package com.mindwise.backend.controller;

import com.mindwise.backend.model.Admin;
import com.mindwise.backend.model.Doctor;
import com.mindwise.backend.model.Patient;
import com.mindwise.backend.repository.AdminRepository;
import com.mindwise.backend.repository.DoctorRepository;
import com.mindwise.backend.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class AdminController {
    @Autowired
    private AdminRepository adminRepository;

    @PostMapping("/admin")
    Admin newAdmin(@RequestBody Admin newAdmin)
    {
        return adminRepository.save(newAdmin);
    }

    @GetMapping("/admins")
    List<Admin> getAllAdmins()
    {
        // return "Hello World";
        return adminRepository.findAll();
    }

}
