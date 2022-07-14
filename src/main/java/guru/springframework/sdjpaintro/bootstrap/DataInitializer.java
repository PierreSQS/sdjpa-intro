package guru.springframework.sdjpaintro.bootstrap;

import guru.springframework.sdjpaintro.domain.Book;
import guru.springframework.sdjpaintro.repositories.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * modified by Pierrot on 11/26/2021.
 */
@Slf4j
@Profile({"local","default"})
@Component
public class DataInitializer implements CommandLineRunner {

    private final BookRepository bookRepository;

    public DataInitializer(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) {
        log.info("################ Cleaning the Books Data ################");
        bookRepository.deleteAll();

        Book bookDDD = new Book("Domain Driven Design", "123", "RandomHouse",null);

        log.info("Id: " + bookDDD.getId() );

        Book savedDDD = bookRepository.save(bookDDD);

        log.info("Id: " + savedDDD.getId() );

        Book bookSIA = new Book("Spring In Action", "234234", "Oreilly",null);
        bookRepository.save(bookSIA);

        bookRepository.findAll().forEach(book -> {
            log.info("Book Id: " + book.getId());
            log.info("Book Title: " + book.getTitle());
        });

    }
}
