package by.vorokhobko;
/**
 * Max.
 *
 * Class Max returns the max number part 001, lesson 3.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 06.12.2016.
 * @version 1.
 */
public class Max {
	/**
	* The class field.
	* The method determines the max number.
	* @param first - first.
	* @param second - second.
	* @return tag.
	*/
	public int max(int first, int second) {
	int largeNum = first < second ? second : first;
	return largeNum;
	}
}