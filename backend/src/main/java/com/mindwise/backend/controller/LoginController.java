package com.mindwise.backend.controller;

import com.mindwise.backend.model.LoginDetails;
import com.mindwise.backend.model.Patient;
import com.mindwise.backend.repository.LoginRepository;
import com.mindwise.backend.repository.PatientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;
import java.util.Objects;
//import com.mindwise.backend.utils.JwtUtils;

@RestController
@CrossOrigin(origins = "*")
public class LoginController {

    @Autowired
    private LoginRepository loginRepository;
    @Autowired
    private PatientRepository patientRepository;

    @PostMapping("/login")
    LoginDetails newLogin(@RequestBody LoginDetails newLogin)
    {
        return loginRepository.save(newLogin);
    }

    @GetMapping("/logins")
    List<LoginDetails> getAllUsers()
    {
        return loginRepository.findAll();
    }

    @PostMapping("/validate")
    ResponseEntity<Boolean> validateLogin(@RequestBody(required = true) Map<String,String> logindetails)
    {
        Patient failed = null;

        try
        {
//            System.out.println(logindetails);
            String username = logindetails.get("username");
            String role = logindetails.get("role");
            String password = logindetails.get("password");

            System.out.println(username);
            System.out.println(role);
            System.out.println(password);
            LoginDetails l = loginRepository.getAllByUsernameAndRole(username,role);
//            System.out.println(Objects.isNull(l));
            Patient pid = patientRepository.getIdByUsername(username);
//            System.out.println(pid);

            if(!Objects.isNull(l))
            {
//                System.out.println(l.getPassword());
                if(l.getPassword().equals(password))
                {
                    return new ResponseEntity<Boolean>(true, HttpStatus.OK) ;
                }
                else {
                    return new ResponseEntity<Boolean>(false, HttpStatus.OK);
                }
            }
            return new ResponseEntity<Boolean>(false, HttpStatus.OK) ;


        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return new ResponseEntity<Boolean>(false, HttpStatus.INTERNAL_SERVER_ERROR) ;
    }



    @PostMapping("/updatePassword")
    @Transactional
    ResponseEntity<Boolean> updatePassword(@RequestBody(required = true) Map<String,String> logindetails )
    {

        try
        {
//            System.out.println(logindetails);
            String username = logindetails.get("username");
            String role = logindetails.get("role");
            String oldpassword = logindetails.get("oldpassword");
            String newpassword = logindetails.get("newpassword");


//            System.out.println(username);
//            System.out.println(oldpassword);
//            System.out.println(newpassword);
            LoginDetails l = loginRepository.getAllByUsernameAndRole(username,role);
            if(l != null)
            {
                if(l.getPassword().equals(oldpassword))
                {
//                    loginRepository.updatePassword(username,role,newpassword);
                    l.setPassword(newpassword);
                    loginRepository.save(l);
                    return new ResponseEntity<Boolean>(true, HttpStatus.OK) ;
                }
                else
                    return new ResponseEntity<Boolean>(false, HttpStatus.OK) ;
            }
            return new ResponseEntity<Boolean>(false, HttpStatus.OK) ;


        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return new ResponseEntity<Boolean>(false, HttpStatus.INTERNAL_SERVER_ERROR) ;
    }
}
