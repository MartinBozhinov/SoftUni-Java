package com.example.springdataintro.Service;

import com.example.springdataintro.Model.Entities.*;
import com.example.springdataintro.Repository.BookRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService{
         private static final String BOOK_PATH = "src/main/resources/files/books.txt";
         private final BookRepository bookRepository;
         private final AuthorService authorService;
         private final CategoryService categoryService;

    public BookServiceImpl(BookRepository bookRepository,  AuthorService authorService, CategoryService categoryService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }


    @Override
    public void seedBooks() throws IOException {
        if (bookRepository.count() > 0){
            return;
        }
        Files.readAllLines(Path.of(BOOK_PATH))
                .stream()
                .forEach(row -> {
                    String[] bookInfo = row.split("\\s+");

                    Book book = createBookFromBookInfo(bookInfo);
                    bookRepository.save(book);
                });


    }

    @Override
    public void findAllBooksByTheirYear(int year) {
            bookRepository.findAllByReleaseDateAfter(LocalDate.of(year,1,31))
                    .stream()
                    .forEach(book -> {
                        System.out.printf("%s%n", book.getTitle());
                    });

    }

    @Override
    public void findAllAuthorsByTheReleaseDate(int year) {
     bookRepository.findAllByReleaseDateBefore(LocalDate.of(year,1,1))
             .stream()
             .forEach(book -> {
                 System.out.printf("%s %s%n", book.getAuthor().getFirstName(),book.getAuthor().getLastName());
             });



    }

    @Override
    public List<String> printAllBooksByAuthorName(String firstName, String lastName) {
           return bookRepository.findBookByAuthor_FirstName_AndAuthor_LastName_OrderByReleaseDateDescTitleAsc(firstName,lastName)
                    .stream()
                    .map(book -> String.format("%s %s %d",
                            book.getTitle(),
                            book.getReleaseDate(),
                            book.getCopies())).collect(Collectors.toList());


    }

    private Book createBookFromBookInfo(String[] bookInfo) {
        EditionType editionType = EditionType.values()[Integer.parseInt(bookInfo[0])];
        LocalDate releaseDate = LocalDate.parse(bookInfo[1], DateTimeFormatter.ofPattern("d/M/yyyy"));
        Integer copies = Integer.parseInt(bookInfo[2]);
        BigDecimal price = new BigDecimal(bookInfo[3]);
        AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(bookInfo[4])];
        String name = Arrays.stream(bookInfo).skip(5).collect(Collectors.joining(" "));
        Author author = authorService.getRandomAuthor();
        Set<Category> categories = categoryService.getRandomCategories();
        Book book = new Book(editionType,releaseDate,copies,price,ageRestriction,name,author,categories);
        return book;
    }
}
