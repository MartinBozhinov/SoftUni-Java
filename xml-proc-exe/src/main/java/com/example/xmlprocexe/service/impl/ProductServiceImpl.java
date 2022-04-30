package com.example.xmlprocexe.service.impl;

import com.example.xmlprocexe.model.dto.ProductSeedDto;
import com.example.xmlprocexe.model.dto.ProductsInRangeDto;
import com.example.xmlprocexe.model.dto.ProductsInRangeRootDto;
import com.example.xmlprocexe.model.entity.Products;
import com.example.xmlprocexe.repository.ProductRepository;
import com.example.xmlprocexe.service.CategoryService;
import com.example.xmlprocexe.service.ProductService;
import com.example.xmlprocexe.service.UserService;
import com.example.xmlprocexe.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final UserService userService;
    private final CategoryService categoryService;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, ValidationUtil validationUtil, UserService userService, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public void seedProducts(List<ProductSeedDto> products) {
        if (productRepository.count() == 0) {
            products.stream()
                    .filter(validationUtil::isValid)
                    .map(productSeedDto -> {
                        Products product = modelMapper.map(productSeedDto, Products.class);
                        product.setSeller(userService.getRandomUser());
                        if (product.getPrice().compareTo(BigDecimal.valueOf(700L)) > 0) {
                            product.setBuyer(userService.getRandomUser());
                        }
                        product.setCategories(categoryService.getRandomCategories());
                        return product;
                    })
                    .forEach(productRepository::save);
        }
    }

    @Override
    public ProductsInRangeRootDto findAllWithPriceBetween(BigDecimal lower, BigDecimal upper) {
       ProductsInRangeRootDto productsInRangeRootDto = new ProductsInRangeRootDto();

          productsInRangeRootDto.
                  setProducts(productRepository.findAllByPriceBetweenAndBuyerIsNull(lower,upper)
                          .stream().map(products -> modelMapper.map(products, ProductsInRangeDto.class))
                          .collect(Collectors.toList()));

        return  productsInRangeRootDto;
    }
}
