package com.mindwise.backend.Jwtutils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class AuthController {
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtils tokenManager;
    @PostMapping("/signin")
    public ResponseEntity createToken(@RequestBody JwtRequestModel jwtrequest) throws Exception {
       // try {
//            authenticationManager.authenticate(
//                    new
//                            UsernamePasswordAuthenticationToken(username,
//                            password)
//            );
//        } catch (DisabledException e) {
//            throw new Exception("USER_DISABLED", e);
//        } catch (BadCredentialsException e) {
//            throw new Exception("INVALID_CREDENTIALS", e);
//        }
        final UserDetails userDetails = userDetailsService.loadDoctorByUsername(jwtrequest.getUsername(), jwtrequest.getPassword());
//        System.out.println("dvdfdvvfd");

        final String jwtToken = tokenManager.generateJwtToken(userDetails);
//        System.out.println("dvdfdvvfd1");
        return ResponseEntity.ok(new JwtResponseModel(jwtToken));
    }
}