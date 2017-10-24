package by.vorokhobko.synchronizmonitore;

import java.util.ArrayList;
import java.util.List;

/**
 * StartUI.
 *
 * Class StartUI run application for 007, lesson 3.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru.
 * @since 30.09.2017.
 * @version 1.
 */
public class StartUI {
    /**
     * The main method.
     * @param args - args.
     */
    public static void main(String[] args) {
        String root = "d:/";
        String text = "java";
        List<String> list = new ArrayList<>();
        list.add(".*.txt");
        list.add(".*.xml");
        ParallerSearch search = new ParallerSearch(root, text, list);
        search.start();
    }
}
