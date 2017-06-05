package by.vorokhobko.Generalization.Tracker.Templates;

import by.vorokhobko.Generalization.Tracker.AbstractClasses.Input;
import by.vorokhobko.Generalization.Tracker.AbstractClasses.UserAction;
import by.vorokhobko.Generalization.Tracker.Encapsulation.start.Tracker;

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
     * Сreate the class constructor BaseAction.
     * @param name - name.
     */
    public BaseAction(String name) {
        this.name = name;
    }
    /**
     * Method determining the number action.
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
     * Method determining communication with the user.
     * @return tag.
     */
    public String info() {
        return String.format("%s. %s", this.key(), this.name);
    }
}