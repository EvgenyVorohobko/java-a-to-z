package by.vorokhobko.Chess.exceptions;
/**
 * FigureNotFoundException.
 *
 * Class FigureNotFoundException for processing Exception part 002, lesson test.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 13.05.2017.
 * @version 1.
 */
public class FigureNotFoundException extends Exception {
    /**
     * Create an overloaded constructor.
     * Add FigureNotFoundException.
     * @param fnfe - fnfe.
     */
    public FigureNotFoundException(String fnfe) {
        super(fnfe);
    }
}