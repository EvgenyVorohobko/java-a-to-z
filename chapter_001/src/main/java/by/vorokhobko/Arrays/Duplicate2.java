package by.vorokhobko.Arrays;

/**
* Duplicate2.
*
* Class Duplicate2 remove duplicates in array 001, lesson 5.
* @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
* @since 28.12.2016.
* @version 1.
*/

public class Duplicate2 {
	/**
	* The class field.
	* The method remove duplicates.
	* @param values - values.
	* @return tag.
	*/

	public String[] deleteDuplicate(String[] values) {
		boolean[] viewing = new boolean[values.length];
		int count = 0;
		for (int x = 0; x < values.length; x++) {
			if (!viewing[x]) {
				String index = values[x];
				for (int y = x + 1; y < values.length; y++) {
					if (index == values[y]) {
						viewing[y] = true;
						count++;
					}
				}
			}
		}
		String[] result = new String[values.length - count];
		for (int i = 0, j = 0; i < values.length; i++) {
			if (!viewing[i]) {
				result[j++] = values[i];
			}
		}
		return result;
	}
}