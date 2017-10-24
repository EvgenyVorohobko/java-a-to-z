package by.vorokhobko.map;

/**
 * Book.
 *
 * Class Book the interface for the Reference, lesson 5.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 17.07.2017.
 * @version 1.
 * @param <K> - key.
 * @param <V> - value.
 */
public interface Book<K, V> extends Iterable<V> {
    /**
     * Сreate the method insert element in Book.
     * @param key - key.
     * @param value - value.
     * @return tag.
     */
    boolean insert(K key, V value);
    /**
     * Сreate the method delete element in Book.
     * @param key - key.
     * @return tag.
     */
    boolean delete(K key);
    /**
     * Сreate the method get key element in Book.
     * @param key - key.
     * @return tag.
     */
    V get(K key);
    /**
     * Сreate the method size Book.
     * @return tag.
     */
    int size();
}