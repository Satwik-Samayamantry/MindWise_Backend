package com.mindwise.backend.model;

import jakarta.persistence.*;

@Entity
public class Exercises {
    public Long getExerciseID(){
        return exerciseID;
    }

    public void setExerciseID(Long exerciseID){
        this.exerciseID = exerciseID;
    }

    @Id
    @GeneratedValue
    private Long exerciseID;
    private Integer defaultflag;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    private String description;
    private String type;
    private String ans;

    public Exercises() {
    }

    public Exercises(Integer defaultflag, String description, String type, String ans, String name){
        this.defaultflag = defaultflag;
        this.description = description;
        this.type = type;
        this.ans = ans;
        this.name = name;
    }

    public Integer getDefaultflag() {
        return defaultflag;
    }

    public void setDefaultflag(Integer defaultflag) {
        this.defaultflag = defaultflag;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }
}
