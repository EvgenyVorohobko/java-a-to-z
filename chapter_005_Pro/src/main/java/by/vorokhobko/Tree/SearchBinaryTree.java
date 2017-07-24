package by.vorokhobko.Tree;

/**
 * SearchBinaryTree.
 *
 * Class SearchBinaryTree for create simple binary tree part 005_pro, lesson 6.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 24.07.2017.
 * @version 1.
 * @param <E> - element.
 */
public class SearchBinaryTree<E> {
    /**
     * The class field.
     */
    private Node<E> root;

    /**
     * The method add element in search binary tree.
     * @param e - element.
     */
    public void add(E e) {
        if (this.root == null) {
            this.root = new Node<>(e);
        }
        Node<E> node = this.root;
        while (true) {
            if (e.hashCode() < node.getValue().hashCode()) {
                if (node.left == null) {
                    node.left = new Node<>(e);
                    return;
                } else {
                    node = node.left;
                }
            } else if (e.hashCode() > node.getValue().hashCode()) {
                if (node.right == null) {
                    node.right = new Node<>(e);
                    return;
                } else {
                    node = node.right;
                }
            } else {
                return;
            }
        }
    }

    /**
     * The method find element in search binary tree.
     * @param element - element.
     * @return tag.
     */
    public boolean find(E element) {
        boolean isNeedSave = false;
        Node<E> node = this.root;
        while (node != null) {
            if (node.getValue().hashCode() == element.hashCode()) {
                isNeedSave = true;
                break;
            } else if (node.getValue().hashCode() > element.hashCode()) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return isNeedSave;
    }

    /**
     * Node.
     *
     * Class Node for start Reference 005_Pro, lesson 5.
     * @param <E> - element.
     */
    protected class Node<E> {
        /**
         * The class field.
         */
        private E value;
        /**
         * The class field.
         */
        private Node<E> left;
        /**
         * The class field.
         */
        private Node<E> right;

        /**
         * Add constructor.
         * @param value - value.
         */
        public Node(E value) {
            this.value = value;
        }
        /**
         * Add getter values.
         * @return tag.
         */
        public E getValue() {
            return value;
        }
    }
}