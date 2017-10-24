package by.vorokhobko.wait.threadpool;

/**
 * SingleThreadPool.
 *
 * Class SingleThreadPool for comparison with the class StartUI for 007, lesson 4.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru.
 * @since 05.10.2017.
 * @version 1.
 */
public class SingleThreadPool {
    /**
     * The class field.
     */
    private static Work work = new Work();
    /**
     * The main method.
     * @param args - args.
     */
    public static void main(String[] args) {
        long start = System.nanoTime();

        double value = 0;
        for (int i = 0; i < 15000; i++) {
            value += work.count(i);
        }

        System.out.format("Executed by %d s, value : %f",
                (System.nanoTime() - start) / (1000_000_000),
                value);
    }
}