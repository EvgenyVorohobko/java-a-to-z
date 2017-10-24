package by.vorokhobko.chess.start;

import by.vorokhobko.chess.exceptions.ImposibleMoveException;
import by.vorokhobko.chess.models.Cell;
import by.vorokhobko.chess.models.Figure;

/**
 * Bishop.
 *
 * Class Bishop makes the class Figure wider in the implementation part 002, lesson test.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 13.05.2017.
 * @version 1.
 */
public class Bishop extends Figure {
    /**
     * The class field.
     */
    private Cell[] distance;
    /**
     * Сreate name in the method Bishop.
     * @param position - position.
     */
    public Bishop(Cell position) {
        super(position);
    }
    /**
     * The method way, inherited from class Figure.
     * @param dist - dist.
     * @return tag.
     * @throws ImposibleMoveException tag.
     */
    public Cell[] way(Cell dist) throws ImposibleMoveException {
        int distX = Math.abs(dist.getX() - getPosition().getX());
        int distY = Math.abs(dist.getY() - getPosition().getY());
        if (distX == distY) {
            distance = moveFigure(dist);
        } else {
            throw new ImposibleMoveException("Bishop do not move that.");
        }
        return distance;
    }
    /**
     * The method a listing of all figures.
     * @param dist - dist.
     * @return tag.
     */
    public Figure clone(Cell dist) {
        return new Bishop(dist);
    }
}