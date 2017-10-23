package by.vorokhobko.Control_Question.model;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Boomberman.
 *
 * Class Boomberman describes the HERO for 007, lesson test.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 23.10.2017.
 * @version 1.
 */
public class Boomberman implements Runnable {
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
    private final int positionX;
    /**
     * The class field.
     */
    private final int positionY;
    /**
     * The class field.
     */
    private ReentrantLock lock;
    /**
     * Add Boomberman.
     * @param gameBoard - gameBoard.
     * @param service - service.
     */
    public Boomberman(final ReentrantLock[][] gameBoard, final ExecutorService service) {
        this.gameBoard = gameBoard;
        this.positionX = gameBoard.length - 1;
        this.positionY = gameBoard[0].length - 1;
        this.service = service;
        this.service.execute(this);
    }
    /**
     * The method moves Boomberman.
     * @return tag.
     */
    public ReentrantLock[][] moveFigure() {
        final ReentrantLock point = this.gameBoard[this.positionX][this.positionY];
        while (!service.isShutdown()) {
            if (this.positionX != this.positionX - 1) {
                if (closePointField(this.positionX - 1, this.positionY) & noteFieldInBooard(this.positionX - 1, this.positionY)) {
                    if (lock.tryLock()) {
                        this.gameBoard[this.positionX - 1][this.positionY] = point;
                        this.gameBoard[this.positionX][this.positionY] = null;
                        lock.unlock();
                    }
                }
            } else if (this.positionX != this.positionX + 1) {
                if (closePointField(this.positionX + 1, this.positionY) & noteFieldInBooard(this.positionX + 1, this.positionY)) {
                    if (lock.tryLock()) {
                        this.gameBoard[this.positionX + 1][this.positionY] = point;
                        this.gameBoard[this.positionX][this.positionY] = null;
                        lock.unlock();
                    }
                }
            } else if (this.positionY != this.positionY - 1) {
                if (closePointField(this.positionX, this.positionY - 1) & noteFieldInBooard(this.positionX, this.positionY - 1)) {
                    if (lock.tryLock()) {
                        this.gameBoard[this.positionX][this.positionY - 1] = point;
                        this.gameBoard[this.positionX][this.positionY] = null;
                        lock.unlock();
                    }
                }
            } else if (this.positionY != this.positionY + 1) {
                if (closePointField(this.positionX, this.positionY + 1) & noteFieldInBooard(this.positionX, this.positionY + 1)) {
                    if (lock.tryLock()) {
                        this.gameBoard[this.positionX][this.positionY + 1] = point;
                        this.gameBoard[this.positionX][this.positionY] = null;
                        lock.unlock();
                    }
                }
            }
        }
        return gameBoard;
    }
    /**
     * The method determines whether the cell is busy, which comes.
     * @param closeX - closeX.
     * @param closeY - closeY.
     * @return tag.
     */
    private boolean closePointField(final int closeX, final int closeY) {
        return this.gameBoard[closeX][closeY] == null;
    }
    /**
     * The method determines whether the cell which comes Boomberman.
     * @param closeX - closeX.
     * @param closeY - closeY.
     * @return tag.
     */
    private boolean noteFieldInBooard(final int closeX, final int closeY) {
        boolean isNeedSave = true;
        if (closeX > -1 && closeY > -1 && closeX < gameBoard.length && closeY < gameBoard[0].length) {
            isNeedSave = false;
        }
        return isNeedSave;
    }
    /**
     * The method override method run.
     */
    @Override
    public void run() {
        moveFigure();
    }
}