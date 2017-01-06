package by.vorokhobko.Arrays;

/**
* Turn.
*
* Class Turn reverses the elements of an array part 001, lesson 5.
* @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
* @since 20.12.2016.
* @version 1.
*/

public class Turn {
	/**
	* The class field.
	* The method reverses an array.
	* @param numbers - numbers.
	* @return tag.
	*/

	public int[] back(int[] numbers) {
		for (int i = 0; i < numbers.length / 2; i++) {
			int step = numbers[i];
			numbers[i] = numbers[numbers.length - i - 1];
			numbers[numbers.length - i - 1] = step;
		}
		return numbers;
	}
}