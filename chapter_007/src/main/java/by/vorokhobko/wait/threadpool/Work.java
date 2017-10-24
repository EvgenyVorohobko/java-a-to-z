package by.vorokhobko.wait.threadpool;

/**
 * Work.
 *
 * Class Work started class for ThreadPool for 007, lesson 4.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 05.10.2017.
 * @version 1.
 */
public class Work {
    /**
     * The method calculates element.
     * @param count - count.
     * @return tag.
     */
    public Double count(double count) {
        for (int i = 0; i < 10000; i++) {
            count = count + Math.tan(count);
        }
        return count;
    }
}