package com.mindwise.backend.repository;

import com.mindwise.backend.model.LoginDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LoginRepository extends JpaRepository<LoginDetails, String> {
//    @Query(value = "SELECT * from login_details l where l.username = :username and l.role = :role" , nativeQuery = true)
//    LoginDetails getAllByUsernameAndRole(@Param("username") String username, @Param("role") String role);

    LoginDetails getAllByUsernameAndRole(String username,String role);
//    @Modifying
//    @Query(value = "UPDATE login_details l SET l.password = :password WHERE l.username = :username and l.role = :role", nativeQuery = true)
//    void updatePassword(@Param("username") String username, @Param("role") String role, @Param("password") String password);

}
