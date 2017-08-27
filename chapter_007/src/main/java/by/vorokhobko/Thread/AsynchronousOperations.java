package by.vorokhobko.Thread;

/**
 * AsynchronousOperations.
 *
 * Class AsynchronousOperations determines the number of spaces in the text for 007, lesson 1.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru.
 * @since 19.08.2017.
 * @version 1.
 */
public class AsynchronousOperations {
    /**
     * The class field.
     */
    private static final String TEXT =
            "I was fortunate indeed to have worked with a fantastic team "
                    + "on the design and implementation of the concurrency features "
                    + "added to the Java platform in Java 5.0 and Java 6. Now this same "
                    + "team provides the best explanation yet of these new features, "
                    + "and of concurrency in general. Concurrency is no longer a subject "
                    + "for advanced users only. Every Java developer should read this book.";

    /**
     * The method show count symbols and spaces in the text.
     * @param args - args.
     */
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println("Start program.");
        Thread showSymbol = new Thread(new CountChar());
        showSymbol.start();
        try {
            while (!Thread.currentThread().isInterrupted() && showSymbol.isAlive()) {
                showSymbol.interrupt();
                showSymbol.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long timeWorkCode = System.currentTimeMillis() - start;
        System.out.println("Finish program for " + timeWorkCode);
    }

    /**
     * Internal class which find element in the text.
     */
    private static class CountChar implements Runnable {
        @Override
        public void run() {
            int count = 0;
            if (Thread.currentThread().isInterrupted()) {
                return;
            }
            for (char element : TEXT.toCharArray()) {
                count++;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(count);
        }
    }
}