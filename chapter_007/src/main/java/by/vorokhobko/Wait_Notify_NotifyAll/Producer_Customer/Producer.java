package by.vorokhobko.Wait_Notify_NotifyAll.Producer_Customer;

import java.util.concurrent.BlockingQueue;

/**
 * Producer.
 *
 * Class Producer one part implemented template customer for 007, lesson 4.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 03.10.2017.
 * @version 1.
 */
public class Producer implements Runnable {
    /**
     * The class field.
     */
    private final BlockingQueue queue;
    /**
     * Add constructor.
     * @param queue - BlockingQueue.
     */
    public Producer(BlockingQueue queue) {
        this.queue = queue;
    }
    /**
     * The method override method run.
     */
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println("Producer " + i);
                queue.put(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}