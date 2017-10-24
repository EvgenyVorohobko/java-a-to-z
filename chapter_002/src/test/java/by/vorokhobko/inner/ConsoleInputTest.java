package by.vorokhobko.inner;

import org.junit.Test;
import java.io.ByteArrayInputStream;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Test.
 *
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @version 1.
 * @since 19.04.2017.
 */
public class ConsoleInputTest {
    /**
     * Test.
     */
    @Test
    public void whenTheUserEstablishesContactWithTheProgram() {
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);
        String result = "1";
        String test = new ConsoleInput().ask("test ");
        assertThat(result, is(test));
    }
}