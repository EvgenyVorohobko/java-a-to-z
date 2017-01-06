package by.vorokhobko.Control_questions;

/**
* Substring.
*
* Class Substring finds the substring in the original string 001, lesson 6.
* @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
* @since 03.01.2017.
* @version 1.
*/

public class Substring {

	/**
	* The class field.
	* The method finds the substring.
	* @param origin - origin.
	* @param sub - sub
	* @return tag.
	*/

	public boolean contains(String origin, String sub) {
		int originLength = origin.length();
		int subLength = sub.length();
		boolean def = false;
		String result;
		for (int i = 0; i <= (originLength - subLength); i++) {
			if (origin.regionMatches(i, sub, 0, subLength)) {
				def = true;
				result = origin.substring(i, i + subLength);
			}
		}
		if (!def) {
			def = false;
		}
		return def;
	}
}