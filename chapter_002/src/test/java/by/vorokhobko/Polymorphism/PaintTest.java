package by.vorokhobko.polymorphism;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * PaintTest.
 *
 * Class PaintTest for testing class Paint part 005, lesson 2.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 04.04.2017.
 * @version 1.
 */
public class PaintTest {
    /**
     * Test.
     * The method paint figure.
     */
    @Test
    public void whenDrawFiguresTriangle() {
        final int h = 3;
        Shape triangle = new Triangle(h);
        Paint paint = new Paint(triangle);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        paint.draw(triangle);
        final String result = out.toString();
        String outPrint = "  ^ "
                + System.getProperty("line.separator") + "  ^ ^ "
                + System.getProperty("line.separator") + "  ^ ^ ^ "
                + System.getProperty("line.separator");
        assertThat(result, is(outPrint));
    }
    /**
     * Test.
     * The method paint figure.
     */
    @Test
    public void whenDrawFiguresSquare() {
        final int h = 5;
        Shape square = new Square(h);
        Paint paint = new Paint(square);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        paint.draw(square);
        final String result = out.toString();
        String outPrint = "*****"
                + System.getProperty("line.separator") + "*   *"
                + System.getProperty("line.separator") + "*   *"
                + System.getProperty("line.separator") + "*   *"
                + System.getProperty("line.separator") + "*****"
                + System.getProperty("line.separator");
        assertThat(result, is(outPrint));
    }
}