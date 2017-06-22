package by.vorokhobko.Generic;

/**
 * AbstractStore.
 *
 * Class AbstractStore for the program part 005_Pro, lesson 2.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 22.06.2017.
 * @version 1.
 * @param <E>.
 */
public class AbstractStore<E extends Base> implements Store<E> {
    /**
     * The class field.
     */
    private SimpleList<E> simple;
    /**
     * Create constructor.
     * @param size - size.
     */
    public AbstractStore(int size) {
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
    public void add(E value) {
        simple.add(value);
    }
    /**
     * Method update.
     * @param value - value.
     * @param index - index.
     */
    public void update(E value, int index) {
        simple.update(value, index);
    }
    /**
     * Method remove.
     * @param value - value.
     */
    public void remove(E value) {
        simple.delete(value);
    }
}
