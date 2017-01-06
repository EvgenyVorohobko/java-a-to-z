package by.vorokhobko.4_Cycles;

/**
* Paint.
* Class Paint draws a pyramid in character graphics of part 001, lessson 4.
* @author Vorokhobko Evgeny (vorokhobko2011@yandex.ru).
* @since 15.12.2016.
* @version 4
*/

public class Paint {
	/**
	* The class field.
	* The method draws a pyramid.
	* @param h - h.
	* @return tag.
	*/

	public String pyramid(int h) {
		StringBuilder sb = new StringBuilder();
		for (int first = 0; first < h; first++) {
			for (int second = 0; second <= (h - first); second++) {
				sb.append(" ");
			}
			for (int three = 0; three <= first; three++) {
				sb.append("^ ");
			}
			sb.append(System.getProperty("line.separator"));
		}
		return sb.toString();
	}
}