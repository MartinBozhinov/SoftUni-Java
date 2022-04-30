package com.example.springdataintro.Repository;

import com.example.springdataintro.Model.Entities.Book;
import net.bytebuddy.asm.Advice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {

    List<Book> findAllByReleaseDateAfter(LocalDate releaseDateAfter);

    List<Book> findAllByReleaseDateBefore(LocalDate releaseDateBefore);

    List<Book> findBookByAuthor_FirstName_AndAuthor_LastName_OrderByReleaseDateDescTitleAsc(String firstName,String lastName);
}
