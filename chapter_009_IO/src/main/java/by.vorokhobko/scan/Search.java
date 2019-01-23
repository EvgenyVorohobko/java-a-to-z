package by.vorokhobko.scan;

import java.io.File;
import java.util.*;

/**
 * Search.
 *
 * Class Search scan file system for 009_IO, lesson 1.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 23.01.2019.
 * @version 1.
 */
public class Search {
    /**
     * The method add element in search binary tree.
     * @param parent - parent.
     * @param exts - exts.
     * @return tag.
     */
    public List<File> files(String parent, ArrayList<String> exts) {
        File fileParent = new File(parent);
        ArrayList<File> list = new ArrayList<>();
        Queue<File> queue = new PriorityQueue<>();

        Collections.addAll(queue, Objects.requireNonNull(fileParent.listFiles()));
        while (!queue.isEmpty()) {
            File fileChild = queue.remove();
            if (fileChild.isDirectory()) {
                Collections.addAll(queue, Objects.requireNonNull(fileChild.listFiles()));
            } else {
                for (int i = 0; i < exts.size(); i++) {
                    if (fileChild.getName().contains(exts.get(i))) {
                        list.add(new File(fileChild.getName()));
                    }
                }
            }
        }
        return list;
    }
}