package com.example.springdataintro.Service;

import com.example.springdataintro.Model.Entities.Category;

import java.io.IOException;
import java.util.Set;

public interface CategoryService {
    void seedCategories() throws IOException;

    Set<Category> getRandomCategories();

}
