package by.vorokhobko.tracker;

/**
 * MenuOutException.
 *
 * Class MenuOutException for processing RuntimeException part 002, lesson 7.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 18.04.2017.
 * @version 1.
 */
public class MenuOutException extends RuntimeException {
	/**
	 * Create an overloaded constructor.
	 * Add MenuOutException.
	 * @param msg - msg.
	 */
	public MenuOutException(String msg) {
		super(msg);
	}
}