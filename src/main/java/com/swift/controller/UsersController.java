package com.swift.controller;

import com.swift.model.Users;
import com.swift.repository.UserReposiory;
import com.swift.services.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UsersController {

    @Autowired
    private UserReposiory userReposiory;

    //    Get all users
    @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
    public List<Users> getAll() {
        return userReposiory.findAll();
    }

    //  User update
    @PutMapping("/getUsers/{id}")
    public ResponseEntity<Users> updateProfile(@PathVariable Long id, @RequestBody Users users) {
        Users modelUsers = userReposiory.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("El perfil con el id " + " no existe"));

//        Users update = userReposiory.save(modelUsers.withName(users.getName())
//                .withLastname(users.getLastname())
//                .withUserType(users.getUserType()));

//        return ResponseEntity.ok(update);
        return null;
    }

}
