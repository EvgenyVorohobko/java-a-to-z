package by.vorokhobko.JVM_Byte_code;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @version 1.
 * @since 11.11.2016.
 */

public class CalculateTest {
    /**
     * @Test.
     */
    @Test
    public void whenRunHWThenPrintToOut() {
		final Calculate calc = new Calculate();
		String outPrint = "Hello World!" + System.getProperty("line.separator");
		String result = calc.helloWorld();
        assertThat(result, is(outPrint));
    }
}