package by.vorokhobko.Chess.start;

import by.vorokhobko.Chess.exceptions.ImposibleMoveException;
import by.vorokhobko.Chess.models.Cell;
import by.vorokhobko.Chess.models.Figure;
import by.vorokhobko.Chess.models.Type;

/**
 * King.
 *
 * Class King makes the class Figure wider in the implementation part 002, lesson test.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 15.05.2017.
 * @version 1.
 */
public class King extends Figure {
    /**
     * The class field.
     */
    private Cell[] distance;
    /**
     * Сreate name in the method King.
     * @param position - position.
     */
    public King(Cell position) {
        super(position);
    }
    /**
     * The method way, inherited from class Figure.
     * @param dist - dist.
     * @return tag.
     * @throws ImposibleMoveException tag.
     */
    public Cell[] way(Cell dist) throws ImposibleMoveException {
        int passX = Math.abs(dist.getX() - position.getX());
        int passY = Math.abs(dist.getY() - position.getY());
        if ((passX + passY == 1 || passX == passY) || (passX == position.getX() || passY == 1)) {
            distance = moveFigure(dist);
        } else {
            throw new ImposibleMoveException("King not move that.");
        }
        return distance;
    }
    /**
     * The method a listing of all figures.
     * @return tag.
     */
    public Type getType() {
        return Type.KING;
    }
    /**
     * The method a listing of all figures.
     * @param dist - dist.
     * @return tag.
     */
    public Figure clone(Cell dist) {
        return new King(dist);
    }
}