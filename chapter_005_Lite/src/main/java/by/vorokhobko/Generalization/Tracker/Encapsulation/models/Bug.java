package by.vorokhobko.Generalization.Tracker.Encapsulation.models;

/**
 * BUG.
 *
 * Class BUG looking for and error correction bugs in the application part 002, lesson 3.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 24.02.2017.
 * @version 1.
 */

public class Bug extends Item {
    /**
     * Create constructor.
     * Add Bug.
     * @param name - name.
     * @param desc - desc.
     * @param create - create.
     */
    public Bug(String name, String desc, long create) {
        super(name, desc, create);
    }
}