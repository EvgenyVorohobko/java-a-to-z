package by.vorokhobko.nonblockingalgoritm;

/**
 * OplimisticException.
 *
 * Class OplimisticException for processing Exception part 007, lesson 5.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 11.10.2017.
 * @version 1.
 */
public class OplimisticException extends Exception {
    /**
     * Create an overloaded constructor.
     * Add OplimisticException.
     * @param text - text.
     */
    public OplimisticException(String text) {
        super(text);
    }
}