package by.vorokhobko.Wait_Notify_NotifyAll.Thread_Pool;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * StartUI.
 *
 * Class StartUI run application for 007, lesson 4.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru.
 * @since 05.10.2017.
 * @version 1.
 */
public class StartUI {
    /**
     * The main method.
     * @param args - args.
     * @throws ExecutionException tag.
     * @throws InterruptedException tag.
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPool threadPool = new ThreadPool(8);
        Work work = new Work();
        long start = System.nanoTime();

        List<Double> list = threadPool.add(work);

        double value = 0;
        for (Double aDouble : list) {
            value += aDouble;
        }

        System.out.format("Executed by %d s, value : %f",
                (System.nanoTime() - start) / (1000_000_000),
                value);

        threadPool.shutDown();
    }
}