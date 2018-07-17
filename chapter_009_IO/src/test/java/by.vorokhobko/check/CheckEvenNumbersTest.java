package by.vorokhobko.check;

import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.util.InputMismatchException;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @version 1.
 * @since 17.07.2018.
 */
public class CheckEvenNumbersTest {
    /**
     * The class field.
     */
    private CheckEvenNumbers numbers = new CheckEvenNumbers();
    /**
     * Test.
     */
    @Test
    public void whenEnterNumberIsEven() {
        String number = "2";
        ByteArrayInputStream stream = new ByteArrayInputStream(number.getBytes());
        boolean isNeedSave = this.numbers.isNumber(stream);
        assertThat(isNeedSave, is(true));
    }
    /**
     * Test.
     */
    @Test
    public void whenEnterNumberIsNotEven() {
        String number = "5";
        ByteArrayInputStream stream = new ByteArrayInputStream(number.getBytes());
        boolean isNeedSave = this.numbers.isNumber(stream);
        assertThat(isNeedSave, is(false));
    }
    /**
     * Test.
     */
    @Test(expected = InputMismatchException.class)
    public void whenEnterNotNumber() {
        String number = "asdf";
        ByteArrayInputStream stream = new ByteArrayInputStream(number.getBytes());
        this.numbers.isNumber(stream);
    }
}