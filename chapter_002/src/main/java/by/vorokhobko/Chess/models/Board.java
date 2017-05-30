package by.vorokhobko.Chess.models;

import by.vorokhobko.Chess.exceptions.FigureNotFoundException;
import by.vorokhobko.Chess.exceptions.ImposibleMoveException;
import by.vorokhobko.Chess.exceptions.OccupiedWayException;

/**
 * Board.
 *
 * Class Board performs the role of board in chess part 002, lesson test.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 13.05.2017.
 * @version 1.
 */
public class Board {
    /**
     * The class field.
     */
    private static final int NUMBER_OF_PIECES = 32;
    /**
     * The class field.
     */
    private Figure[] figures = new Figure[NUMBER_OF_PIECES];

    /**
     * Method determining add Figure on Board.
     *
     * @param figure - figure.
     */
    public void addFigure(Figure figure) {
        for (int i = 0; i < figures.length; i++) {
            if (figures[i] == null) {
                figures[i] = figure;
                break;
            }
        }
    }

    /**
     * Method determining can move figure or not.
     *
     * @param source - source.
     * @param dist   - dist.
     * @return tag.
     * @throws ImposibleMoveException  tag.
     * @throws OccupiedWayException    tag.
     * @throws FigureNotFoundException tag.
     */
    public boolean move(Cell source, Cell dist) throws ImposibleMoveException, OccupiedWayException, FigureNotFoundException {
        boolean isNeedSave = false;
        Cell[] pass = null;
        for (Figure figure : figures) {
            if (figure != null && figure.position.equals(source)) {
                pass = figure.way(dist);
                isNeedSave = true;
                break;
            }
        }
        if (!isNeedSave) {
            throw new FigureNotFoundException("Figure not found");
        }
        for (Figure figure : figures) {
            for (Cell cellPass : pass) {
                if (figure != null && figure.position.equals(cellPass)) {
                    throw new OccupiedWayException("Way occupied figure");
                }
            }
        }
        for (int count = 0; count < figures.length; count++) {
            if (figures[count] != null && figures[count].position.equals(source)) {
                figures[count] = figures[count].clone(dist);
            }
        }
        return true;
    }
}