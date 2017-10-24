package by.vorokhobko.exception;

import by.vorokhobko.encapsulation.start.Tracker;
import by.vorokhobko.encapsulation.models.Task;
import by.vorokhobko.encapsulation.models.Item;

/**
 * MenuTracker.
 *
 * Class MenuTracker to implement inner classes part 002, lesson 6.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 10.04.2017.
 * @version 1.
 */

public class MenuTracker {
    /**
     * The class field.
     */
    private Input input;
    /**
     * The class field.
     */
    private Tracker tracker;
    /**
     * The class field.
     */
    private UserAction[] actions = new UserAction[5];
    /**
     * Сreate the class constructor MenuTracker.
     * @param input - input.
     * @param tracker - tracker.
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
	/**
     * Сreates a method that fills actions.
     */
    public void fillActions() {
        this.actions[0] = this.new AddItems();
        this.actions[1] = new MenuTracker.ShowItems();
        this.actions[2] = new EditItem();
        this.actions[3] = this.new DeleteItem();
        this.actions[4] = this.new FindByNameItem();
    }
	/**
     * Сreate the method choice actions.
     * @param key - key.
     */
    public void select(int key) {
        this.actions[key].execute(input, tracker);
    }
	/**
     * Сreate the method show actions.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }
    /**
     * Сreate the method getRanges menu system.
     * @return tag.
     */
    public int[] getRanges() {
        int[] ranges = new int[this.actions.length];
        for (int key = 0; key < this.actions.length; key++) {
            ranges[key] = key;
        }
        return ranges;
    }
   /**
	* Internal class which adds item with work the user.
	*/
    private class AddItems implements UserAction {
		/**
		* The method key, inherited from class UserAction.
		* @return tag.
		*/
        public int key() {
            return 0;
        }
		/**
		* The method execute, inherited from class UserAction.
		* @param input - input.
		* @param tracker - tracker.
		*/
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please, enter the task's name: ");
            String desc = input.ask("Please, enter the task's desc: ");
            String create = input.ask("please, enter the task's time: ");
            tracker.add(new Task(name, desc, Long.parseLong(create)));
        }
		/**
		* The method info, inherited from class UserAction.
		* @return tag.
		*/
        public String info() {
            return String.format("%s. %s", this.key(), "Add the new item");
        }
    }
   /**
	* Internal class which show items with work the user.
	*/
    private static class ShowItems implements UserAction {
		/**
		* The method key, inherited from class UserAction.
		* @return tag.
		*/
        public int key() {
            return 1;
        }
		/**
		* The method execute, inherited from class UserAction.
		* @param input - input.
		* @param tracker - tracker.
		*/
        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.findAll()) {
                if (item != null) {
                    System.out.println(
                            String.format("%s. %s", item.getId(), item.getName())
                    );
                } else {
                    System.out.println("This ITEM does not exist");
                }
            }
        }
		/**
		* The method info, inherited from class UserAction.
		* @return tag.
		*/
        public String info() {
            return String.format("%s. %s", this.key(), "Show all items");
        }
    }
    /**
     * Internal class which delete item with work the user.
     */
    private class DeleteItem implements UserAction {
        /**
         * The method key, inherited from class UserAction.
         * @return tag.
         */
        public int key() {
            return 3;
        }
        /**
         * The method execute, inherited from class UserAction.
         * @param input - input.
         * @param tracker - tracker.
         */
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please, enter the task's id: ");
            Item task = new Item();
            task.setId(id);
            tracker.delete(task);
        }
        /**
         * The method info, inherited from class UserAction.
         * @return tag.
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Delete this item");
        }
    }
    /**
     * Internal class which delete item with work the user.
     */
    private class FindByNameItem implements UserAction {
        /**
         * The method key, inherited from class UserAction.
         * @return tag.
         */
        public int key() {
            return 4;
        }
        /**
         * The method execute, inherited from class UserAction.
         * @param input - input.
         * @param tracker - tracker.
         */
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please, enter the task's name: ");
            Item task = new Item();
            task.setName(name);
            if (tracker.findByName(name) != null) {
                System.out.println(name);
            } else {
                System.out.println("This Name does not exist");
            }
        }
        /**
         * The method info, inherited from class UserAction.
         * @return tag.
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Find by name this item");
        }
    }
}
/**
 * Internal class which edit item with work the user.
 */
class EditItem implements UserAction {
	/**
     * The method key, inherited from class UserAction.
     * @return tag.
     */
    public int key() {
        return 2;
    }
	/**
     * The method execute, inherited from class UserAction.
     * @param input - input.
	 * @param tracker - tracker.
     */
    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Please, enter the task's id: ");
        String name = input.ask("Please, enter the task's name: ");
        String desc = input.ask("Please, enter the task's desc: ");
        String create = input.ask("please, enter the task's time: ");
        Task task = new Task(name, desc, Long.parseLong(create));
        task.setId(id);
        tracker.update(task);
        if (tracker.findById(id) != null) {
            System.out.println(name);
            System.out.println(desc);
            System.out.println(create);
        } else {
            System.out.println("This ID does not exist");
        }
    }
	/**
     * The method info, inherited from class UserAction.
     * @return tag.
     */
    public String info() {
        return String.format("%s. %s", this.key(), "Edit the item");
    }
}