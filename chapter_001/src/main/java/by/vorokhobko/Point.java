package by.vorokhobko;

/**
 * Point.
 *
 * Class Point calculate the length of the line part 001, lesson 3.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 04.12.2016.
 * @version 1.
 */

public class Point {
 /**
 * The class field.
 * double x.
 */
	private double x;
/**
 * double y.
 */
	private double y;

 /**
 * The constructor of the Point with parameters.
 * @param x - x.
 * @param y - y.
 */

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

 /**
 * Сalculate the distance.
 * @param point - point.
 * @return tag.
 */
	public double distanceTo(Point point) {
		return Math.sqrt(Math.pow((point.x - x), 2) + Math.pow((point.y - y), 2));
	}
}