package com.example.tp2.repository;

import java.util.Optional;

import com.example.tp2.modele.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, String> {
    Optional<Users> findUserByUsername(String username);
}