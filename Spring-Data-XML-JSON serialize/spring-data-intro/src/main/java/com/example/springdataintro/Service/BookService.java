package com.example.springdataintro.Service;

import java.io.IOException;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;

    void findAllBooksByTheirYear(int year);

    void findAllAuthorsByTheReleaseDate(int year);


    List<String> printAllBooksByAuthorName(String firstName, String lastName);
}
