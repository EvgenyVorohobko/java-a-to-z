package by.vorokhobko.Monitore_Synchronizy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * ParallerSearch.
 *
 * Class ParallerSearch want to crawl the file system and search for specified text in the file system for 007, lesson 3.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru.
 * @since 05.09.2017.
 * @version 1.
 */
public class ParallerSearch {
    /**
     * The class field.
     */
    private String root;
    /**
     * The class field.
     */
    private String text;
    /**
     * The class field.
     */
    private List<String> exts = new ArrayList<>();
    /**
     * The class field.
     */
    private List<Thread> threadAll = new ArrayList<>();
    /**
     * The class field.
     */
    private List<String> result = new ArrayList<>();
    /**
     * The class field.
     */
    private BlockingQueue<String> queue = new LinkedBlockingQueue<>();
    /**
     * The class field.
     */
    private static List<Thread> thread = new ArrayList<>();
    /**
     * Add constructor.
     * @param root - the path to the folder where it is necessary to search.
     * @param text - the specified text.
     * @param exts - file extensions which need to do a search.
     */
    public ParallerSearch(String root, String text, List<String> exts) {
        this.root = root;
        this.text = text;
        this.exts = exts;
    }
    /**
     * The method checks if threads yet are alive.
     * @return tag.
     */
    public static boolean isAlive() {
        boolean isNeedSave = false;
        for (Thread thr : thread) {
            if (thr.isAlive()) {
                isNeedSave = true;
            }
        }
        return isNeedSave;
    }
    /**
     * The method starts the search the text for folder and subfolder.
     */
    public void findThreadFile() {
        for (String element : exts) {
            Thread file = new Thread(new FileFind(this.root, element, this.queue));
            thread.add(file);
            file.start();
        }
        this.threadAll.addAll(thread);
    }
    /**
     * The method starts the search the text for files.
     */
    public void findThreadText() {
        Thread thread = new Thread(new TextFind(this.text, this.queue, this.result));
        this.threadAll.add(thread);
        thread.start();
    }
    /**
     * The method starts the search and prints all elements.
     */
    public void start() {
        System.out.println("Start search...");
        findThreadFile();
        findThreadText();

        for (Thread thread : threadAll) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (String s : this.result) {
            System.out.println(s);
        }
        System.out.println("Fount " + this.result.size() + " files.");
    }
}