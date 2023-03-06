package com.woniuxy.entity;

import java.time.LocalDate;

public class Student {
    private int id;
    private int stuId;
    private String name;
    private String gender;
    private LocalDate birthdate;
    private Integer clazzId;

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public Integer getClazzId() {
        return clazzId;
    }

    public void setClazzId(Integer clazzId) {
        this.clazzId = clazzId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", stuId=" + stuId +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birthdate=" + birthdate +
                ", clazzId=" + clazzId +
                '}';
    }
}
