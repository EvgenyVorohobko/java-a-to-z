package by.vorokhobko.Exception;

/**
 * Input.
 *
 * Class Input the interface for the program part 002, lesson 5.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 20.03.2017.
 * @version 1.
 */

public interface Input {
	/**
	* Сreate the method ask.
	* @param question - question.
	* @return tag.
	*/
	String ask(String question);
	/**
	* Method overload ask.
	* @param question - question.
	* @param range - range.
	* @return tag.
	*/
	int ask(String question, int[] range);
}