package by.vorokhobko.Chess.start;

import by.vorokhobko.Chess.exceptions.ImposibleMoveException;
import by.vorokhobko.Chess.models.Cell;
import by.vorokhobko.Chess.models.Figure;
import by.vorokhobko.Chess.models.Type;

/**
 * Rook.
 *
 * Class Rook makes the class Figure wider in the implementation part 002, lesson test.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 13.05.2017.
 * @version 1.
 */
public class Rook extends Figure {
    /**
     * The class field.
     */
    private Cell[] distance;
    /**
     * Сreate name in the method Rook.
     * @param position - position.
     */
    public Rook(Cell position) {
        super(position);
    }
    /**
     * The method way, inherited from class Figure.
     * @param dist - dist.
     * @return tag.
     * @throws ImposibleMoveException tag.
     */
    public Cell[] way(Cell dist) throws ImposibleMoveException {
        int startX = position.getX();
        int startY = position.getY();
        int distX = dist.getX();
        int distY = dist.getY();
        if (distX == startX || distY == startY) {
            distance = moveFigure(dist);
        } else {
            throw new ImposibleMoveException("Rook not move that.");
        }
        return distance;
    }
    /**
     * The method a listing of all figures.
     * @return tag.
     */
    public Type getType() {
        return Type.ROOK;
    }
    /**
     * The method a listing of all figures.
     * @param dist - dist.
     * @return tag.
     */
    public Figure clone(Cell dist) {
        return new Rook(dist);
    }
}