package com.example.springdataintro.Service;

import com.example.springdataintro.Model.Entities.Author;

import java.io.IOException;
import java.util.List;

public interface AuthorService {


    void seedAuthors() throws IOException;

    Author getRandomAuthor();

    List<String> findAllAuthorsByCountOfBooks();

}
