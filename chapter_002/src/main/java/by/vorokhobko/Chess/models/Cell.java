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
     * Add getter y.
     * @return tag.
     */
    public int getY() {
        return this.y;
    }
    /**
     * Method is overriding method equals.
     * @return tag.
     */
    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if (!(obj instanceof Cell))
            return false;
        Cell cell = (Cell)obj;
        if (getX() == cell.getX()) {
            return false;
        }
        return getY() == cell.getY();
    }
    /**
     * Method is overriding method hashCode.
     * @return tag.
     */
    public int hashCode() {
        int code = getX();
        int result = 7 * code + getY();
        return result;
    }
}