package guru.springframework.sdjpaintro;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

/**
 *  Modified by Pierrot on 11/23/2021
 */
@SpringBootTest
class SdjpaIntroApplicationTests {

    @Test
    void contextLoads(ApplicationContext appCtx) {
        assertThat(appCtx).isNotNull();
    }

}
