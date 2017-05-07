package by.vorokhobko.Templates;

import by.vorokhobko.AbstractClasses.Input;
import by.vorokhobko.Encapsulation.start.Tracker;
import by.vorokhobko.AbstractClasses.UserAction;

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
     * Add getter Name.
     * @return tag.
     */
    public String getName() {
        return this.name;
    }
    /**
     * Add setter Name.
     * @param name - name.
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Сreate the class constructor BaseAction.
     * @param name - name.
     */
    public BaseAction(String name) {
        this.name = name;
    }
    /**
     * Abstract method determining the number action.
     * @return tag.
     */
    public abstract int key();
    /**
     * Abstract method determining work MenuTracker.
     * @param input - input.
     * @param tracker - tracker.
     */
    public abstract void execute(Input input, Tracker tracker);
    /**
     * Abstract method determining communication with the user.
     * @return tag.
     */
    public String info() {
        return String.format("%s. %s", this.key(), this.name);
    }
}