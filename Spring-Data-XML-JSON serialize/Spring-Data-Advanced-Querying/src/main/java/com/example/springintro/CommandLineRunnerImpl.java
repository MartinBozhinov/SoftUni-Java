package com.example.springintro;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.service.AuthorService;
import com.example.springintro.service.BookService;
import com.example.springintro.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;
    private final BufferedReader bufferedReader;

    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService, BufferedReader bufferedReader) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
        this.bufferedReader = bufferedReader;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();

        //printAllBooksAfterYear(2000);
//        printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(1990);
        //   printAllAuthorsAndNumberOfTheirBooks();
        //pritnALlBooksByAuthorNameOrderByReleaseDate("George", "Powell");

        System.out.println("Enter exercise number:");
        int exNum = Integer.parseInt(bufferedReader.readLine());
        switch (exNum) {
            case 1 -> findAllBooksTitlesByAgeRestriction();
            case 2 -> findAllBooksTitlesByGoldEditionAndHaveLessThan5000();
            case 3 -> booksByPrice();
            case 4 -> notReleasedBooks();
            case 5 -> booksReleasedBeforeDate();
            case 6 -> authorsSearch();
            case 7 -> bookSearch();
            case 8 -> bookTitlesSearch();
            case 9 -> countBooks();
            case 10 -> totalBookCopies();
            case 11 -> reducedBook();

        }

    }

    private void reducedBook() throws IOException {
        System.out.println("Please enter desired title:");
        String title = bufferedReader.readLine();
        bookService.findBookByGivenTitle(title).forEach(System.out::println);
    }

    private void totalBookCopies() {
        System.out.println("Total Book Copies:");
        authorService.findAllAuthorsAndTheirCopies().forEach(System.out::println);
    }

    private void countBooks() throws IOException {
        System.out.println("Please enter desired number to compare if the title is longer:");
        int num = Integer.parseInt(bufferedReader.readLine());
        System.out.println(bookService.findAllBookTitlesLongerThanNum(num));


    }

    private void bookTitlesSearch() throws IOException {
        System.out.println("Please enter string for author last name:");
        String str = bufferedReader.readLine();
        bookService.findAllBookTitlesAndAuthorByGivenString(str)
                .forEach(System.out::println);

    }

    private void bookSearch() throws IOException {
        System.out.println("Enter desired string: ");
        String str = bufferedReader.readLine();
        bookService.findAllBooksTitlesWhichContainGivenString(str)
                .forEach(System.out::println);
    }

    private void authorsSearch() throws IOException {
        System.out.println("Enter desired string: ");
        String str = bufferedReader.readLine();

        authorService.findAllAuthorsNamesWhosNameEndWithGivenString(str)
                .forEach(System.out::println);


    }

    private void booksReleasedBeforeDate() throws IOException {
        System.out.println("Enter desired date in format : dd-MM-yyyy");
        LocalDate localDate = LocalDate.parse(bufferedReader.readLine(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        bookService.findAllTitlesEditionTypesAndPricesReleasedBeforeDate(localDate)
                .forEach(System.out::println);


    }

    private void notReleasedBooks() throws IOException {
        System.out.print("Please enter desired year:");
        int year = Integer.parseInt(bufferedReader.readLine());


        bookService.findAllBookTitlesNotReleasedIn(year).forEach(System.out::println);

    }

    private void booksByPrice() {
        bookService.findAllBookTitlesByPriceLowerThan4OrGreaterThan40().forEach(System.out::println);
    }


    private void findAllBooksTitlesByGoldEditionAndHaveLessThan5000() {
        bookService.findAllfindAllBooksTitlesByGoldEditionAndHaveLessThan()
                .forEach(System.out::println);

    }

    private void findAllBooksTitlesByAgeRestriction() throws IOException {
        System.out.print("Enter desired age restriction:");
        AgeRestriction ageRestriction = AgeRestriction.valueOf(bufferedReader.readLine().toUpperCase());
        bookService.findAllBooksByAgeRestriction(ageRestriction).forEach(System.out::println);

    }

    private void pritnALlBooksByAuthorNameOrderByReleaseDate(String firstName, String lastName) {
        bookService
                .findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(firstName, lastName)
                .forEach(System.out::println);
    }

    private void printAllAuthorsAndNumberOfTheirBooks() {
        authorService
                .getAllAuthorsOrderByCountOfTheirBooks()
                .forEach(System.out::println);
    }

    private void printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(int year) {
        bookService
                .findAllAuthorsWithBooksWithReleaseDateBeforeYear(year)
                .forEach(System.out::println);
    }

    private void printAllBooksAfterYear(int year) {
        bookService
                .findAllBooksAfterYear(year)
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);
    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();
    }
}
