package by.vorokhobko.collectframework;

import org.junit.Test;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

/**
 * Test.
 *
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @version 1.
 * @since 02.06.2017.
 */
public class CollectionExampleTest {
    /**
     * The class field.
     */
    private CollectionExample ex = new CollectionExample();
    /**
     * The class field.
     */
    private static final int AMOUNT = 1000000;
    /**
     * Test.
     */
    @Test
    public void whenAddAndDeleteElementInLinkedList() {
        List<String> array = new LinkedList<>();
        System.out.println("Добавление элементов в коллекцию LinkedList занимает "
                + ex.addCollection(array, AMOUNT) + " миллисекунд(-ы).");
        System.out.println("Удаление элементов из коллекции LinkedList занимает "
                + ex.deleteCollection(array, AMOUNT) + " миллисекунд(-ы).");
    }
    /**
     * Test.
     */
    @Test
    public void whenAddElementInTreeSet() {
        TreeSet<String> array = new TreeSet<>();
        System.out.println("Добавление элементов в коллекцию TreeSet занимает "
                + ex.addCollection(array, AMOUNT) + " миллисекунд(-ы).");
        System.out.println("Удаление элементов из коллекции TreeSet занимает "
                + ex.deleteCollection(array, AMOUNT) + " миллисекунд(-ы).");
    }
    /**
     * Test.
     */
    @Test
    public void whenAddAndDeleteElementInArrayList() {
        List<String> array = new ArrayList<>();
        System.out.println("Добавление элементов в коллекцию ArrayList занимает "
                + ex.addCollection(array, AMOUNT) + " миллисекунд(-ы).");
        System.out.println("Удаление элементов из коллекции ArrayList занимает "
                + ex.deleteCollection(array, AMOUNT) + " миллисекунд(-ы).");
    }
}