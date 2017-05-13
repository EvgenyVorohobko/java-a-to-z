package by.vorokhobko.Chess.models;

/**
 * Cell.
 *
 * Class Cell describes the cells of the chessboard for Chess 002, lesson test.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 13.05.2017.
 * @version 1.
 */
public class Cell {
    /**
     * The class field.
     */
    private int x;
    /**
     * The class field.
     */
    private int y;
    /**
     * Add Cell.
     * @param x - x.
     * @param y - y.
     */
    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }
    /**
     * Add getter x.
     * @return tag.
     */
    public int getX() {
        return this.x;
    }
    /**
     * Add setter x.
     * @param x - x.
     */
    public void setX(int x) {
        this.x = x;
    }
    /**
     * Add getter y.
     * @return tag.
     */
    public int getY() {
        return this.y;
    }
    /**
     * Add setter y.
     * @param y - y.
     */
    public void setY(int y) {
        this.y = y;
    }
//    public Cell() {
//    }
}