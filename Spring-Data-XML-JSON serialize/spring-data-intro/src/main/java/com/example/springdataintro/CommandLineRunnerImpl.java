package com.example.springdataintro;

import com.example.springdataintro.Service.AuthorService;
import com.example.springdataintro.Service.BookService;
import com.example.springdataintro.Service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;

    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
         categoryService.seedCategories();
         authorService.seedAuthors();
         bookService.seedBooks();

         //findAllBooksByTheirYear(2000);
        //getAllAuthorsWithBookWithReleaseDateBefore(1990);
       // getAllAuthorsOrderedByNumberOfTheirBooks();
        printAllBooksByAuthorName("George", "Powell");


    }

    private void printAllBooksByAuthorName(String firstName,String lastName) {
        bookService.printAllBooksByAuthorName(firstName,lastName)
                .forEach(System.out::println);
    }

    private void getAllAuthorsOrderedByNumberOfTheirBooks() {
        authorService.findAllAuthorsByCountOfBooks().forEach(System.out::println);

    }

    private void getAllAuthorsWithBookWithReleaseDateBefore(int year) {
        bookService.findAllAuthorsByTheReleaseDate(year);

    }

    private void findAllBooksByTheirYear(int year) {
        bookService.findAllBooksByTheirYear(year);



    }
}
