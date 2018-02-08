package com.hussein.samples.dockerizefactor8.model;

import javax.persistence.*;

@Entity
@Table(name="xuser")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Column(name = "userName", nullable = false)
    private String userName;

    public User() {
    }

    public User(String name) {
        this.userName = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getId() {
        return id;
    }
}
