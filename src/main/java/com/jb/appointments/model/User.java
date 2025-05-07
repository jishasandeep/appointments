package com.jb.appointments.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    private int age;
    private String role;
    public User(){}
    public User(String name, int age,String role){
        this.name = name;
        this.age = age;
        this.role = role;
    }
}

