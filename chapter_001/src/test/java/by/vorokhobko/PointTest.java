package by.vorokhobko;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.number.IsCloseTo.closeTo;

/**
 * PointTest.
 *
 * Class PointTest for testing class Point.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 04.12.2016.
 * @version 1.
 */

public class PointTest {

	public static void main(String[] args) {
	  /**
	  * @Test.
	  * Point test.
	  */
		Point pointBegun = new Point();
		final double x = 2;
		final double y = 4;
		final double totalNumber = 6.3;
		final double numberExeption = 0.01;
		double resulte = pointBegun.distanceTo(x, y);
		assertThat(result, is(closeTo(totalNumber, numberExeption)));
		}
	}