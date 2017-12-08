package by.vorokhobko.tracker;

import by.vorokhobko.tracker.encapsulation.models.Item;
import by.vorokhobko.tracker.encapsulation.models.Task;
import by.vorokhobko.tracker.encapsulation.start.Tracker;
import by.vorokhobko.tracker.templates.BaseAction;

import java.util.ArrayList;
import java.util.List;

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
    private List<UserAction> actions;
    /**
     * Сreate the class constructor MenuTracker.
     * @param input - input.
     * @param tracker - tracker.
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
        this.actions = new ArrayList<>();
    }
    /**
     * Сreates a method that fills actions.
     */
    public void fillActions() {
        this.actions.add(this.new AddItems(0, "Add the new item"));
        this.actions.add(new MenuTracker.ShowItems(1, "Show all items"));
        this.actions.add(new EditItem(2, "Edit the item"));
        this.actions.add(this.new DeleteItem(3, "Delete this item"));
        this.actions.add(this.new FindByNameItem(4, "Find by name this item"));
    }
    /**
     * Сreate the method add actions.
     */
	public int getSize() {
		return this.actions.size();
	}
    /**
     * Сreate the method choice actions.
     * @param key - key.
     */
    public void select(int key) {
        this.actions.get(key).execute(input, tracker);
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
	* Internal class which adds item with work the user.
	*/
    private class AddItems extends BaseAction {
       /**
        * Сreate name in the method AddItems.
        * @param name - name.
        */
       AddItems(int key, String name) {
           super(key, name);
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
    }
   /**
	* Internal class which show items with work the user.
	*/
    private static class ShowItems extends BaseAction {
       /**
        * Сreate name in the method ShowItems.
        * @param name - name.
        */
       ShowItems(int key, String name) {
           super(key, name);
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
                            String.format("%s. %s. %s. %s", item.getId(), item.getAuthor(), item.getDescription(), item.getCreates())
                    );
               } else {
                   System.out.println("This ITEM does not exist");
               }
           }
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
        DeleteItem(int key, String name) {
            super(key, name);
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
            task.setId(Long.valueOf(id));
            tracker.delete(task);
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
        FindByNameItem(int key, String name) {
            super(key, name);
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
            task.setAuthor(name);
            if (tracker.findByName(name) != null) {
                System.out.println(name);
            } else {
                System.out.println("This Name does not exist");
            }
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
    EditItem(int key, String name) {
        super(key, name);
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
        task.setId(Long.valueOf(id));
        tracker.update(task);
        if (tracker.findById(Integer.valueOf(id)) != null) {
            System.out.println(name);
            System.out.println(desc);
            System.out.println(create);
        } else {
            System.out.println("This ID does not exist");
        }
    }
}