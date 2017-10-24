package by.vorokhobko.polymorphism;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * SquareTest.
 *
 * Class SquareTest for testing class Square part 005, lesson 2.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 04.04.2017.
 * @version 1.
 */

public class SquareTest {
    /**
     * Test.
     * The method draws a square in pseudographics.
     */
    @Test
    public void drawingOfTheSquare() {
        final int h = 5;
        final Shape square = new Square(h);
        String outPrint = "*****"
                + System.getProperty("line.separator") + "*   *"
                + System.getProperty("line.separator") + "*   *"
                + System.getProperty("line.separator") + "*   *"
                + System.getProperty("line.separator") + "*****"
                + System.getProperty("line.separator");
        String result = square.pic(square);
        assertThat(result, is(outPrint));
    }
}
