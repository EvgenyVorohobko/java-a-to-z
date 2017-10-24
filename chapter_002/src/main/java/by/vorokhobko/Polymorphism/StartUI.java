package by.vorokhobko.polymorphism;

import by.vorokhobko.encapsulation.start.Tracker;
import by.vorokhobko.encapsulation.models.Task;
import by.vorokhobko.encapsulation.models.Item;
/**
 * StartUI.
 *
 * Class StartUI the entry point to the program part 002, lesson 5.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 20.03.2017.
 * @version 1.
 */

public class StartUI {
	/**
     * The class field.
	 * Сreating input.
	 */
	private Input input;
	/**
	 * The class field.
	 * Сreating const add Item.
	 */
	public static final String ADD = "1";
	/**
	 * The class field.
	 * Сreating const add Item.
	 */
	public static final String SHOW = "2";
	/**
	 * The class field.
	 * Сreating const add Item.
	 */
	public static final String EDIT = "3";
	/**
	 * The class field.
	 * Сreating const add Item.
	 */
	public static final String DELETE = "4";
	/**
	 * The class field.
	 * Сreating const add Item.
	 */
	public static final String FIND_ID = "5";
	/**
	 * The class field.
	 * Сreating const add Item.
	 */
	public static final String FIND_NAME = "6";
	/**
	 * The class field.
	 * Сreating const add Item.
	 */
	public static final String EXIT = "7";
	/**
	* Сreate the class constructor StartUI.
	* @param input - input.
	*/
	public StartUI(Input input) {
		this.input = input;
	}
	/**
	* The method adds a request to the array.
	* @param tracker - tracker.
	*/
	public void addItem(Tracker tracker) {
		String name = input.ask("please, enter the task's name: ");
		String desc = input.ask("please, enter the task's description: ");
		String create = input.ask("please, enter the task's time: ");
		tracker.add(new Task(name, desc, Long.parseLong(create)));
	}
	/**
	* The method searches all cells.
	* @param tracker - tracker.
	*/
	public void findAllItem(Tracker tracker) {
		String name1 = input.ask("please, enter the task's name: ");
		String desc1 = input.ask("please, enter the task's description: ");
		String create1 = input.ask("please, enter the task's time: ");
		tracker.add(new Task(name1, desc1, Long.parseLong(create1)));
		tracker.findAll();
	}
	/**
	* The method needs to replace the cell in the array.
	* @param tracker - tracker.
	*/
	public void editItem(Tracker tracker) {
		String id = input.ask("please, enter the task's id: ");
		if (tracker.findById(id) != null) {
			String name = input.ask("please, enter the task's name: ");
			String desc = input.ask("please, enter the task's description: ");
			String create = input.ask("please, enter the task's time: ");
			Task task = new Task(name, desc, Long.parseLong(create));
			task.setId(id);
			tracker.update(task);
		} else {
			System.out.println("This id does not exist");
		}
	}
	/**
	* The method should delete the cells in the array.
	* @param tracker - tracker.
	*/
	public void deleteItem(Tracker tracker) {
		String id = input.ask("please, enter the task's id: ");
		if (tracker.findById(id) != null) {
			Task task = new Task("", "", Long.parseLong("1"));
			task.setId(id);
			tracker.delete(task);
		} else {
			System.out.println("This id does not exist");
		}
	}
	/**
	* The method finds similar cells in the Id.
	* @param tracker - tracker.
	*/
	public void findItemById(Tracker tracker) {
		String id = input.ask("please, enter the task's id: ");
		if (tracker.findById(id) != null) {
			Task task = new Task("", "", Long.parseLong("1"));
			task.setId(id);
			tracker.findById(id);
		} else {
			System.out.println("This id does not exist");
		}
	}
	/**
	 * The method finds similar cells in the Name.
	 * @param tracker - tracker.
	 */
	public void findItemsByName(Tracker tracker) {
		String id = input.ask("please, enter the task's id: ");
		if (tracker.findById(id) != null) {
			Item item = new Item();
			item.getName();
		} else {
			System.out.println("This name does not exist");
		}
	}
	/**
	 * The method exit this program.
	 * @param tracker - tracker.
	 */
	public void exitProgram(Tracker tracker) {
		int exitNumber = 7;
		String answer = "n";
		do {
			if (exitNumber == 7) {
				answer = input.ask("You are sure?\n y/n: ");
				if (answer.equals("y")) {
					break;
				} else {
					init(tracker);
				}
				break;
			}
		} while (answer.equals("n"));
	}

	/**
	* The main method of the program, menu.
	* @param tracker - tracker.
	*/
	public void init(Tracker tracker) {
		String result = input.ask("please select one of the items:\n 1 - Add new Item\n "
		+ "2 - Show all items\n 3 - Edit item\n 4 - Delete item\n 5 - Find item by Id\n"
		+ " 6 - Find items by name\n 7 - Exit Program\n");
		if (result.equals(ADD)) {
			new StartUI(input).addItem(tracker);
		}
		if (result.equals(SHOW)) {
			new StartUI(input).findAllItem(tracker);
		}
		if (result.equals(EDIT)) {
			new StartUI(input).editItem(tracker);
		}
		if (result.equals(DELETE)) {
			new StartUI(input).deleteItem(tracker);
		}
		if (result.equals(FIND_ID)) {
			new StartUI(input).findItemById(tracker);
		}
		if (result.equals(FIND_NAME)) {
			new StartUI(input).findItemsByName(tracker);
		}
		if (result.equals(EXIT)) {
			new StartUI(input).exitProgram(tracker);
		}
	}
	/**
	* Method run the program.
	* @param args - args.
	*/
	public static void main(String[] args) {
		Tracker tracker = new Tracker();
		Input input = new ConsoleInput();
		new StartUI(input).init(tracker);
	}
}