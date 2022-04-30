package com.example.springdataintro.Service;

import com.example.springdataintro.Model.Entities.Author;
import com.example.springdataintro.Repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {
    private static final String AUTHORS_PATH = "src/main/resources/files/authors.txt";
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<String> findAllAuthorsByCountOfBooks() {
        return authorRepository.findAllByBooksBySizeDESC()
                .stream()
                .map(author -> String.format("%s %s %d",
                        author.getFirstName()
                        , author.getLastName()
                        , author.getBooks().size())).
                collect(Collectors.toList());
    }

    @Override
    public void seedAuthors() throws IOException {
        if (authorRepository.count() > 0) {
            return;
        }
        Files.readAllLines(Path.of(AUTHORS_PATH))
                .stream()
                .forEach(row -> {
                    String[] fullName = row.split("\\s+");
                    Author author = new Author(fullName[0], fullName[1]);
                    authorRepository.save(author);
                });
    }

    @Override
    public Author getRandomAuthor() {
        long randomId = ThreadLocalRandom.current().nextLong(1, authorRepository.count() + 1);
        return authorRepository.findById(randomId).orElse(null);

    }
}
