package com.example.xmlprocexe;

import com.example.xmlprocexe.model.dto.CategorySeedRootDto;
import com.example.xmlprocexe.model.dto.ProductSeedRootDto;
import com.example.xmlprocexe.model.dto.ProductsInRangeRootDto;
import com.example.xmlprocexe.model.dto.UserSeedRootDto;
import com.example.xmlprocexe.service.CategoryService;
import com.example.xmlprocexe.service.ProductService;
import com.example.xmlprocexe.service.UserService;
import com.example.xmlprocexe.util.ValidationUtil;
import com.example.xmlprocexe.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    private static final String FILE_RESOURCE_PATH = "src/main/resources/files/";
    private static final String CATEGORIES_PATH = "categories.xml";
    private static final String USERS_PATH = "users.xml";
    private static final String PRODUCTS_PATH = "products.xml";
    private static final String FILE_OUT_PATH = "src/main/resources/files/out/";
    private static final String PRODUCTS_IN_RANGE_PATH = "products-in-range.xml";

    private final ProductService productService;
    private final UserService userService;
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;
    private final BufferedReader bufferedReader;


    public CommandLineRunnerImpl(ProductService productService, UserService userService, CategoryService categoryService, ModelMapper modelMapper, ValidationUtil validationUtil, XmlParser xmlParser) {
        this.productService = productService;
        this.userService = userService;
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }


    @Override
    public void run(String... args) throws Exception {
       seedData();
        System.out.println("Enter exercise number");
        int exNum = Integer.parseInt(bufferedReader.readLine());
        switch (exNum){
            case 1 -> productsInRange();
        }

    }

    private void productsInRange() throws JAXBException {
        ProductsInRangeRootDto productsInRangeRootDto =
                productService.findAllWithPriceBetween(BigDecimal.valueOf(500L), BigDecimal.valueOf(1000L));

         xmlParser.writeToFile(FILE_OUT_PATH+PRODUCTS_IN_RANGE_PATH, ProductSeedRootDto.class);




    }

    private void seedData() throws JAXBException, FileNotFoundException {
        CategorySeedRootDto categorySeedRootDto
                = xmlParser.fromFile(FILE_RESOURCE_PATH + CATEGORIES_PATH, CategorySeedRootDto.class);

         categoryService.seedCategories(categorySeedRootDto.getCategories());


        UserSeedRootDto userSeedRootDto
                = xmlParser.fromFile(FILE_RESOURCE_PATH + USERS_PATH, UserSeedRootDto.class);

        userService.seedUsers(userSeedRootDto.getUsers());

        ProductSeedRootDto productSeedRootDto
                = xmlParser.fromFile(FILE_RESOURCE_PATH + PRODUCTS_PATH, ProductSeedRootDto.class);

        productService.seedProducts(productSeedRootDto.getProducts());


    }
}
