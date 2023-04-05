package com.mindwise.backend.Jwtutils;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

//import jakarta.validation.Valid;

import com.mindwise.backend.model.LoginDetails;
import com.mindwise.backend.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    //@PostMapping("/validate")
    public ResponseEntity<?> authenticateUser(@RequestBody Map<String, String> logindetails) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(logindetails.get("Username"), logindetails.get("Password")));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

//        UserDetailsServiceImpl userDetails = (UserDetailsServiceImpl) authentication.getPrincipal();
//        List<String> roles = userDetails.getAuthorities().stream()
//                .map(item -> item.getAuthority())
//                .collect(Collectors.toList());

//        return ResponseEntity.ok(new JwtResponse(jwt,
////                userDetails.getId(),
//                userDetails.getUsername(),
//                userDetails.getEmail(),
//                roles));
        return ResponseEntity.ok(new JwtResponseModel(jwt));

        //try
//            {
////            System.out.println(logindetails);
//                String username = logindetails.get("username");
//                String role = logindetails.get("role");
//                String password = logindetails.get("password");

//            System.out.println(username);
//            System.out.println(role);
//            System.out.println(password);
//                LoginDetails l = loginRepository.getPasswordByUsername(username,role);
//                if(l != null)
//                {
//                    if(l.getPassword().equals(password))
//                    {
//                        return new ResponseEntity<Boolean>(true, HttpStatus.OK) ;
//                    }
//                    else
//                        return new ResponseEntity<Boolean>(false, HttpStatus.OK) ;
//                }
//                return new ResponseEntity<Boolean>(false, HttpStatus.OK) ;
//
//
//            }
//            catch(Exception e)
//            {
//                e.printStackTrace();
//            }
//            return new ResponseEntity<Boolean>(false, HttpStatus.INTERNAL_SERVER_ERROR) ;
//        }

    }
}