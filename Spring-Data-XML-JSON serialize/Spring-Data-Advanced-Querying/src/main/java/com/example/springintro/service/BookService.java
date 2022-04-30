package com.example.springintro.service;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;

    List<Book> findAllBooksAfterYear(int year);

    List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year);

    List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName);

    List<String> findAllBooksByAgeRestriction(AgeRestriction ageRestriction);

    List<String> findAllfindAllBooksTitlesByGoldEditionAndHaveLessThan();

    List<String> findAllBookTitlesByPriceLowerThan4OrGreaterThan40();

    List<String> findAllBookTitlesNotReleasedIn(int year);

    List<String> findAllTitlesEditionTypesAndPricesReleasedBeforeDate(LocalDate localDate);

    List<String> findAllBooksTitlesWhichContainGivenString(String str);

    List<String> findAllBookTitlesAndAuthorByGivenString(String str);


    int findAllBookTitlesLongerThanNum(int num);


    List<String> findBookByGivenTitle(String title);
}
