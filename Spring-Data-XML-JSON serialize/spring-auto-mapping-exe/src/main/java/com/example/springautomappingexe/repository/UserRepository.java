package com.example.springautomappingexe.repository;

import com.example.springautomappingexe.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findAllByEmailAndPassword(String email, String password);
}
