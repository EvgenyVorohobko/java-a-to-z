package by.vorokhobko.synchronizmonitore;

import java.io.File;
import java.util.concurrent.BlockingQueue;
import java.util.regex.Pattern;

/**
 * FileFind.
 *
 * Class FileFind search in the directory of folders and files for 007, lesson 3.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru.
 * @since 29.09.2017.
 * @version 1.
 */
public class FileFind implements Runnable {
    /**
     * The class field.
     */
    private String root;
    /**
     * The class field.
     */
    private String find;
    /**
     * The class field.
     */
    private BlockingQueue<String> queue;
    /**
     * Add constructor.
     * @param root - root
     * @param find - find
     * @param queue - queue
     */
    public FileFind(String root, String find, BlockingQueue<String> queue) {
        this.root = root;
        this.find = find;
        this.queue = queue;
    }
    /**
     * The method searches the text for folder and subfolder.
     * @param path - path.
     */
    public void findFileRoot(String path) {
        File direct = new File(path);
        if (direct.isDirectory()) {
            File[] files = direct.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (Pattern.matches(this.find, file.getName()) && !file.isDirectory()) {
                        try {
                            this.queue.put(file.getAbsolutePath());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (file.isDirectory()) {
                        findFileRoot(file.getPath());
                    }
                }
            }
        }
    }
    /**
     * The method override method run.
     */
    @Override
    public void run() {
        findFileRoot(this.root);
    }
}