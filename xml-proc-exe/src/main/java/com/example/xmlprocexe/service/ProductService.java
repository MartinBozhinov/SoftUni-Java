package com.example.xmlprocexe.service;

import com.example.xmlprocexe.model.dto.ProductSeedDto;
import com.example.xmlprocexe.model.dto.ProductsInRangeRootDto;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    void seedProducts(List<ProductSeedDto> products);

    ProductsInRangeRootDto findAllWithPriceBetween(BigDecimal lower, BigDecimal upper);
}
