package by.vorokhobko.Chess.exceptions;
/**
 * OccupiedWayException.
 *
 * Class OccupiedWayException for processing Exception part 002, lesson test.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 13.05.2017.
 * @version 1.
 */
public class OccupiedWayException extends Exception {
    /**
     * Create an overloaded constructor.
     * Add OccupiedWayException.
     * @param owe - owe.
     */
    public OccupiedWayException(String owe) {
        super(owe);
    }
}