package by.vorokhobko;
/**
 * MaxThree.
 *
 * Class MaxThree returns the max of three numbers part 001, lesson 3.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 07.12.2016.
 * @version 1.
 */
public class MaxThree {
	/**
	* The class field.
	* The method determines the max number.
	* @param first - first.
	* @param second - second.
	* @param third - third.
	* @return tag.
	*/
	public int maxThree(int first, int second, int third) {
		Max max = new Max();
		int firstMax = max.max(first, second);
		int largeNum = firstMax < third ? third : firstMax;
		return largeNum;
	}
}