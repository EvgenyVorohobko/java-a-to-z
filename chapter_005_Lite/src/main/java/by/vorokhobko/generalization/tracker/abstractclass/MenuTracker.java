package by.vorokhobko.generalization.tracker.abstractclass;

import by.vorokhobko.generalization.tracker.Encapsulation.models.Item;
import by.vorokhobko.generalization.tracker.Encapsulation.models.Task;
import by.vorokhobko.generalization.tracker.Encapsulation.start.Tracker;
import by.vorokhobko.generalization.tracker.Templates.BaseAction;

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
    private List<UserAction> actions = new ArrayList<>();

    /**
     * Сreate the class constructor MenuTracker.
     *
     * @param input   - input.
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
        this.actions.add(this.new AddItems("Add the new item"));
        this.actions.add(new MenuTracker.ShowItems("Show all items"));
        this.actions.add(new EditItem("Edit the item"));
        this.actions.add(this.new DeleteItem("Delete this item"));
        this.actions.add(this.new FindByNameItem("Find by name this item"));
    }

    /**
     * Сreate the method choice actions.
     *
     * @param key - key.
     */
    public void select(int key) {
        this.actions.get(key).execute(input, tracker);
    }

    /**
     * Сreate the method show actions.
     */
    public void show() {
        for (UserAction userAction : actions) {
            System.out.println(userAction.key() + "." + userAction.info());
        }
    }

    /**
     * Internal class which adds item with work the user.
     */
    private class AddItems extends BaseAction {
        /**
         * Сreate name in the method AddItems.
         *
         * @param name - name.
         */
        AddItems(String name) {
            super(name);
        }
        /**
         * Method determining the number action.
         * @return tag.
         */
        @Override
        public int key() {
            return actions.indexOf(this);
        }
        /**
         * The method execute, inherited from class UserAction.
         * @param input   - input.
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
    private class ShowItems extends BaseAction {
        /**
         * Сreate name in the method ShowItems.
         *
         * @param name - name.
         */
        ShowItems(String name) {
            super(name);
        }
        /**
         * Method determining the number action.
         * @return tag.
         */
        @Override
        public int key() {
            return actions.indexOf(this);
        }
        /**
         * The method execute, inherited from class UserAction.
         * @param input   - input.
         * @param tracker - tracker.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            List<Item> list = tracker.findAll();
            for (Item item : list) {
                System.out.println(
                        String.format("%s. %s", item.getId(), item.getName())
                );
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
        DeleteItem(String name) {
            super(name);
        }

        /**
         * Method determining the number action.
         *
         * @return tag.
         */
        @Override
        public int key() {
            return actions.indexOf(this);
        }
        /**
         * The method execute, inherited from class UserAction.
         * @param input   - input.
         * @param tracker - tracker.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please, enter the task's id: ");
            List<Item> list = tracker.findAll();
            for (Item item : list) {
                System.out.println(
                        String.format("%s. %s", item.getId(), item.getName())
                );
            }
            Item task = new Item();
            task.setId(id);
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
        FindByNameItem(String name) {
            super(name);
        }

        /**
         * Method determining the number action.
         * @return tag.
         */
        @Override
        public int key() {
            return actions.indexOf(this);
        }

        /**
         * The method execute, inherited from class UserAction.
         * @param input   - input.
         * @param tracker - tracker.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please, enter the task's name: ");
            List<Item> list = tracker.findByName(name);
            if (list.size() > 0) {
                for (Item item : list) {
                    System.out.println(
                            String.format("%s. %s", item.getId(), item.getName())
                    );
                }
            } else {
                System.out.println("There are no tasks in the program");
            }
        }
    }

    /**
     * Internal class which edit item with work the user.
     */
    public class EditItem extends BaseAction {
        /**
         * Сreate name in the method EditItem.
         * @param name - name.
         */
        EditItem(String name) {
            super(name);
        }
        /**
         * Method determining the number action.
         * @return tag.
         */
        @Override
        public int key() {
            return actions.indexOf(this);
        }
        /**
         * The method execute, inherited from class UserAction.
         * @param input   - input.
         * @param tracker - tracker.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            List<Item> list = tracker.findAll();
            for (Item item : list) {
                System.out.println(
                        String.format("%s. %s", item.getId(), item.getName())
                );
            }
            String id = input.ask("Please, enter the task's id: ");
            String name = input.ask("Please, enter the task's name: ");
            String desc = input.ask("Please, enter the task's desc: ");
            String create = input.ask("please, enter the task's time: ");
            Task task = new Task(name, desc, Long.parseLong(create));
            task.setId(id);
            tracker.update(task);
        }
    }
}