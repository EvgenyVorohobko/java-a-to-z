package by.vorokhobko.Control_questions;

import by.vorokhobko.Control_questions.Start.StartUI;
import org.junit.Test;
import java.io.File;

/**
 * Test.
 *
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @version 1.
 * @since 06.08.2017.
 */
public class StartUITest {
    /**
     * The class field.
     */
    private File file = new File("d:/WORK/Projects/orders.xml");
    /**
     * The class field.
     */
    private StartUI start = new StartUI();
    /**
     * Test.
     */
    @Test
    public void whenOutputElementForFirstOrderBook() {
        start.runApplicationForFirstBook(file);
        start.whenOutputElementForPriceAndVolume();
    }
}