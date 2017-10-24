package by.vorokhobko.wait.threadpool;

/**
 * Lock.
 *
 * Class Lock implement own locking mechanism for 007, lesson 4.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru.
 * @since 05.10.2017.
 * @version 1.
 */
public class Lock {
    /**
     * The main method.
     * @param args - args.
     */
    public static void main(String[] args) {
        int value = 1;
        for (int i = value; i < 10; i++) {
            Object object = new Object();
            Thread thread = new Thread(new WaitThread(object, value));
            thread.start();
            try {
                System.out.println("mainThread sleeping");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (object) {
                value++;
                object.notify();
                System.out.println("mainThread notify " + value);
            }
        }
    }
    /**
     * WaitThread.
     *
     * Class WaitThread auxiliary for class Lock for 007, lesson 4.
     * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
     * @since 10.10.2017.
     * @version 1.
     */
    private static class WaitThread implements Runnable {
        /**
         * The class field.
         */
        private Object object;
        /**
         * The class field.
         */
        private int value;
        /**
         * Add constructor.
         * @param object - object.
         * @param value - value.
         */
        private WaitThread(Object object, int value) {
            this.object = object;
            this.value = value;
        }
        /**
         * The method override method run.
         */
        @Override
        public void run() {
            System.out.println("start firstThread...");
            synchronized (this.object) {
                if (this.value != 0) {
                    try {
                        object.wait();
                        System.out.println("firstThread running again");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}