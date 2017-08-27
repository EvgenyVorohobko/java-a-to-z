package by.vorokhobko.JMM;

/**
 * NotSynchronize.
 *
 * Class NotSynchronize show race condition in Multithreading for 007, lesson 2.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru.
 * @since 19.08.2017.
 * @version 1.
 */
public class NotSynchronize {
    /**
     * The class Base.
     */
    private static class Base {
        /**
         * The method show text in square brackets.
         * @param text - text.
         */
        public void call(String text) {
            System.out.print("[" + text);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Прервано");
            }
            System.out.println("]");
        }
    }
    /**
     * The class Call.
     */
    private static class Call implements Runnable {
        /**
         * The class field.
         */
        private String text;
        /**
         * The class field.
         */
        private Base target;
        /**
         * The class field.
         */
        private Thread thread;
        /**
         * Add constructor.
         * @param target - target.
         * @param text - text.
         */
        private Call(Base target, String text) {
            this.text = text;
            this.target = target;
            this.thread = new Thread(this);
            thread.start();
        }
        /**
         * The method override run.
         */
        @Override
        public void run() {
            target.call(text);
        }
    }
    /**
     * The method main.
     * @param args - args.
     */
    public static void main(String[] args) {
        Base target = new Base();
        Call call1 = new Call(target, "Добро пожаловать");
        Call call2 = new Call(target, "в этот ужастный");
        Call call3 = new Call(target, "несинхронизированный");
        Call call4 = new Call(target, "мир");
        try {
            call1.thread.join();
            call2.thread.join();
            call3.thread.join();
            call4.thread.join();
        } catch (InterruptedException e) {
            System.out.println("Прервано");
        }
    }
}