package edu.labs.thymeleaf.models;

public class StudentModel {
    private Integer id;
    private String firstName;
    private String sureName;
    private Boolean isGraduated;
    private Integer mark;

    public StudentModel() {
    }

    public StudentModel(Integer id, String firstName, String sureName, Boolean isGraduated, Integer mark) {
        this.id = id;
        this.firstName = firstName;
        this.sureName = sureName;
        this.isGraduated = isGraduated;
        this.mark = mark;
    }

    // Getter and setter methods for id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    // Getter and setter methods for firstName
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Getter and setter methods for sureName
    public String getSureName() {
        return sureName;
    }

    public void setSureName(String sureName) {
        this.sureName = sureName;
    }

    // Getter and setter methods for isGraduated
    public Boolean getIsGraduated() {
        return isGraduated;
    }

    public void setIsGraduated(Boolean isGraduated) {
        this.isGraduated = isGraduated;
    }

    // Getter and setter methods for mark
    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }
}
