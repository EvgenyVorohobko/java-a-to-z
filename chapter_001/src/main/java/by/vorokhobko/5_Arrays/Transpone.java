package by.vorokhobko.5_Arrays;

/**
* Transpone.
*
* Class Transpone transposes the massif part 001, lesson 5.
* @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
* @since 23.12.2016.
* @version 1.
*/

public class Transpone {
	/**
	* The class field.
	* The method transposes massif.
	* @param values - values.
	* @return tag.
	*/

		public int[][] transpone(int[][] values) {
			int[][] tValues = new int[values.length][values.length];
				for (int i = 0; i < values.length; i++) {
					for (int j = 0; j < values.length; j++) {
						tValues[i][j] = values[j][i];
            }
        }
        return tValues;
    }
}