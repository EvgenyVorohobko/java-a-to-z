package by.vorokhobko.tracker;

import by.vorokhobko.tracker.encapsulation.start.Tracker;
import org.apache.log4j.BasicConfigurator;

/**
 * StartUI.
 *
 * Class StartUI the entry point to the program part 002, lesson 6.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 11.04.2017.
 * @version 1.
 */
public class StartUI {
	/**
	 * The class field.
	 */
	private static final String URL = "jdbc:sqlite:d:/WORK/SQLlite/TEST/items.db";
	/**
	 * The class field.
	 * Сreating input.
	 */
	private Input input;
	/**
	 * The class constructor StartUI.
	 * @param input - input.
	 */
	public StartUI(Input input) {
		this.input = input;
	}
	/**
	 * The main method of the program, menu.
	 * @param tracker - tracker.
	 */
	public void init(Tracker tracker) {
		MenuTracker menu = new MenuTracker(input, tracker);
		menu.fillActions();
		int[] ranges = new int[menu.getSize()];
		for (int i = 0; i < menu.getSize(); i++) {
			ranges[i] = i;
		}
		tracker.createConnection(URL);
		tracker.createTable();
		do {
			menu.show();
			try {
				menu.select(input.ask("Select: ", ranges));
			} catch (MenuOutException e) {
				e.printStackTrace();
			}
		} while (!"y".equals(this.input.ask("Exit? (y): ")));
		tracker.closeConnection();
	}
	/**
	 * Method run the program.
	 * @param args - args.
	 */
	public static void main(String[] args) {
		BasicConfigurator.configure();
		Tracker tracker = new Tracker();
		Input input = new ValidateInput();
		new StartUI(input).init(tracker);
	}
}