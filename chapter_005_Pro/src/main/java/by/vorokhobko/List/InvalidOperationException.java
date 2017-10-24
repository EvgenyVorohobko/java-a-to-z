package by.vorokhobko.list;

/**
 * InvalidOperationException.
 *
 * Class InvalidOperationException for class DynamicStack 005_Pro, lesson 3.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 27.06.2017.
 * @version 1.
 */
public class InvalidOperationException extends Throwable {
    /**
     * Create an overloaded constructor.
     * Add InvalidOperationException.
     * @param ioe - ioe.
     */
    public InvalidOperationException(String ioe) {
        super(ioe);
    }
}