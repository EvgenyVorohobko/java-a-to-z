package by.vorokhobko.chess.start;

import by.vorokhobko.chess.exceptions.ImposibleMoveException;
import by.vorokhobko.chess.models.Cell;
import by.vorokhobko.chess.models.Figure;

/**
 * Pawn.
 *
 * Class Pawn makes the class Figure wider in the implementation part 002, lesson test.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 13.05.2017.
 * @version 1.
 */
public class Pawn extends Figure {
    /**
     * The class field.
     */
    private Cell[] distance;
    /**
     * Сreate name in the method Pawn.
     * @param position - position.
     */
    public Pawn(Cell position) {
        super(position);
    }
    /**
     * The method way, inherited from class Figure.
     * @param dist - dist.
     * @return tag.
     * @throws ImposibleMoveException tag.
     */
    public Cell[] way(Cell dist) throws ImposibleMoveException {
        int sourceX = getPosition().getX();
        int sourceY = getPosition().getY();
        int distX = dist.getX();
        int distY = dist.getY();
        int pass = Math.abs(distY - sourceY);
        if (distX == sourceX || pass == 1) {
            distance = moveFigure(dist);
        } else {
            throw new ImposibleMoveException("Pawn not move that.");
        }
        return distance;
    }
    /**
     * The method a listing of all figures.
     * @param dist - dist.
     * @return tag.
     */
    public Figure clone(Cell dist) {
        return new Pawn(dist);
    }
}