package by.vorokhobko.Generalization.Tracker.AbstractClasses;

/**
 * StubInput.
 *
 * Class StubInput the creation of the input as the user part 002, lesson 5.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 20.03.2017.
 * @version 1.
 */

public class StubInput implements Input {
	/**
	 * The class field.
	 * Сreating array's answer.
	 */
	private String[] answers;
	/**
	 * The class field.
	 * Сreating position.
	 */
	private int position = 0;
	/**
	 * Сreate the class constructor StubInput.
	 * @param answers - answers.
	 */
	public StubInput(String[] answers) {
		this.answers = answers;
	}
	/**
	 * The implementation of polymorphism from class Input.
	 * @param question - question.
	 * @return tag.
	 */
	public String ask(String question) {
		return answers[position++];
	}
	/**
	 * The overloading from method ask.
	 * @param question - question.
	 * @param range - range.
	 * @return tag.
	 */
	public int ask(String question, int[] range) {
		int key = Integer.valueOf(this.ask(question));
		boolean exist = false;
		for (int value : range) {
			if (value == key) {
				exist = true;
				break;
			}
		}
		if (exist) {
			return key;
		} else {
			throw new MenuOutException("Out of menu range.");
		}
	}
}