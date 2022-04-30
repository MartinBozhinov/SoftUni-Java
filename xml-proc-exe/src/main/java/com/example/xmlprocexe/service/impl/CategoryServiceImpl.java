package com.example.xmlprocexe.service.impl;

import com.example.xmlprocexe.model.dto.CategorySeedDto;
import com.example.xmlprocexe.model.entity.Categories;
import com.example.xmlprocexe.repository.CategoryRepository;
import com.example.xmlprocexe.service.CategoryService;
import com.example.xmlprocexe.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public void seedCategories(List<CategorySeedDto> categories) {
        if (categoryRepository.count() == 0) {
            categories.stream()
                    .filter(validationUtil::isValid)
                    .map(categorySeedDto -> modelMapper.map(categorySeedDto, Categories.class))
                    .forEach(categoryRepository::save);
        }

    }

    @Override
    public Set<Categories> getRandomCategories() {
        Set<Categories> categories = new HashSet<>();
        long catCount = categoryRepository.count();
        for (int i = 0; i < 2; i++) {
            long randomId = ThreadLocalRandom.current().nextLong(1, catCount);
            categories.add(categoryRepository.findById(randomId).orElse(null));
        }
        return categories;

    }
}
