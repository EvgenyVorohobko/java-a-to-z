package by.vorokhobko.Chess.start;

import by.vorokhobko.Chess.exceptions.ImposibleMoveException;
import by.vorokhobko.Chess.models.Cell;
import by.vorokhobko.Chess.models.Figure;
import by.vorokhobko.Chess.models.Type;

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
     * The class field.
     */
    private Type type;
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
        int distX = dist.getX() - getPosition().getX();
        int distY = dist.getY() - getPosition().getY();
        if (Math.abs(distX) == Math.abs(distY)) {
            distance = moveFigure(dist);
        } else {
            throw new ImposibleMoveException("Bishop do not move that.");
        }
        return distance;
    }
    /**
     * The method a listing of all figures.
     * @return tag.
     */
    public Type getType() {
        return Type.BISHOP;
    }
}