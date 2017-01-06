package by.vorokhobko.Conditional_operator;
/**
 * Triangle.
 *
 * Class Triangle calculate the area of the triangle part 001, lesson 3.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 05.12.2016.
 * @version 4.
 */
public class Triangle {
 /**
 * The class field.
 * Сreating point of a triangle a.
 */
	private Point a;
 /**
 * Сreating point of a triangle b.
 */
	private Point b;
 /**
 * Сreating point of a triangle c.
 */
	private Point c;
 /**
 * The constructor of the Triangle with the designation points.
 * @param a - a.
 * @param b - b.
 * @param c - c.
 */
	public Triangle(Point a, Point b, Point c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
 /**
 * Сalculate the area.
 * @return tag.
 */
	public double area() {
		double lineAB = a.distanceTo(b);
		double lineAC = a.distanceTo(c);
		double lineBC = b.distanceTo(c);
		double numberOfPperimeter = 2;
		if ((lineAB < (lineAC + lineBC)) && (lineAC < (lineAB + lineBC)) && (lineBC < (lineAB + lineAC))) {
			double pperimeter = (lineAB + lineAC + lineBC) / numberOfPperimeter;
			return Math.sqrt(pperimeter * (pperimeter - lineAB) * (pperimeter - lineAC) * (pperimeter - lineBC));
		} else {
			throw new ArithmeticException("The triangle cannot be constructed");
		}
	}
}