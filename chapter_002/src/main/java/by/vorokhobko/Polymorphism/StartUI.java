package by.vorokhobko.start;

import by.vorokhobko.models.*;

public class StartUI {

	public static void main(String[] args) {
		ConsoleInput input = new ConsoleInput();
		String name = input.ask("please, enter the task's name: ");
		Tracker tracker = new Tracker();
		tracker.add(new Task(name, "first desc", 05l));
		for (Item item : tracker.findAll()) {
			System.out.println(item.getName());
		}
	}
}