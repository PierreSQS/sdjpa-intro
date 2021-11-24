package guru.springframework.sdjpaintro.bootstrap;

import guru.springframework.sdjpaintro.domain.Book;
import guru.springframework.sdjpaintro.repositories.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *  Created by Pierrot on 11/23/2021
 */
@Slf4j
@Component
public class DataLoader implements CommandLineRunner {
    private final BookRepository bookRepo;

    public DataLoader(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public void run(String... args) {
        Book bookDDD = Book.builder()
                .title("Domain Driven Design")
                .isbn("123")
                .publisher("RandomHouse")
                .build();

        Book bookSIA = Book.builder()
                .title("Spring in Action")
                .isbn("345")
                .publisher("Oreilly")
                .build();

        List<Book> savedBook = bookRepo.saveAll(List.of(bookDDD, bookSIA));

        savedBook.forEach(book -> log.info("Saved Book: {}",book));

    }
}
