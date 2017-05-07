package by.vorokhobko.AbstractClasses;

import org.junit.Test;
import java.io.ByteArrayInputStream;

/**
 * Test.
 *
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @version 1.
 * @since 19.04.2017.
 */
public class ConsoleInputTest {
    /**
     * Test Add.
     */
    @Test
    public void whenTheUserEstablishesContactWithTheProgram() {
        System.setIn(new ByteArrayInputStream("1".getBytes()));
        System.setIn(System.in);
        String result = "1";
    }
}