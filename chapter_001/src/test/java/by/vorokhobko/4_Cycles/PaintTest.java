package by.vorokhobko.4_Cycles;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* PaintTest.
*
* Class PaintTest for testing class Paint part 001, lesson 4.
* @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
* @since 10.12.2016.
* @version 1.
*/

public class PaintTest {
	/**
	* @Test.
	* The method draws a pyramid in pseudographics.
	*/
	@Test
	public void drawingOfThePyramidInPseudographics() {
		final Paint paint = new Paint();
		final int h = 3;
		String outPrint = "    ^ " + System.getProperty("line.separator") + "   ^ ^ " + System.getProperty("line.separator") + "  ^ ^ ^ " + System.getProperty("line.separator");
		String result = paint.pyramid(h);
		assertThat(result, is(outPrint));
	}
}