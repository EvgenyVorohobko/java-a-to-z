package by.vorokhobko.synchronizmonitore;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * Count.
 *
 * Class Count multithreaded counter for 007, lesson 3.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 28.08.2017.
 * @version 1.
 */
@ThreadSafe
public class Count {
    /**
     * The class field.
     */
    private int count = 0;
    /**
     * The method add element in a field of a class.
     * @param value - value.
     * @return tag.
     */
    public synchronized int add(int value) {
        this.count += value;
        return count;
    }
    /**
     * The method increment counterA and counterB.
     * @param counterA - counterA.
     * @param counterB - counterB.
     * @return tag.
     */
    @GuardedBy("count")
    public int incremant(final Count counterA, final Count counterB) {
        synchronized (counterA) {
            synchronized (counterB) {
                return counterA.add(counterB.count);
            }
        }
    }

    /**
     * A class that implements class Runnable.
     */
    public static final class RunnableCount implements Runnable {
        /**
         * The class field.
         */
        private final Count counterA;
        /**
         * The class field.
         */
        private final Count counterB;
        /**
         * Add constructor.
         * @param counterA - counterA.
         * @param counterB - counterB.
         */
        public RunnableCount(final Count counterA, final Count counterB) {
            this.counterA = counterA;
            this.counterB = counterB;
        }
        /**
         * Implements method run.
         */
        @Override
        public void run() {
            counterA.incremant(counterA, counterB);
        }
    }

    /**
     * The method show count element in Threads.
     * @param args - args.
     * @throws InterruptedException tag.
     */
    public static void main(String[] args) throws InterruptedException {
        Count counter = new Count();
        counter.add(1);
        counter.add(2);
        Thread threadA = new Thread(new RunnableCount(counter, counter));
        Thread threadB = new Thread(new RunnableCount(counter, counter));

        threadA.start();
        threadB.start();
        threadA.join();
        threadB.join();
        System.out.println(counter.count);
    }
}