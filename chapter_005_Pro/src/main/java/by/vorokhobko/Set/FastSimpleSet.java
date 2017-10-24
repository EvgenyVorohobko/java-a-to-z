package by.vorokhobko.set;

import java.util.ArrayList;
import java.util.List;

/**
 * FastSimpleSet.
 *
 * Class FastSimpleSet create fast add element in set 005_Pro, lesson 4.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 14.07.2017.
 * @version 1.
 * @param <E>.
 */
public class FastSimpleSet<E> {
    /**
     * The class field.
     */
    private List<E> list;
    /**
     * Add constructor.
     */
    public FastSimpleSet() {
        this.list = new ArrayList<>();
    }
    /**
     * Add objects in set.
     * @param element - element.
     */
    public void add(E element) {
        determinesPositionElement(element, this.list, 0, list.size());
    }
    /**
     * Get object.
     * @param index - index.
     * @return tag.
     */
    public E get(int index) {
        return list.get(index);
    }
    /**
     * Get size.
     * @return tag.
     */
    public int size() {
        return list.size();
    }
    /**
     * Method determines position elements in set.
     * @param element - element.
     * @param newList - newList.
     * @param start - start.
     * @param finish - finish.
     */
    private void determinesPositionElement(E element, List<E> newList, int start, int finish) {
        int middle = start - (start - finish) / 2;
        if (start == finish) {
            list.add(element);
        }
        if (start < finish) {
            if (element.hashCode() < newList.get(middle).hashCode()) {
                addElement(element);
            } else if (element.hashCode() > newList.get(middle).hashCode()) {
                addElement(element);
            }
        }
    }
    /**
     * Add objects in list.
     * @param element - element.
     */
    private void addElement(E element) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).hashCode() > element.hashCode()) {
                list.add(i, element);
                break;
            } else if (list.get(i).hashCode() == element.hashCode()) {
                System.out.println("This element " + element + " have in set!");
            }
        }
    }
}