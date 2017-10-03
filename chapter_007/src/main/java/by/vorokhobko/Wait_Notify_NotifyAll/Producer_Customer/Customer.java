package by.vorokhobko.Wait_Notify_NotifyAll.Producer_Customer;

import java.util.concurrent.BlockingQueue;

/**
 * Customer.
 *
 * Class Customer one part implemented template customer for 007, lesson 4.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 03.10.2017.
 * @version 1.
 */
public class Customer implements Runnable {
    /**
     * The class field.
     */
    private final BlockingQueue queue;
    /**
     * Add constructor.
     * @param queue - BlockingQueue.
     */
    public Customer(BlockingQueue queue) {
        this.queue = queue;
    }
    /**
     * The method override method run.
     */
    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Customer " + queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}