package by.vorokhobko.Monitore_Synchronizy;

import net.jcip.annotations.ThreadSafe;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * DynamicArrayList.
 *
 * Class DynamicArrayList create the containers ArrayList 007, lesson 3.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 03.09.2017.
 * @version 1.
 * @param <E>.
 */
@ThreadSafe
public class DynamicArrayList<E> implements Iterable {
    /**
     * The class field.
     */
    private static final int INIT_ARRAY = 10;
    /**
     * The class field.
     */
    private Object[] container = new Object[INIT_ARRAY];
    /**
     * The class field.
     */
    private int count = 0;
    /**
     * The class field.
     */
    private int index = 0;
    /**
     * Add constructor.
     * @param size - size.
     */
    public DynamicArrayList(int size) {
        this.container = new Object[size];
    }
    /**
     * Main method.
     * @param args - args.
     */
    public static void main(String[] args) {
        try {
            DynamicArrayList<String> list = new DynamicArrayList<>(1);
            Iterator<String> iter = list.iterator();
            Thread arrayList1 = new Thread(new List(list, iter));
            Thread arrayList2 = new Thread(new List(list, iter));
            arrayList1.start();
            arrayList2.start();
            arrayList1.join();
            arrayList2.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    /**
     * List.
     *
     * Class List implements Runnable.
     */
    public static class List implements Runnable {
        /**
         * The class field.
         */
        private final DynamicArrayList<String> list;
        /**
         * The class field.
         */
        private final Iterator<String> iter;
        /**
         * Add constructor.
         * @param list - list.
         * @param iter - iter.
         */
        public List(DynamicArrayList<String> list, Iterator<String> iter) {
            this.list = list;
            this.iter = iter;
        }
        @Override
        public void run() {
            synchronized (this.list) {
                synchronized (this.iter) {
                    list.add("object 1");
                    list.add("object 2");
                    list.add("object 3");
                    System.out.println(iter.hasNext());
                    System.out.println(list.get(1));
                    if (iter.hasNext()) {
                        iter.remove();
                    }
                    System.out.println(list.get(0));
                }
            }
        }
    }
    /**
     * Add generic E in objects.
     * @param value - value.
     */
    public void add(E value) {
        if (count == container.length - 1) {
            resize(container.length * 3 / 2 + 1);
        }
        this.container[count++] = value;
    }
    /**
     * Helper method to add an element.
     * @param size - size.
     */
    public void resize(int size) {
        Object[] newContainer = new Object[size];
        System.arraycopy(container, 0, newContainer, 0, count);
        container = newContainer;
    }
    /**
     * Get generic E in position.
     * @param index - index.
     * @return tag.
     */
    public E get(int index) {
        return (E) this.container[index];
    }
    /**
     * Override iterator constructor.
     * @return tag.
     */
    @Override
    public Iterator<E> iterator() {
        return new ListArrayIterator<E>();
    }
    /**
     * MyIterator.
     *
     * Class MyIterator create own implementation of the iterator.
     * @param <E>.
     */
    public class ListArrayIterator<E> implements Iterator<E> {
        /**
         * Override method hasNext.
         * @return tag.
         */
        @Override
        public boolean hasNext() {
            boolean isNeedSave = false;
            if (container.length > count) {
                isNeedSave = true;
            }
            return isNeedSave;
        }
        /**
         * Override method next.
         * @return tag.
         */
        @Override
        public E next() throws NoSuchElementException {
            if (hasNext()) {
                return (E) container[count++];
            } else {
                throw new NoSuchElementException("The objects in the array is no more!");
            }
        }
        /**
         * Override method remove.
         */
        @Override
        public void remove() {
            for (int i = index; i < count; i++) {
                container[i] = container[i + 1];
            }
            container[count] = null;
            count--;
        }
    }
}