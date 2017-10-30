package by.vorokhobko.control.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
public class Boomberman extends StartModel implements Runnable {
    /**
     * The class field.
     */
    private ReentrantLock lock;
    /**
     * Add Boomberman.
     * @param gameBoard - gameBoard.
     * @param service   - service.
     */
    public Boomberman(ReentrantLock[][] gameBoard, ExecutorService service) {
        super(gameBoard, service);
        getGameBoard()[0][0] = new ReentrantLock();
    }
    /**
     * The method moves Boomberman.
     * @return tag.
     */
    @Override
    public ReentrantLock[][] moveFigure() {
        final ReentrantLock point = getGameBoard()[getPositionX()][getPositionY()];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = "";
        while (text.equals("w") & text.equals("s") & text.equals("a") & text.equals("d")) {
            try {
                text = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        while (!getService().isShutdown()) {
            if (text.equals("s") & getPositionX() - 1 > -1) {
                moveDown(point);
            } else if (text.equals("w") & getPositionX() + 1 > getGameBoard().length - 1) {
                moveUp(point);
            } else if (text.equals("a") & getPositionY() - 1 > 1) {
                moveLeft(point);
            } else if (text.equals("d") & getPositionY() + 1 > getGameBoard()[0].length - 1) {
                moveRight(point);
            }
        }
        if (!getService().isShutdown()) {
            getService().execute(this);
        }
        return getGameBoard();
    }
    /**
     * The method determines whether the cell is busy, which comes.
     * @param closeX - closeX.
     * @param closeY - closeY.
     * @return tag.
     */
    private boolean closePointField(final int closeX, final int closeY) {
        return getGameBoard()[closeX][closeY] == null;
    }
    /**
     * The method determines whether the cell which comes Boomberman.
     * @param closeX - closeX.
     * @param closeY - closeY.
     * @return tag.
     */
    private boolean noteFieldInBoard(final int closeX, final int closeY) {
        boolean isNeedSave = true;
        if (closeX > -1 && closeY > -1 && closeX < getGameBoard().length && closeY < getGameBoard()[0].length) {
            isNeedSave = false;
        }
        return isNeedSave;
    }
    /**
     * The method determines to move element down.
     * @param point - point.
     * @return tag.
     */
    public ReentrantLock moveDown(final ReentrantLock point) {
        if (closePointField(getPositionX() - 1, getPositionY()) & noteFieldInBoard(getPositionX() - 1, getPositionY())) {
            if (lock.tryLock()) {
                getGameBoard()[getPositionX() - 1][getPositionY()] = point;
                getGameBoard()[getPositionX()][getPositionY()] = null;
                lock.unlock();
            }
        }
        return point;
    }
    /**
     * The method determines to move element up.
     * @param point - point.
     * @return tag.
     */
    public ReentrantLock moveUp(final ReentrantLock point) {
        if (closePointField(getPositionX() + 1, getPositionY()) & noteFieldInBoard(getPositionX() + 1, getPositionY())) {
            if (lock.tryLock()) {
                getGameBoard()[getPositionX() + 1][getPositionY()] = point;
                getGameBoard()[getPositionX()][getPositionY()] = null;
                lock.unlock();
            }
        }
        return point;
    }
    /**
     * The method determines to move element left.
     * @param point - point.
     * @return tag.
     */
    public ReentrantLock moveLeft(final ReentrantLock point) {
        if (closePointField(getPositionX(), getPositionY() - 1) & noteFieldInBoard(getPositionX(), getPositionY())) {
            if (lock.tryLock()) {
                getGameBoard()[getPositionX()][getPositionY() - 1] = point;
                getGameBoard()[getPositionX()][getPositionY()] = null;
                lock.unlock();
            }
        }
        return point;
    }
    /**
     * The method determines to move element right.
     * @param point - point.
     * @return tag.
     */
    public ReentrantLock moveRight(final ReentrantLock point) {
        if (closePointField(getPositionX(), getPositionY() + 1) & noteFieldInBoard(getPositionX(), getPositionY() + 1)) {
            if (lock.tryLock()) {
                getGameBoard()[getPositionX()][getPositionY() + 1] = point;
                getGameBoard()[getPositionX()][getPositionY()] = null;
                lock.unlock();
            }
        }
        return point;
    }
    /**
     * The method override method run.
     */
    @Override
    public void run() {
        moveFigure();
    }
}