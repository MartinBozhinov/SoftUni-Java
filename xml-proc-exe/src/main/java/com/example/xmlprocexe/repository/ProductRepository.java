package com.example.xmlprocexe.repository;

import com.example.xmlprocexe.model.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Products,Long> {


      List<Products> findAllByPriceBetweenAndBuyerIsNull(BigDecimal lower, BigDecimal upper);

}
