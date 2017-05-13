package by.vorokhobko.Chess.exceptions;
/**
 * ImposibleMoveException.
 *
 * Class ImposibleMoveException for processing Exception part 002, lesson test.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 13.05.2017.
 * @version 1.
 */
public class ImposibleMoveException extends Exception {
    /**
     * Create an overloaded constructor.
     * Add ImposibleMoveException.
     * @param ime - ime.
     */
    public ImposibleMoveException(String ime) {
        super(ime);
    }
}