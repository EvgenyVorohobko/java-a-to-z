package by.vorokhobko.control.model;

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
    private int index = 0;
    /**
     * The class field.
     */
    private int count = 0;
    /**
     * The class field.
     */
    private int startSize = 10;
    /**
     * The class field.
     */
    private static ExecutorService service = Executors.newCachedThreadPool();
    /**
     * The class field.
     */
    private ReentrantLock[][] gameBoard;
    /**
     * Add Field.
     * @param size - size.
     */
    public Field(int size) {
        if (size > this.startSize) {
            this.gameBoard = new ReentrantLock[size][size];
        } else {
            this.gameBoard = new ReentrantLock[this.startSize][this.startSize];
        }
        for (int i = 0; i < gameBoard[0].length; i++) {
            for (int j = 0; j < gameBoard.length; j++) {
                this.gameBoard[i][j] = new ReentrantLock();
                this.index = this.gameBoard.length * this.gameBoard[0].length;
            }
        }
        addMonster();
    }
    /**
     * The add Monsters and Boomberman on field.
     */
    public void addMonster() {
        new Boomberman(this.gameBoard, this.service);
        count++;
        while ((float) this.count / this.index < 0.2F) {
            new Monster(this.gameBoard, this.service);
            this.count++;
        }
    }

    /**
     * The main method.
     * @param args - args.
     */
    public static void main(String[] args) {
        System.out.println("Let's BATTLE!");
        Field field = new Field(20);
        System.out.println("Let's go!");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        service.shutdown();
        System.out.println(field.service.isShutdown());
        System.out.println("The END!");
    }
}