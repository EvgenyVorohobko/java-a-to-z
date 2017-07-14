package by.vorokhobko.Set;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * SimpleSetLinkedList.
 *
 * Class SimpleSetLinkedList create the Set for 005_Pro, lesson 4.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 05.07.2017.
 * @version 1.
 * @param <E>.
 */
public class SimpleSetLinkedList<E> implements Iterable {
    /**
     * The class field.
     */
    private List<E> list;
    /**
     * Add constructor.
     */
    public SimpleSetLinkedList() {
        this.list = new LinkedList<>();
    }
    /**
     * The class field.
     */
    private int count = 0;
    /**
     * Add objects in SimpleSetLinkedList.
     * @param newElement - newElement.
     */
    public void addList(E newElement) {
        if (list.size() > 1) {
            for (int i = 0; i < list.size(); i++) {
                if ((getElement(i).equals(newElement))) {
                    System.out.println("This element have in list!");
                }
            }
            list.add(newElement);
        } else {
            list.add(newElement);
        }
        sortedList();
    }
    /**
     * Method sort element in list by hashCode.
     * @return tag.
     */
    public List<E> sortedList() {
        Collections.sort(list, (elementOne, elementTwo) -> Integer.compare(elementOne.hashCode(), elementTwo.hashCode()));
        return list;
    }
    /**
     * Get object in SimpleSetLinkedList.
     * @param index - index.
     * @return tag.
     */
    public E getElement(int index) {
        return list.get(index);
    }
    /**
     * Get size SimpleSetLinkedList.
     * @return tag.
     */
    public int size() {
        return list.size();
    }
    /**
     * Override iterator constructor.
     * @return tag.
     */
    @Override
    public Iterator iterator() {
        return new IteratorForLinkedSet<E>();
    }
    /**
     * IteratorForLinkedSet.
     *
     * Class IteratorForLinkedSet create own implementation of the iterator.
     * @param <E>.
     */
    public class IteratorForLinkedSet<E> implements Iterator {
        /**
         * Override method hasNext.
         * @return tag.
         */
        @Override
        public boolean hasNext() {
            boolean isNeedSave = false;
            if (list.size() > count) {
                isNeedSave = true;
            }
            return isNeedSave;
        }
        /**
         * Override method next.
         * @return tag.
         */
        @Override
        public Object next() {
            if (hasNext()) {
                return list.get(count++);
            } else {
                throw new NoSuchElementException();
            }
        }
    }
}