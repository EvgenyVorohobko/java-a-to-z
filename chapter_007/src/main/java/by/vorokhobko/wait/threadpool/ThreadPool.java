package by.vorokhobko.wait.threadpool;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * ThreadPool.
 *
 * Class ThreadPool implementation Executor and realization ThreadPool for 007, lesson 4.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 05.10.2017.
 * @version 1.
 */
public class ThreadPool implements Executor {
    /**
     * The class field.
     */
    private final BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
    /**
     * The class field.
     */
    private boolean stop = true;
    /**
     * The class field.
     */
    private ArrayList<Double> list = new ArrayList<>();
    /**
     * Add constructor.
     * @param nThread - nThread.
     */
    public ThreadPool(int nThread) {
        for (int i = 0; i < nThread; i++) {
            new Thread(new TaskWorker()).start();
        }
    }
    /**
     * The method override method execute class Executor.
     * @param command - command.
     */
    @Override
    public void execute(Runnable command) {
        if (stop) {
            queue.offer(command);
        }
    }
    /**
     * The method field stop change, and stop program.
     */
    public void shutDown() {
        stop = false;
    }
    /**
     * The method add elements in ArrayList.
     * @param work - work.
     * @return tag.
     */
    public ArrayList<Double> add(Work work) {
        for (int i = 0; i < 15000; i++) {
            this.list.add(work.count(i));
        }
        return this.list;
    }
    /**
     * TaskWorker.
     *
     * Class TaskWorker auxiliary for class ThreadPool for 007, lesson 4.
     * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
     * @since 05.10.2017.
     * @version 1.
     */
    private class TaskWorker implements Runnable {
        /**
         * The method override method run.
         */
        @Override
        public void run() {
            while (stop) {
                Runnable nextTask = queue.poll();
                if (nextTask != null) {
                    nextTask.run();
                }
            }
        }
    }
}