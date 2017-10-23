package by.vorokhobko.Control_Question.model;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Field.
 *
 * Class Field describes the cells of the field for MoveMakerElement 007, lesson test.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 16.10.2017.
 * @version 1.
 */
public class Field {
    /**
     * The class field.
     */
    private static ExecutorService service = Executors.newFixedThreadPool(2);
    /**
     * The class field.
     */
    private final ReentrantLock[][] gameBoard;
    /**
     * Add Field.
     * @param size - size.
     */
    public Field(int size) {
        this.gameBoard = new ReentrantLock[size][size];
        for (int i = 0; i < gameBoard[0].length; i++) {
            for (int j = 0; j < gameBoard.length; j++) {
                this.gameBoard[i][j] = new ReentrantLock();
            }
        }
        new Boomberman(this.gameBoard, this.service);
    }
    /**
     * The main method.
     * @param args - args.
     */
    public static void main(String[] args) {
        System.out.println("NEW GAME!");
        Field field = new Field(10);
        System.out.println("Let's go!");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        service.shutdown();
        System.out.println(field.service.isShutdown());
        System.out.println("The END!");
    }
}