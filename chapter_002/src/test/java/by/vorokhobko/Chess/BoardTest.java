package by.vorokhobko.Chess;

import by.vorokhobko.Chess.exceptions.FigureNotFoundException;
import by.vorokhobko.Chess.exceptions.ImposibleMoveException;
import by.vorokhobko.Chess.exceptions.OccupiedWayException;
import by.vorokhobko.Chess.models.Board;
import by.vorokhobko.Chess.models.Cell;
import by.vorokhobko.Chess.start.Rook;
import by.vorokhobko.Chess.start.King;
import by.vorokhobko.Chess.start.Knight;
import by.vorokhobko.Chess.start.Pawn;
import by.vorokhobko.Chess.start.Queen;
import by.vorokhobko.Chess.start.Bishop;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Test.
 *
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @version 1.
 * @since 22.05.2017.
 */
public class BoardTest {
    /**
     * The class field.
     */
    private static final int START_KNIGHT_X = 2;
    /**
     * The class field.
     */
    private static final int START_KNIGHT_Y = 1;
    /**
     * The class field.
     */
    private Knight knight = new Knight(new Cell(START_KNIGHT_X, START_KNIGHT_Y));
    /**
     * The class field.
     */
    private static final int START_PAWN_X = 4;
    /**
     * The class field.
     */
    private static final int START_PAWN_Y = 2;
    /**
     * The class field.
     */
    private Pawn pawn = new Pawn(new Cell(START_PAWN_X, START_PAWN_Y));
    /**
     * The class field.
     */
    private Board board = new Board();
    /**
     * Test Bishop.
     * @throws FigureNotFoundException tag.
     * @throws OccupiedWayException tag.
     * @throws ImposibleMoveException tag.
     */
    @Test
    public void whenBishopMoveTrue() throws ImposibleMoveException, OccupiedWayException, FigureNotFoundException {
        final int startBishopX = 2;
        final int startBishopY = 0;
        final int finishBishopX = 0;
        final int finishBishopY = 2;
        Cell startBishop = new Cell(startBishopX, startBishopY);
        Cell finishBishop = new Cell(finishBishopX, finishBishopY);
        Bishop bishop = new Bishop(startBishop);
        board.addFigure(bishop);
        boolean pass = board.move(startBishop, finishBishop);
        boolean answer = true;
        assertThat(answer, is(pass));
    }
    /**
     * Test Bishop.
     * @throws FigureNotFoundException tag.
     * @throws OccupiedWayException tag.
     * @throws ImposibleMoveException tag.
     */
    @Test(expected = ImposibleMoveException.class)
    public void whenBishopMoveDoNotMoveThat() throws ImposibleMoveException, OccupiedWayException, FigureNotFoundException {
        final int startBishopX = 2;
        final int startBishopY = 0;
        final int finishBishopX = 2;
        final int finishBishopY = 3;
        Cell startBishop = new Cell(startBishopX, startBishopY);
        Cell finishBishop = new Cell(finishBishopX, finishBishopY);
        Bishop bishop = new Bishop(startBishop);
        board.addFigure(bishop);
        boolean pass = board.move(startBishop, finishBishop);
    }
    /**
     * Test King.
     * @throws FigureNotFoundException tag.
     * @throws OccupiedWayException tag.
     * @throws ImposibleMoveException tag.
     */
    @Test
    public void whenKingMoveTrue() throws ImposibleMoveException, OccupiedWayException, FigureNotFoundException {
        final int startKingX = 4;
        final int startKingY = 0;
        final int finishKingX = 5;
        final int finishKingY = 1;
        Cell startKing = new Cell(startKingX, startKingY);
        Cell finishKing = new Cell(finishKingX, finishKingY);
        King king = new King(startKing);
        board.addFigure(king);
        boolean pass = board.move(startKing, finishKing);
        boolean answer = true;
        assertThat(answer, is(pass));
    }
    /**
     * Test King.
     * @throws FigureNotFoundException tag.
     * @throws OccupiedWayException tag.
     * @throws ImposibleMoveException tag.
     */
    @Test(expected = ImposibleMoveException.class)
    public void whenKingMoveDoNotMoveThat() throws ImposibleMoveException, OccupiedWayException, FigureNotFoundException {
        final int startKingX = 4;
        final int startKingY = 0;
        final int finishKingX = 4;
        final int finishKingY = 2;
        Cell startKing = new Cell(startKingX, startKingY);
        Cell finishKing = new Cell(finishKingX, finishKingY);
        King king = new King(startKing);
        board.addFigure(king);
        boolean pass = board.move(startKing, finishKing);
    }
    /**
     * Test Rook.
     * @throws FigureNotFoundException tag.
     * @throws OccupiedWayException tag.
     * @throws ImposibleMoveException tag.
     */
    @Test
    public void whenRookMoveDoNotMoveThat() throws ImposibleMoveException, OccupiedWayException, FigureNotFoundException {
        final int startRookX = 0;
        final int startRookY = 0;
        final int finishRookX = 0;
        final int finishRookY = 6;
        Cell startRook = new Cell(startRookX, startRookY);
        Cell finishRook = new Cell(finishRookX, finishRookY);
        Rook rook = new Rook(startRook);
        board.addFigure(rook);
        boolean pass = board.move(startRook, finishRook);
        boolean answer = true;
        assertThat(answer, is(pass));
    }
    /**
     * Test Queen.
     * @throws FigureNotFoundException tag.
     * @throws OccupiedWayException tag.
     * @throws ImposibleMoveException tag.
     *
    @Test
    public void whenQueenDoNotMoveThat() throws ImposibleMoveException, OccupiedWayException, FigureNotFoundException {
        final int startQueenX = 3;
        final int startQueenY = 0;
        final int finishQueenX = 3;
        final int finishQueenY = 7;
        Cell startQueen = new Cell(startQueenX, startQueenY);
        Cell finishQueen = new Cell(finishQueenX, finishQueenY);
        Queen queen = new Queen(startQueen);
        board.addFigure(queen);
        boolean pass = board.move(startQueen, finishQueen);
        boolean answer = true;
        assertThat(answer, is(pass));
    }*/
}