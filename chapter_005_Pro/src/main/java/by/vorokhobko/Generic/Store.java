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
public class Store<E extends Base> {
    /**
     * The class field.
     */
    private SimpleList<E> simple;
    /**
     * Create constructor.
     * @param size - size.
     */
    public Store(int size) {
        this.simple = new SimpleList<>(size);
    }
    /**
     * Add getter Simple.
     * @return tag.
     */
    public SimpleList<E> getSimple() {
        return simple;
    }
    /**
     * Method add.
     * @param value - value.
     */
    void add(E value) {
        simple.add(value);
    }
    /**
     * Method update.
     * @param value - value.
     * @param index - index.
     */
    void update(E value, int index) {
        simple.update(value, index);
    }
    /**
     * Method remove.
     * @param value - value.
     */
    void remove(E value) {
        simple.delete(value);
    }
}