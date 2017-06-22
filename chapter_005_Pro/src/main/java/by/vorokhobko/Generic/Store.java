package by.vorokhobko.Generic;

/**
 * Store.
 *
 * Class Store for the program part 005_Pro, lesson 2.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 21.06.2017.
 * @version 1.
 * @param <E>.
 */
public interface Store<E extends Base> {
    /**
     * Method add.
     * @param value - value.
     */
    void add(E value);
    /**
     * Method update.
     * @param value - value.
     * @param index - index.
     */
    void update(E value, int index);
    /**
     * Method remove.
     * @param value - value.
     */
    void remove(E value);
}