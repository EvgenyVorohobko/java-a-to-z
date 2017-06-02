package by.vorokhobko.Collections_Framework;

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
        List<String> arrayStart = new LinkedList<>();
        System.out.println("Добавление элементов в коллекцию LinkedList занимает "
                + ex.addCollection(arrayStart, AMOUNT) + " миллисекунд(-ы).");
        List<String> arrayFinish = new LinkedList<>();
        System.out.println("Удаление элементов из коллекции LinkedList занимает "
                + ex.deleteCollection(arrayFinish, AMOUNT) + " миллисекунд(-ы).");
    }
    /**
     * Test.
     */
    @Test
    public void whenAddElementInTreeSet() {
        TreeSet<String> arrayStart = new TreeSet<>();
        System.out.println("Добавление элементов в коллекцию TreeSet занимает "
                + ex.addCollection(arrayStart, AMOUNT) + " миллисекунд(-ы).");
        TreeSet<String> arrayFinish = new TreeSet<>();
        System.out.println("Удаление элементов из коллекции TreeSet занимает "
                + ex.deleteCollection(arrayFinish, AMOUNT) + " миллисекунд(-ы).");
    }
    /**
     * Test.
     */
    @Test
    public void whenAddAndDeleteElementInArrayList() {
        List<String> arrayStart = new ArrayList<>();
        System.out.println("Добавление элементов в коллукцию ArrayList занимает "
                + ex.addCollection(arrayStart, AMOUNT) + " миллисекунд(-ы).");
        List<String> arrayFinish = new ArrayList<>();
        System.out.println("Удаление элементов из коллекции ArrayList занимает "
                + ex.deleteCollection(arrayFinish, AMOUNT) + " миллисекунд(-ы).");
    }
}