package by.vorokhobko.tracker.templates;

import by.vorokhobko.tracker.Input;
import by.vorokhobko.tracker.UserAction;
import by.vorokhobko.tracker.encapsulation.start.Tracker;

/**
 * BaseAction.
 *
 * Class BaseAction abstract class for MenuTracker 002, lesson 7.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 05.05.2017.
 * @version 1.
 */
public abstract class BaseAction implements UserAction {
    /**
     * The class field.
     */
    private String name;
    /**
     * The class field.
     */
    private int key;
    /**
     * Add getter Name.
     * @return tag.
     */
    public String getName() {
        return this.name;
    }
    /**
     * Add getter key.
     * @return tag.
     */
    public int getKey() {
        return this.key;
    }
    /**
     * Сreate the class constructor BaseAction.
     * @param name - name.
     * @param key - key.
     */
    public BaseAction(int key, String name) {
        this.name = name;
        this.key = key;
    }
    /**
     * Method determining the number action.
     * @return tag.
     */
    public int key() {
        return this.key;
    }
    /**
     * Abstract method determining work MenuTracker.
     * @param input - input.
     * @param tracker - tracker.
     */
    public abstract void execute(Input input, Tracker tracker);
    /**
     * Method determining communication with the user.
     * @return tag.
     */
    public String info() {
        return String.format("%s. %s", this.key(), this.name);
    }
}