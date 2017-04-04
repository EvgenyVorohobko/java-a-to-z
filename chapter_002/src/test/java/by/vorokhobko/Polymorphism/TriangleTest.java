package by.vorokhobko.Polymorphism;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * TriangleTest.
 *
 * Class TriangleTest for testing class Triangle part 005, lesson 2.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 04.04.2017.
 * @version 1.
 */

public class TriangleTest {
    /**
     * Test.
     * The method draws a triangle in pseudographics.
     */
    @Test
    public void drawingOfTheTriangle() {
        final int h = 3;
        final Shape triangle = new Triangle(h);
        String outPrint = "  ^ "
                + System.getProperty("line.separator") + "  ^ ^ "
                + System.getProperty("line.separator") + "  ^ ^ ^ "
                + System.getProperty("line.separator");
        String result = triangle.pic(triangle);
        assertThat(result, is(outPrint));
    }
}