package com.example.springdataintro.Repository;

import com.example.springdataintro.Model.Entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {


}
