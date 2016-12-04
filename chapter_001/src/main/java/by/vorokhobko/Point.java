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
 */
	public double x;
	public double y;

	public Point(double x, double y) {
 /**
 * The the constructor of the Point with parameters.
 * @param x - x.
 * @param y - y.
 */
		this.x = x;
		this.y = y;
	}

	public double distanceTo(Point point) {
 /**
 * Сalculate the distance.
 */
		double result = Math.sqrt( Math.pow(point.x - x,2) + Math.pow(point.y - y,2) );
		return result;
	}
}