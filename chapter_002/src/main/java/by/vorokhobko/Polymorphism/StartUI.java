package by.vorokhobko.start;

import by.vorokhobko.Encapsulation.start.Tracker;
import by.vorokhobko.Encapsulation.models.Item;
import by.vorokhobko.Encapsulation.models.Task;

/**
 * StartUI.
 *
 * Class StartUI the entry point to the program part 002, lesson 3.
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
	* Сreate the class constructor StartUI.
	* @param tracker - tracker.
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
	public void FindAllItem(Tracker tracker) {
		String name1 = input.ask("please, enter the task's name: ");
		String desc1 = input.ask("please, enter the task's description: ");
		String create1 = input.ask("please, enter the task's time: ");
		tracker.add(new Task(name1, desc1, Long.parseLong(create1)));
		String name2 = input.ask("please, enter the task's name: ");
		String desc2 = input.ask("please, enter the task's description: ");
		String create2 = input.ask("please, enter the task's time: ");
		tracker.add(new Task(name2, desc2, Long.parseLong(create2)));
		tracker.findAll();
	}
	/**
	* The method needs to replace the cell in the array.
	* @param tracker - tracker.
	*/
	public void EditItem(Tracker tracker) {
		String name = input.ask("please, enter the task's name: ");
		String desc = input.ask("please, enter the task's description: ");
		String create = input.ask("please, enter the task's time: ");
		Task task = new Task(name, desc, Long.parseLong(create));
		tracker.add(task);
		tracker.update(task);
	}
	/**
	* The method should delete the cells in the array.
	* @param tracker - tracker.
	*/
	public void DeleteItem(Tracker tracker) {
		String name = input.ask("please, enter the task's name: ");
		String desc = input.ask("please, enter the task's description: ");
		String create = input.ask("please, enter the task's time: ");
		Task task = new Task(name, desc, Long.parseLong(create));
		tracker.add(task);
		tracker.delete(task);
	}
	/**
	* The method finds similar cells in the Id.
	* @param tracker - tracker.
	*/
	public void FindItemById(Tracker tracker) {
		String name = input.ask("please, enter the task's name: ");
		String desc = input.ask("please, enter the task's description: ");
		String create = input.ask("please, enter the task's time: ");
		Task task = new Task(name, desc, Long.parseLong(create));
		tracker.add(task);
		String id = input.ask("please, enter the task's id: ");
		tracker.findById(id);
		if (tracker.findById(id) != null) {
			System.out.print(tracker.findById(id));
		} else {
			System.out.println("This ID does not exist");
		}
	}
	/**
	* The main method of the program, menu.
	* @param tracker - tracker.
	*/
	public void init(Tracker tracker) {
		String result = input.ask("please select one of the items:\n 1 - Add new Item\n " +
					"2 - Show all items\n 3 - Edit item\n 4 - Delete item\n 5 - Find item by Id\n" +
					" 6 - Find items by name\n 7 - Exit Program\n");
		if (result.equals(1)) {
			new StartUI(input).addItem(tracker);
		}
		if (result.equals(2)) {
			new StartUI(input).FindAllItem(tracker);
		}
		if (result.equals(3)) {
			new StartUI(input).EditItem(tracker);
		}
		if (result.equals(4)) {
			new StartUI(input).DeleteItem(tracker);
		}
		if (result.equals(5)) {
			new StartUI(input).FindItemById(tracker);
		}
		if (result.equals(6)) {
			init(tracker);
		}
	}
	/**
	* Method run the program.
	* @param tracker - tracker.
	*/
	public static void main(String[] args) {
		Tracker tracker = new Tracker();
		Input input = new ConsoleInput();
		new StartUI(input).init(tracker);
	}
}