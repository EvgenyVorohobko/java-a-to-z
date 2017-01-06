package by.vorokhobko.3_conditional_operator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.number.IsCloseTo.closeTo;
import org.junit.Test;

/**
 * PointTest.
 *
 * Class PointTest for testing class Point.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 04.12.2016.
 * @version 1.
 */

public class PointTest {
	  /**
	  * @Test.
	  * Point test.
	  */
		@Test
	public void testDeterminingTheDistanceBetweenTwoPoints() {
		final double x = 2;
		final double y = 4;
		final double totalNumber = 4.472;
		final double numberExeption = 0.01;
		Point pointBegun = new Point(x, y);
		Point pointEnd = new Point(x + x, y + y);
		double resultBE = pointBegun.distanceTo(pointEnd);
		assertThat(resultBE, is(closeTo(totalNumber, numberExeption)));
		}
	}