package by.vorokhobko.Cycles;

/**
* Counter.
*
* Class Counter needs to perform the calculation amount in the range part 001, lesson 4.
* @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
* @since 10.12.2016.
* @version 1.
*/

public class Counter {
	/**
	* The class field.
	* The method calculates the sum of even numbers in the range.
	* @param start - start.
	* @param finish - finish.
	* @return tag.
	*/
	public int add(int start, int finish) {
		int sum = 0;
		for (; start < finish; start++) {
			if (start % 2 == 0) {
				sum = sum + start;
			}
		}
		return sum;
	}
}