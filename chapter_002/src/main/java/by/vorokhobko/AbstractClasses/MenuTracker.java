package by.vorokhobko.AbstractClasses;

import by.vorokhobko.Encapsulation.models.Item;
import by.vorokhobko.Encapsulation.models.Task;
import by.vorokhobko.Encapsulation.start.Tracker;
import by.vorokhobko.Templates.BaseAction;

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
    private UserAction[] actions = new UserAction[10];
    /**
     * The class field.
     */
	private int position = 0;
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
        this.actions[position++] = this.new AddItems("Add the new item");
        this.actions[position++] = new MenuTracker.ShowItems("Show all items");
        this.actions[position++] = new EditItem("Edit the item");
        this.actions[position++] = this.new DeleteItem("Delete this item");
        this.actions[position++] = this.new FindByNameItem("Find by name this item");
    }
    /**
     * Сreate the method add actions.
     * @param action - action.
     */
	public void addAction(UserAction action) {
		this.actions[position++] = action;
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
    private class AddItems extends BaseAction {
       /**
        * Сreate name in the method AddItems.
        * @param name - name.
        */
       AddItems(String name) {
           super(name);
       }
       /**
        * The method key, inherited from class UserAction.
        * @return tag.
        */
       @Override
       public int key() {
           return 0;
       }
       /**
        * The method execute, inherited from class UserAction.
        * @param input - input.
        * @param tracker - tracker.
        */
       @Override
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
       @Override
       public String info() {
           return getName();
       }
    }
   /**
	* Internal class which show items with work the user.
	*/
    private static class ShowItems extends BaseAction {
       /**
        * Сreate name in the method ShowItems.
        * @param name - name.
        */
       ShowItems(String name) {
           super(name);
       }
       /**
        * The method key, inherited from class UserAction.
        * @return tag.
        */
       @Override
       public int key() {
            return 1;
       }
       /**
        * The method execute, inherited from class UserAction.
        * @param input - input.
        * @param tracker - tracker.
        */
       @Override
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
       @Override
       public String info() {
           return getName();
       }
    }
    /**
     * Internal class which delete item with work the user.
     */
    private class DeleteItem extends BaseAction {
        /**
         * Сreate name in the method DeleteItem.
         * @param name - name.
         */
        DeleteItem(String name) {
            super(name);
        }
        /**
         * The method key, inherited from class UserAction.
         * @return tag.
         */
        @Override
        public int key() {
            return 3;
        }
        /**
         * The method execute, inherited from class UserAction.
         * @param input - input.
         * @param tracker - tracker.
         */
        @Override
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
        @Override
        public String info() {
            return getName();
        }
    }
    /**
     * Internal class which delete item with work the user.
     */
    private class FindByNameItem extends BaseAction {
        /**
         * Сreate name in the method FindByNameItem.
         * @param name - name.
         */
        FindByNameItem(String name) {
            super(name);
        }
        /**
         * The method key, inherited from class UserAction.
         * @return tag.
         */
        @Override
        public int key() {
            return 4;
        }

        /**
         * The method execute, inherited from class UserAction.
         * @param input - input.
         * @param tracker - tracker.
         */
        @Override
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
        @Override
        public String info() {
            return getName();
        }
    }
}
/**
 * Internal class which edit item with work the user.
 */
class EditItem extends BaseAction {
    /**
     * Сreate name in the method EditItem.
     * @param name - name.
     */
    EditItem(String name) {
        super(name);
    }
    /**
     * The method key, inherited from class UserAction.
     * @return tag.
     */
    @Override
    public int key() {
        return 2;
    }
    /**
     * The method execute, inherited from class UserAction.
     * @param input - input.
     * @param tracker - tracker.
     */
    @Override
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
    @Override
    public String info() {
        return getName();
    }
}