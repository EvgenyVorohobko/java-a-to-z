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
    private int finishX;
    /**
     * The class field.
     */
    private int finishY;
    /**
     * The class field.
     */
    private int lengthArray;
    /**
     * The class field.
     */
    private Cell[] pass;
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
    /**
     * Abstract method determining work MenuTracker.
     * @param dist - dist.
     * @throws ImposibleMoveException tag.
     * @return tag.
     */
    public abstract Cell[] way(Cell dist) throws ImposibleMoveException;
    /**
     * Method determining can move figure.
     * @param distance - distance.
     * @throws ImposibleMoveException tag.
     * @return tag.
     */
    public Cell[] moveFigure(Cell distance) throws ImposibleMoveException {
        int startX = position.getX();
        int startY = position.getY();
        finishX = distance.getX();
        finishY = distance.getY();

        int distanceX = Math.abs(this.finishX - startX);
        int distanceY = Math.abs(this.finishY - startY);

        if (((finishX - startX) > 0) & ((finishY - startY) > 0)) {
            pass = new Cell[lengthArray];
            for (int i = 0; i < lengthArray; i++){
                startX++;
                startY++;
                pass[i] = new Cell(startX, startY);
            }
        } else if (((finishX - startX) < 0) & ((finishY - startY) < 0)) {
            pass = new Cell[lengthArray];
            for (int i = 0; i < lengthArray; i++) {
                startX--;
                startY--;
                pass[i] = new Cell(startX, startY);
            }
        } else if (((finishX - startX) > 0) & ((finishY - startY) < 0)) {
            pass = new Cell[lengthArray];
            for (int i = 0; i < lengthArray; i++) {
                startX++;
                startY--;
                pass[i] = new Cell(startX, startY);
            }
        } else if (((finishX - startX) < 0) & ((finishY - startY) > 0)) {
            pass = new Cell[lengthArray];
            for (int i = 0; i < lengthArray; i++) {
                startX--;
                startY++;
                pass[i] = new Cell(startX, startY);
            }
        } else {
            throw new ImposibleMoveException("Figure do not move that.");
        }
        return pass;
    }
    /**
     * Abstract method determining type figure.
     * @return tag.
     */
    public abstract Type getType();
}