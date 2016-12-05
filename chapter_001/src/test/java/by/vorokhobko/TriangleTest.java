package by.vorokhobko;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.number.IsCloseTo.closeTo;

/**
 * TriangleTest.
 *
 * Class TriangleTest for testing class Triangle.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 05.12.2016.
 * @version 1.
 */

public class TriangleTest {
	  /**
	  * @Test.
	  * Point test.
	  * @param args - args.
	  */
	public static void determineTheAreaOfTheTriangle(String[] args) {
		final double x = 2;
		final double y = 5;
		final double totalArea = 34.971;
		final double numberExeption = 0.01;
		Point point = new Point(x, y);
		double resultArea = point.area(); 
		assertThat(resultArea, is(closeTo(totalArea, numberExeption)));
		}
	}