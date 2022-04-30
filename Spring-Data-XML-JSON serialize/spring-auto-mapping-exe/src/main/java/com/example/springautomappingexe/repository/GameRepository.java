package com.example.springautomappingexe.repository;

import com.example.springautomappingexe.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game,Long> {


}
