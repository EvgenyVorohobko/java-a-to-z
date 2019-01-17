package by.vorokhobko.arrays;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @version 1.
 * @since 17.01.2019.
 */
public class SquareTest {
    /**
     * The class field.
     */
    private Square square = new Square();
    /**
     * @Test.
     */
    @Test
    public void whenBound3Then149() {
        int bound = 3;
        int[] rst = square.calculate(bound);
        int[] expect = new int[] {1, 4, 9};
        assertThat(rst, is(expect));
    }
    /**
     * @Test.
     */
    @Test
    public void whenBound5Then1491625() {
        int bound = 5;
        int[] rst = square.calculate(bound);
        int[] expect = new int[] {1, 4, 9, 16, 25};
        assertThat(rst, is(expect));
    }
    /**
     * @Test.
     */
    @Test(expected = NegativeArraySizeException.class)
    public void whenBoundMOneThenCatchTheBug() {
        int bound = -1;
        int[] rst = square.calculate(bound);
    }
}