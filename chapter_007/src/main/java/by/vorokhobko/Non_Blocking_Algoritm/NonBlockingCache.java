package by.vorokhobko.Non_Blocking_Algoritm;

import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;

/**
 * NonBlockingCache.
 *
 * Class NonBlockingCache valid non-blocking cache for 007, lesson 5.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 11.10.2017.
 * @version 1.
 * @param <E>.
 */
public class NonBlockingCache<E extends User> {
    /**
     * The class field.
     */
    private ConcurrentHashMap<Integer, E> map = new ConcurrentHashMap<>();
    /**
     * The method adds a data to map.
     * @param model - model.
     */
    public void add(User model) {
        this.map.putIfAbsent(model.getKey(), (E) model);
    }
    /**
     * The method should delete the data to map.
     * @param key - key.
     */
    public void remove(int key) {
        if (this.map.containsKey(key)) {
            this.map.remove(key);
        } else {
            System.out.println("There is no such element.");
        }
    }
    /**
     * The method needs to replace the data to map.
     * @param model - model.
     */
    public void update(User model) {
        this.map.computeIfPresent(model.getKey(), new BiFunction<Integer, E, E>() {
            @Override
            public E apply(Integer integer, E element) {
                if (model.getVersion() == element.getVersion()) {
                    element.setValue(model.getValue());
                } else {
                    try {
                        throw new OplimisticException("There is no such element.");
                    } catch (OplimisticException exception) {
                        exception.printStackTrace();
                    }
                }
                return element;
            }
        });
    }
    /**
     * The method size.
     * @return tag.
     */
    public int size() {
        return map.size();
    }
    /**
     * The method return element.
     * @param key - key.
     * @return tag.
     */
    public E get(int key) {
        return map.get(key);
    }
}