package com.swift.model;

import com.swift.services.enums.UserType;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class Users implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, length = 100)
    private String lastname;

    @Column(nullable = false, length = 10)
    private Boolean active;

    @Column(nullable = false, length = 100)
    private  String password;

    @Column(nullable = false, length = 150)
    private String email;

    @Column(nullable = false, length = 200)
    private String address;

    @Column(nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private UserType userType;

    @Column(nullable = false, length = 100)
    private String uid;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profiles;

    public Users(){}

    public Users withId(Long id) {
        this.id = id;
        return this;
    }

    public Users withName(String name) {
        this.name = name;
        return this;
    }

    public Users withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public Users withActive(Boolean active) {
        this.active = active;
        return this;
    }

    public Users withPassword(String password) {
        this.password = password;
        return this;
    }

    public Users withEmail(String email) {
        this.email = email;
        return this;
    }

    public Users withAddress(String address) {
        this.address = address;
        return this;
    }


    public Users withUid(String uid){
        this.uid = uid;
        return this;
    }

    public Users withProfile_id(Integer profile_id) {

        this.profiles = profiles;
        return this;
    }


}
