package com.alexrsnchz.simplespringapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "The name cannot be null")
    @Size(min = 5, max = 20, message = "The name must be between 5 and 20")
    private String name;

    @NotNull(message = "The age cannot be null")
    @Min(value = 18, message = "The minimum age is 18")
    @Max(value = 120, message = "The maximum age is 120")
    private int age;

    @NotNull(message = "The gender cannot be null")
    private String gender;

    public User() {
    }

    public User(Long id, String name, int age, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
