package guru.springframework.sdjpaintro;

import guru.springframework.sdjpaintro.domain.Book;
import guru.springframework.sdjpaintro.repositories.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;


/**
 *  Created by Pierrot on 11/24/2021
 */
@DataJpaTest
class SpringBootJpaTestSlice {

    @Autowired
    BookRepository bookRepository;

    @Test
    void testBookRepository() {
        long countBefore = bookRepository.count();

        bookRepository.save(new Book("Mon livre","123456","Mes editions"));

        long countAfter = bookRepository.count();

        assertThat(countAfter).isEqualTo(1L);
    }
}
