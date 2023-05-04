package com.mindwise.backend.Jwtutils;

import com.mindwise.backend.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

//import com.bezkoder.springjwt.models.User;
//import com.bezkoder.springjwt.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    LoginRepository userRepository;

    @Override
    @Transactional
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findByUsername(username)
//                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
//
//        return UserDetailsImpl.build(user);
//    }
    public UserDetails loadUserByUsername(String mobile) throws UsernameNotFoundException {
        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(2);
        authList.add(new SimpleGrantedAuthority("Patient"));
        authList.add(new SimpleGrantedAuthority("doctor"));
        authList.add(new SimpleGrantedAuthority("admin"));

        User userByName = new User(mobile, "manohar", authList);
        return new org.springframework.security.core.userdetails.User(userByName.getUsername(), userByName.getPassword(), userByName.getAuthorities());
    }
    public UserDetails loadDoctorByUsername(String username,String password) throws UsernameNotFoundException {
        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(2);
        authList.add(new SimpleGrantedAuthority("Patient"));
        authList.add(new SimpleGrantedAuthority("doctor"));
        authList.add(new SimpleGrantedAuthority("admin"));

        User userByName = new User(username, password, authList);
        return new org.springframework.security.core.userdetails.User(userByName.getUsername(), userByName.getPassword(), userByName.getAuthorities());
    }

}