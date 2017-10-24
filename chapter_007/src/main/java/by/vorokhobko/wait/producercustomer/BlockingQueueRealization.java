package by.vorokhobko.wait.producercustomer;

import java.util.LinkedList;
import java.util.List;

/**
 * BlockingQueueRealization.
 *
 * Class BlockingQueueRealization realization BlockingQueue for 007, lesson 4.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 05.10.2017.
 * @version 1.
 */
public class BlockingQueueRealization {
    /**
     * The class field.
     */
    private List queue = new LinkedList<>();
    /**
     * The class field.
     */
    private int limit = 1;
    /**
     * The class field.
     */
    private int count;
    /**
     * Add constructor.
     * @param count - count.
     */
    public BlockingQueueRealization(int count) {
        this.count = count;
    }
    /**
     * Realization the method put BlockingQueue.
     * @param object - object.
     * @throws InterruptedException tag.
     */
    public synchronized void put(Object object) throws InterruptedException {
        while (this.queue.size() == this.limit) {
            wait();
        }
        if (this.queue.size() == 0) {
            notifyAll();
        }
        this.queue.add(object);
    }
    /**
     * Realization the method take BlockingQueue.
     * @return tag.
     * @throws InterruptedException tag.
     */
    public synchronized Object take() throws InterruptedException {
        while (this.queue.size() == 0) {
            wait();
        }
        if (this.queue.size() == this.limit) {
            notifyAll();
        }
        return this.queue.remove(0);
    }
}