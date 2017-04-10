package by.vorokhobko.InnerClasses;

import by.vorokhobko.Polymorphism.Input;
import by.vorokhobko.Encapsulation.start.Tracker;

/**
 * UserAction.
 *
 * Class UserAction the interface for the program part 002, lesson 6.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 10.04.2017.
 * @version 1.
 */

public interface UserAction {
    /**
     * Сreate the class key.
     * @return tag.
     */
    int key();
    /**
     * Сreate the class execute.
     * @param input - input.
     * @param tracker - tracker.
     */
    void execute(Input input, Tracker tracker);
    /**
     * Сreate the class info.
     * @return tag.
     */
    String info();
}
