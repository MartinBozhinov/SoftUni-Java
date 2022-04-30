package com.example.xmlprocexe.service;

import com.example.xmlprocexe.model.dto.CategorySeedDto;
import com.example.xmlprocexe.model.entity.Categories;

import java.util.List;
import java.util.Set;

public interface CategoryService {


    void seedCategories(List<CategorySeedDto> categories);

    Set<Categories> getRandomCategories();

}
