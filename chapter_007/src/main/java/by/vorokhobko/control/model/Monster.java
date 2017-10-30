package by.vorokhobko.control.model;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Monster.
 *
 * Class Monster describes the Monsters in game for 007, lesson test.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 26.10.2017.
 * @version 1.
 */
public class Monster extends StartModel implements Runnable {
    /**
     * The class field.
     */
    private int pointX;
    /**
     * The class field.
     */
    private int pointY;
    /**
     * Add Boomberman.
     * @param gameBoard - gameBoard.
     * @param service   - service.
     */
    public Monster(ReentrantLock[][] gameBoard, ExecutorService service) {
        super(gameBoard, service);
    }
    /**
     * The method override method run.
     */
    @Override
    public void run() {
        moveFigure();
    }
    /**
     * The method moves Boomberman.
     * @return tag.
     */
    @Override
    public ReentrantLock[][] moveFigure() {
        this.pointX = getPositionX();
        this.pointY = getPositionY();
        while (getService().isShutdown()) {
            moveRight();
            moveLeft();
            moveUp();
            moveDown();
        }
        if (getGameBoard()[this.pointX][this.pointY] == null) {
            this.setPositionX(this.pointX);
            this.setPositionY(this.pointY);
        } else {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (!getService().isShutdown()) {
            getService().execute(this);
        }
        return getGameBoard();
    }
    /**
     * The method determines to move element down.
     */
    public void moveDown() {
        if (getPositionX() - 1  > -1) {
            this.pointX--;
        } else {
            throw new ArrayIndexOutOfBoundsException("The field end");
        }
    }
    /**
     * The method determines to move element up.
     */
    public void moveUp() {
        if (getPositionX() + 1 < getGameBoard().length - 1) {
            this.pointX++;
        } else {
            throw new ArrayIndexOutOfBoundsException("The field end");
        }
    }
    /**
     * The method determines to move element left.
     */
    public void moveLeft() {
        if (getPositionY() - 1 > -1) {
            this.pointY--;
        } else {
            throw new ArrayIndexOutOfBoundsException("The field end");
        }
    }
    /**
     * The method determines to move element right.
     */
    public void moveRight() {
        if (getPositionY() + 1 < getGameBoard()[0].length - 1) {
            this.pointY++;
        } else {
            throw new ArrayIndexOutOfBoundsException("The field end");
        }
    }
}