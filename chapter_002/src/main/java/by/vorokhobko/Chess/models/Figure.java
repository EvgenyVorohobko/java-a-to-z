package by.vorokhobko.Chess.models;

import by.vorokhobko.Chess.exceptions.ImposibleMoveException;

/**
 * Figure.
 *
 * Class Figure abstract class for Chess 002, lesson test.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 13.05.2017.
 * @version 1.
 */
public abstract class Figure {
    /**
     * The class field.
     */
    private final Cell position;
    /**
     * Сreate the class constructor Figure.
     * @param position - position.
     */
    public Figure(Cell position) {
        this.position = position;
    }
    /**
     * Add getter position.
     * @return tag.
     */
    public Cell getPosition() {
        return this.position;
    }
    public abstract Cell[] way(Cell dist) throws ImposibleMoveException;
}