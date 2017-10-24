package by.vorokhobko.synchronizmonitore;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

/**
 * TextFind.
 *
 * Class TextFind search text in files for 007, lesson 3.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru.
 * @since 18.09.2017.
 * @version 1.
 */
public class TextFind implements Runnable {
    /**
     * The class field.
     */
    private BlockingQueue<String> queue;
    /**
     * The class field.
     */
    private List<String> result = new ArrayList<>();
    /**
     * The class field.
     */
    private String text;
    /**
     * Add constructor.
     * @param text - text.
     * @param queue - queue.
     * @param result - result.
     */
    public TextFind(String text, BlockingQueue<String> queue, List<String> result) {
        this.text = text;
        this.queue = queue;
        this.result = result;
    }
    /**
     * The method override method run.
     */
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            String line = this.queue.poll();
            if (line == null && !ParallerSearch.isAlive()) {
                return;
            }
            if (line != null) {
                try {
                    BufferedReader reader = new BufferedReader(
                            new InputStreamReader(new FileInputStream(line), "utf-8"));
                    String result;
                    while ((result = reader.readLine()) != null) {
                        if (result.toLowerCase().contains(this.text.toLowerCase())) {
                            this.result.add(result);
                            break;
                        }
                    }
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}