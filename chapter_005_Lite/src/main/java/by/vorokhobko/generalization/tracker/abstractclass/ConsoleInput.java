package by.vorokhobko.generalization.tracker.abstractclass;

import java.util.Scanner;

/**
 * ConsoleInput.
 *
 * Class ConsoleInput program for communication with the user part 002, lesson 5.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 20.03.2017.
 * @version 1.
 */

public class ConsoleInput implements Input {
	/**
	 * The class field.
	 * Сreating scanner.
	 */
	private Scanner scanner = new Scanner(System.in);
	/**
	 * Сreate the class question.
	 * @param question - question.
	 * @return tag.
	 */
	public String ask(String question) {
		System.out.print(question);
		return scanner.nextLine();
	}
	/**
	 * The method question ask.
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