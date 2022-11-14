package com.example.demo.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "Please, enter valid name")
    @Size(min = 2, max = 30, message = "No more 30 symbols")
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "Please, enter valid surname")
    @Size(min = 2, max = 50, message = "No more 30 symbols")
    @Column(name = "surname")
    private String surname;
    @Column(name = "email")
    @NotEmpty(message = "Email should be not empty")
    @Email(message = "Email should be valid")
    private String email;
    @Min(value = 1, message = "Enter correct age")
    @Column(name = "age")
    private int age;

    public User() {
    }

    public User(String name, String surname, String email, int age) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}