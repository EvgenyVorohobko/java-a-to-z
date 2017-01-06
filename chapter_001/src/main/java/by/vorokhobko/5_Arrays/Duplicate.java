package by.vorokhobko.5_Arrays;

import java.util.Arrays;

/**
* Duplicate.
*
* Class Duplicate remove duplicates in array 001, lesson 5.
* @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
* @since 23.12.2016.
* @version 1.
*/

public class Duplicate {
	/**
	* The class field.
	* The method remove duplicates.
	* @param values - values.
	* @return tag.
	*/

	public String[] deleteDuplicate(String[] values) {
		String[] copyValues;
		copyValues = Arrays.copyOfRange(values, 1, 3);
		return copyValues;
	}
}