package com.markmaster.backend.models;

import jakarta.persistence.*;

@Entity
@Table(name = "user_details")
public class User extends AbstractBaseEntity{
    @Column(unique = true, nullable = false)
    private String username;
    @Column(unique = false,nullable = false)
    private String password;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id") // Foreign key to reference the Course table
    private Course registeredCourse;
    public  User(){}
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
