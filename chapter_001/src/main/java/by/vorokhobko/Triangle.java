package by.vorokhobko;

public class Triangle {
 /**
 * The class field.
 * Сreating point of a triangle a.
 */
	public Point a;
 /**
 * Сreating point of a triangle b.
 */
	public Point b;
 /**
 * Сreating point of a triangle c.
 */
	public Point c;
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
		if((lineAB < (lineAC + lineBC)) && (lineAC < (lineAB + lineBC)) && (lineBC < (lineAB + lineAC))) {
			double pperimeter = lineAB + lineAC + lineBC;
			return Math.sqrt(pperimeter * (pperimeter - lineAB) * (pperimeter - lineAC) * (pperimeter - lineBC));
		} else {
			throw new ArithmeticException("The triangle cannot be constructed");
		}
	}
}