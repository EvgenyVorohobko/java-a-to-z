package by.vorokhobko.arrays;

/**
* BubbleSort.
*
* Class BubbleSort bubble sorts the elements in the array part 001, lesson 5.
* @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
* @since 21.12.2016.
* @version 1.
*/

public class BubbleSort {
	/**
	* The class field.
	* The method bubble sorts the elements.
	* @param values - values.
	* @return tag.
	*/

	public int[] sorting(int[] values) {
		for (int i = values.length - 1; i > 0; i--) {
			for (int x = 0; x < i; x++) {
				if (values[x] > values[x + 1]) {
					int var = values[x];
					values[x] = values[x + 1];
					values[x + 1] = var;
				}
			}
		}
		return values;
	}
}