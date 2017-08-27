package by.vorokhobko.Thread;

/**
 * WaitingForOutput.
 *
 * Class WaitingForOutput determines the number of spaces in the text for 007, lesson 1.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru.
 * @since 19.08.2017.
 * @version 1.
 */
public class WaitingForOutput {
    /**
     * The class field.
     */
    private static final char SPACE = ' ';
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
        Thread showSpace = new Thread(new Space());
        Thread showSymbol = new Thread(new Symbol());
        showSpace.start();
        showSymbol.start();
        try {
            showSpace.join();
            showSymbol.join();
            long timeWorkCode = System.currentTimeMillis() - start;
            if (timeWorkCode > 1000) {
                showSpace.interrupt();
                showSymbol.interrupt();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finish program.");
    }

    /**
     * Internal class which find space in the text.
     */
    private static class Space implements Runnable {
        @Override
        public void run() {
            int space = 0;
            if (Thread.currentThread().isInterrupted()) {
                return;
            }
            for (char element : TEXT.toCharArray()) {
                if (SPACE == element) {
                    space++;
                }
            }
            System.out.println("Spaces in the text: " + space + ".");
        }
    }

    /**
     * Internal class which find symbol in the text.
     */
    private static class Symbol implements Runnable {
        @Override
        public void run() {
            int symbol = 0;
            if (Thread.currentThread().isInterrupted()) {
                return;
            }
            for (char element : TEXT.toCharArray()) {
                if (SPACE != element) {
                    symbol++;
                }
            }
            System.out.println("Symbol in the text: " + symbol + ".");
        }
    }
}