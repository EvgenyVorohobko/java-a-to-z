package by.vorokhobko.Collections_Framework;

import java.util.Collection;
import java.util.Iterator;

/**
 * CollectionExample.
 *
 * Class CollectionExample determines the performance of the collections part 005_Lite, lesson 1.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 01.06.2017.
 * @version 1.
 */
public class CollectionExample {
    /**
     * The method add element in collections.
     * @param collection - collection.
     * @param amount - amount.
     * @return tag.
     */
    public long addCollection(Collection<String> collection, int amount) {
        String[] array = new String[amount];
        long start = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            collection.add("qwerty" + i);
        }
        long timeWorkCode = System.currentTimeMillis() - start;
        return timeWorkCode;
    }
    /**
     * The method delete element in collections.
     * @param collection - collection.
     * @param amount - amount.
     * @return tag.
     */
    public long deleteCollection(Collection<String> collection, int amount) {
        long start = System.currentTimeMillis();
        Iterator<String> iter = collection.iterator();
        while (iter.hasNext()) {
            iter.next();
            iter.remove();
        }
        long timeWorkCode = System.currentTimeMillis() - start;
        return timeWorkCode;
    }
}