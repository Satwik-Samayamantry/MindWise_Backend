package com.mindwise.backend.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Admin {

    public Long getAdminID() {
        return adminID;
    }

    public void setAdminID(Long adminID) {
        this.adminID = adminID;
    }

    @Id
    @GeneratedValue
    private Long adminID;
    private String name;

    private String username;
    private Integer status;

    public Admin() {
    }

    public Admin(String name, String username, Integer status) {
        this.name = name;
        this.username = username;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
