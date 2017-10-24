package by.vorokhobko.abstractclass;

/**
 * ValidateInput.
 *
 * Class ValidateInput to work with exception 002, lesson 7.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 18.04.2017.
 * @version 1.
 */
public class ValidateInput extends ConsoleInput {
	/**
	 * The implementation of polymorphism from class Input.
	 * @param question - question.
	 * @param range - range.
	 * @return tag.
	 */
	public int ask(String question, int[] range) {
		boolean invalid = true;
		int value = -1;
		do {
			try {
				value = super.ask(question, range);
				invalid = false;
			} catch (MenuOutException moe) {
				System.out.println("Please, select key from menu");
			} catch (NumberFormatException nfe) {
				System.out.println("Please, enter validate data again");
			}
		} while (invalid);
		return value;
	}
}