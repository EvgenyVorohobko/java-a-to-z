package by.vorokhobko.chess;

import by.vorokhobko.chess.exceptions.FigureNotFoundException;
import by.vorokhobko.chess.exceptions.ImposibleMoveException;
import by.vorokhobko.chess.exceptions.OccupiedWayException;
import by.vorokhobko.chess.models.Board;
import by.vorokhobko.chess.models.Cell;
import by.vorokhobko.chess.start.Rook;
import by.vorokhobko.chess.start.King;
import by.vorokhobko.chess.start.Knight;
import by.vorokhobko.chess.start.Pawn;
import by.vorokhobko.chess.start.Queen;
import by.vorokhobko.chess.start.Bishop;
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
        assertThat(true, is(pass));
    }
    /**
     * Test Bishop.
     * @throws FigureNotFoundException tag.
     * @throws OccupiedWayException tag.
     * @throws ImposibleMoveException tag.
     */
    @Test(expected = ImposibleMoveException.class)
    public void whenBishopDoNotMoveThat() throws ImposibleMoveException, OccupiedWayException, FigureNotFoundException {
        final int startBishopX = 2;
        final int startBishopY = 0;
        final int finishBishopX = 2;
        final int finishBishopY = 3;
        Cell startBishop = new Cell(startBishopX, startBishopY);
        Cell finishBishop = new Cell(finishBishopX, finishBishopY);
        Bishop bishop = new Bishop(startBishop);
        board.addFigure(bishop);
        board.move(startBishop, finishBishop);
    }
    /**
     * Test Bishop.
     * @throws FigureNotFoundException tag.
     * @throws OccupiedWayException tag.
     * @throws ImposibleMoveException tag.
     */
    @Test(expected = FigureNotFoundException.class)
    public void whenBishopNotFound() throws ImposibleMoveException, OccupiedWayException, FigureNotFoundException {
        final int startBishopX = 2;
        final int startBishopY = 0;
        final int finishBishopX = 2;
        final int finishBishopY = 3;
        Cell startBishop = new Cell(startBishopX, startBishopY);
        Cell finishBishop = new Cell(finishBishopX, finishBishopY);
        board.move(startBishop, finishBishop);
    }
    /**
     * Test Bishop.
     * @throws FigureNotFoundException tag.
     * @throws OccupiedWayException tag.
     * @throws ImposibleMoveException tag.
     */
    @Test(expected = OccupiedWayException.class)
    public void whenBishopNotWay() throws ImposibleMoveException, OccupiedWayException, FigureNotFoundException {
        final int startX = 4;
        final int startY = 4;
        final int finishX = 0;
        final int finishY = 0;
        final int pointX = 1;
        final int pointY = 1;
        Cell start = new Cell(startX, startY);
        Cell finish = new Cell(finishX, finishY);
        Cell point = new Cell(pointX, pointY);
        Bishop bishop = new Bishop(start);
        Pawn pawn = new Pawn(point);
        board.addFigure(pawn);
        board.addFigure(bishop);
        board.move(start, finish);
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
        final int startKingY = 4;
        final int passKingX = 5;
        final int passKingY = 3;
        final int finishKingX = 6;
        final int finishKingY = 3;
        Cell startKing = new Cell(startKingX, startKingY);
        Cell passKing = new Cell(passKingX, passKingY);
        Cell finishKing = new Cell(finishKingX, finishKingY);
        King king = new King(startKing);
        board.addFigure(king);
        boolean pass = board.move(startKing, passKing);
        boolean pass2 = board.move(passKing, finishKing);
        assertThat(true, is(pass));
        assertThat(true, is(pass2));
    }
    /**
     * Test King.
     * @throws FigureNotFoundException tag.
     * @throws OccupiedWayException tag.
     * @throws ImposibleMoveException tag.
     */
    @Test(expected = ImposibleMoveException.class)
    public void whenKingDoNotMoveThat() throws ImposibleMoveException, OccupiedWayException, FigureNotFoundException {
        final int startKingX = 4;
        final int startKingY = 0;
        final int finishKingX = 4;
        final int finishKingY = 2;
        Cell startKing = new Cell(startKingX, startKingY);
        Cell finishKing = new Cell(finishKingX, finishKingY);
        King king = new King(startKing);
        board.addFigure(king);
        board.move(startKing, finishKing);
    }
    /**
     * Test Queen.
     * @throws FigureNotFoundException tag.
     * @throws OccupiedWayException tag.
     * @throws ImposibleMoveException tag.
     */
    @Test
    public void whenQueenMoveTrue() throws ImposibleMoveException, OccupiedWayException, FigureNotFoundException {
        final int startQueenX = 3;
        final int startQueenY = 0;
        final int passQueenX = 0;
        final int passQueenY = 3;
        final int finishQueenX = 0;
        final int finishQueenY = 7;
        Cell startQueen = new Cell(startQueenX, startQueenY);
        Cell passQueen = new Cell(passQueenX, passQueenY);
        Cell finishQueen = new Cell(finishQueenX, finishQueenY);
        Queen queen = new Queen(startQueen);
        board.addFigure(queen);
        boolean pass = board.move(startQueen, passQueen);
        boolean pass2 = board.move(passQueen, finishQueen);
        assertThat(true, is(pass));
        assertThat(true, is(pass2));
    }
    /**
     * Test Queen.
     * @throws FigureNotFoundException tag.
     * @throws OccupiedWayException tag.
     * @throws ImposibleMoveException tag.
     */
    @Test(expected = ImposibleMoveException.class)
    public void whenQueenDoNotMoveThat() throws ImposibleMoveException, OccupiedWayException, FigureNotFoundException {
        final int startQueenX = 3;
        final int startQueenY = 0;
        final int finishQueenX = 1;
        final int finishQueenY = 5;
        Cell startQueen = new Cell(startQueenX, startQueenY);
        Cell finishQueen = new Cell(finishQueenX, finishQueenY);
        Queen queen = new Queen(startQueen);
        board.addFigure(queen);
        board.move(startQueen, finishQueen);
    }
    /**
     * Test Rook.
     * @throws FigureNotFoundException tag.
     * @throws OccupiedWayException tag.
     * @throws ImposibleMoveException tag.
     */
    @Test
    public void whenRookMoveTrue() throws ImposibleMoveException, OccupiedWayException, FigureNotFoundException {
        final int startRookX = 7;
        final int startRookY = 7;
        final int passRookX = 0;
        final int passRookY = 7;
        final int finishRookX = 0;
        final int finishRookY = 0;
        Cell startRook = new Cell(startRookX, startRookY);
        Cell passRook = new Cell(passRookX, passRookY);
        Cell finishRook = new Cell(finishRookX, finishRookY);
        Rook rook = new Rook(startRook);
        board.addFigure(rook);
        boolean pass = board.move(startRook, passRook);
        boolean pass2 = board.move(passRook, finishRook);
        assertThat(true, is(pass));
        assertThat(true, is(pass2));
    }
    /**
     * Test Rook.
     * @throws FigureNotFoundException tag.
     * @throws OccupiedWayException tag.
     * @throws ImposibleMoveException tag.
     */
    @Test(expected = ImposibleMoveException.class)
    public void whenRookDoNotMoveThat() throws ImposibleMoveException, OccupiedWayException, FigureNotFoundException {
        final int startRookX = 0;
        final int startRookY = 0;
        final int finishRookX = 1;
        final int finishRookY = 5;
        Cell startRook = new Cell(startRookX, startRookY);
        Cell finishRook = new Cell(finishRookX, finishRookY);
        Rook rook = new Rook(startRook);
        board.addFigure(rook);
        board.move(startRook, finishRook);
    }
    /**
     * Test Pawn.
     * @throws FigureNotFoundException tag.
     * @throws OccupiedWayException tag.
     * @throws ImposibleMoveException tag.
     */
    @Test
    public void whenPawnMoveTrue() throws ImposibleMoveException, OccupiedWayException, FigureNotFoundException {
        final int startPawnX = 1;
        final int startPawnY = 1;
        final int finishPawnX = 1;
        final int finishPawnY = 2;
        Cell startPawn = new Cell(startPawnX, startPawnY);
        Cell finishPawn = new Cell(finishPawnX, finishPawnY);
        Pawn pawn = new Pawn(startPawn);
        board.addFigure(pawn);
        boolean pass = board.move(startPawn, finishPawn);
        assertThat(true, is(pass));
    }
    /**
     * Test Pawn.
     * @throws FigureNotFoundException tag.
     * @throws OccupiedWayException tag.
     * @throws ImposibleMoveException tag.
     */
    @Test(expected = ImposibleMoveException.class)
    public void whenPawnDoNotMoveThat() throws ImposibleMoveException, OccupiedWayException, FigureNotFoundException {
        final int startPawnX = 3;
        final int startPawnY = 1;
        final int finishPawnX = 1;
        final int finishPawnY = 5;
        Cell startPawn = new Cell(startPawnX, startPawnY);
        Cell finishPawn = new Cell(finishPawnX, finishPawnY);
        Pawn pawn = new Pawn(startPawn);
        board.addFigure(pawn);
        board.move(startPawn, finishPawn);
    }
    /**
     * Test Knight.
     * @throws FigureNotFoundException tag.
     * @throws OccupiedWayException tag.
     * @throws ImposibleMoveException tag.
     */
    @Test
    public void whenKnightMoveTrue() throws ImposibleMoveException, OccupiedWayException, FigureNotFoundException {
        final int startKnightX = 1;
        final int startKnightY = 0;
        final int finishKnightX = 0;
        final int finishKnightY = 2;
        Cell startKnight = new Cell(startKnightX, startKnightY);
        Cell finishKnight = new Cell(finishKnightX, finishKnightY);
        Knight knight = new Knight(startKnight);
        board.addFigure(knight);
        boolean pass = board.move(startKnight, finishKnight);
        assertThat(true, is(pass));
    }
    /**
     * Test Knight.
     * @throws FigureNotFoundException tag.
     * @throws OccupiedWayException tag.
     * @throws ImposibleMoveException tag.
     */
    @Test(expected = ImposibleMoveException.class)
    public void whenKnightDoNotMoveThat() throws ImposibleMoveException, OccupiedWayException, FigureNotFoundException {
        final int startKnightX = 3;
        final int startKnightY = 1;
        final int finishKnightX = 1;
        final int finishKnightY = 5;
        Cell startKnight = new Cell(startKnightX, startKnightY);
        Cell finishKnight = new Cell(finishKnightX, finishKnightY);
        Knight knight = new Knight(startKnight);
        board.addFigure(knight);
        board.move(startKnight, finishKnight);
    }
}