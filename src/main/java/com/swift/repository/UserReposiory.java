package com.swift.repository;

import com.swift.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserReposiory extends JpaRepository<Users, Long> {
}
