package com.example.demoprog3.logic;

import java.time.LocalDate;

public class Student {
    private Integer id;

    private String name;

    private Character gender;

    private String city;

    private LocalDate birthday;

    public Student(Integer id, String name, Character gender, String city, LocalDate birthday) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.city = city;
        this.birthday = birthday;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", city='" + city + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
