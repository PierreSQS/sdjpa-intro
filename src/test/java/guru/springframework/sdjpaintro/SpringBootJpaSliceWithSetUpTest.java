package guru.springframework.sdjpaintro;

import guru.springframework.sdjpaintro.domain.Book;
import guru.springframework.sdjpaintro.repositories.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;


/**
 *  Created by Pierrot on 11/24/2021
 */
@DataJpaTest
class SpringBootJpaSliceWithSetUpTest {

    @Autowired
    BookRepository bookRepository;

    @BeforeEach
    void setUp() {
        bookRepository.save(new Book("Mon Livre","75757ad-3t","Mon édition"));
    }

    @Test
    void testBookRepository() {
        long countBefore = bookRepository.count();

        // will fail since 1 Book saved in Setup()
        // assertThat(countBefore).isZero();
        assertThat(countBefore).isEqualTo(1);

        bookRepository.save(new Book("Mon livre","123456","Mes editions"));

        long countAfter = bookRepository.count();

        // now 2 Book since 1 Book saved in SetUp()
        assertThat(countAfter).isEqualTo(2L);
    }
}
