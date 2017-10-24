package by.vorokhobko.cycles;

/**
* Facorial.
*
* Class Factorial calculates the factorial of  part 001, lesson 4.
* @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
* @since 10.12.2016.
* @version 1.
*/

public class Factorial {
	/**
	* The class field.
	* The method calculates the factorial.
	* @param n - n.
	* @return tag.
	*/

	public int mult(int n) {
		int fact = 1;
		for (int i = 1; i < n; i++) {
			fact *= i;
		}
		if (n == 0) {
			int i = 0;
			fact = 1;
		}
		return fact;
	}
}