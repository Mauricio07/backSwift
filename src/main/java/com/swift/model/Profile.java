package com.swift.model;


import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;

    private Boolean newRegister;
    private Boolean search;
    private Boolean edit;
    private Boolean delete;
    private Boolean enable;

    public Profile withName(String name) {
         this.name = name;
         return this;
    }

    public Profile withNewRegister(Boolean newRegister) {
        this.newRegister = newRegister;
        return this;
    }

    public Profile withSearch(Boolean search) {
        this.search = search;
        return this;
    }

    public Profile withEdit(Boolean edit) {
        this.edit = edit;
        return this;
    }

    public Profile withDelete(Boolean delete) {
        this.delete = delete;
        return this;
    }

    public Profile withEnable(Boolean enable) {
        this.enable = enable;
        return this;
    }
}
