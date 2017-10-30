package by.vorokhobko.control.model;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Monster.
 *
 * Class Start Model abstract class is for move Monsters and Boombermen for 007, lesson test.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 28.10.2017.
 * @version 1.
 */
public abstract class StartModel implements Runnable {
    /**
     * The class field.
     */
    private final ExecutorService service;
    /**
     * The class field.
     */
    private final ReentrantLock[][] gameBoard;
    /**
     * The class field.
     */
    private int positionX;
    /**
     * The class field.
     */
    private int positionY;
    /**
     * Add StartModel.
     * @param gameBoard - gameBoard.
     * @param service - service.
     */
    public StartModel(final ReentrantLock[][] gameBoard, final ExecutorService service) {
        this.gameBoard = gameBoard;
        this.positionX = gameBoard.length - 1;
        this.positionY = gameBoard[0].length - 1;
        this.service = service;
        this.service.execute(this);
    }
    /**
     * Add getter positionX.
     * @return tag.
     */
    public int getPositionX() {
        return positionX;
    }
    /**
     * Add getter positionY.
     * @return tag.
     */
    public int getPositionY() {
        return positionY;
    }
    /**
     * Add getter gameBoard.
     * @return tag.
     */
    public ReentrantLock[][] getGameBoard() {
        return gameBoard;
    }
    /**
     * Add getter service.
     * @return tag.
     */
    public ExecutorService getService() {
        return service;
    }
    /**
     * Add setter amount.
     * @param positionX - positionX.
     */
    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }
    /**
     * Add setter amount.
     * @param positionY - positionY.
     */
    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }
    /**
     * Abstract method move figure on field.
     */
    public abstract ReentrantLock[][] moveFigure();
}