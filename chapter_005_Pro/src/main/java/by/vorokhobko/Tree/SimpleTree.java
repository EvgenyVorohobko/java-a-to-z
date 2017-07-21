package by.vorokhobko.Tree;

/**
 * SimpleTree.
 *
 * Class SimpleTree the interface for the Tree part 005_Pro, lesson 6.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 17.07.2017.
 * @version 1.
 * @param <E>.
 */
public interface SimpleTree<E extends Comparable<E>> extends Iterable<E> {
    /**
     * Add element the child in parent.
     * Parent может иметь список child.
     * @param parent parent.
     * @param child child.
     * @return tag.
     */
    boolean add(E parent, E child);
}