package by.vorokhobko.Tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Tree<E extends Comparable<E>> implements SimpleTree<E> {
    /**
     * The class field.
     */
    private Node<E> root;
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
        private List<Node<E>> children;
        /**
         * The class field.
         */
        private E value;
        /**
         * Add constructor.
         *
         * @param value - value.
         */
        public Node(E value) {
            this.value = value;
            children = new ArrayList<>();
        }
        /**
         * Add getter values.
         *
         * @return tag.
         */
        public E getValue() {
            return value;
        }
        /**
         * Add getter childen.
         *
         * @return tag.
         */
        public List<Node<E>> getChildren() {
            return children;
        }
    }

    /**
     * The method insert element in Tree.
     * @param parent - parent.
     * @param child - child.
     * @return tag.
     */
    @Override
    public boolean add(E parent, E child) {
        boolean isNeedSave = false;
        if (this.root == null) {
            root = new Node<>(parent);
            root.getChildren().add(new Node<>(child));
            isNeedSave = true;
        } else {
            Node<E> parentNode = new Node<>(parent);
            Node<E> resultNode = searchElement(root, parentNode);
            if (resultNode != null) {
                resultNode.getChildren().add(new Node<>(child));
                isNeedSave = true;
            }
        }
        return isNeedSave;
    }
    /**
     * Method search element in Tree.
     * @param root - root.
     * @param newNode - newNode.
     * @return tag.
     */
    protected Node<E> searchElement(Node<E> root, Node<E> newNode) {
        int comp = root.getValue().compareTo(newNode.getValue());
        if (comp == 0) {
            return root;
        }
        Node<E> result;
        for (Node<E> resultNode : root.getChildren()) {
            result = searchElement(resultNode, newNode);
            if (result != null) {
                return result;
            }
        }
        return null;
    }

    /**
     * Override iterator constructor.
     * @return tag.
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> result;

            @Override
            public boolean hasNext() {
                boolean isNeedSave = false;
                if (root.getValue() != null) {
                    isNeedSave = true;
                } else if (root.getChildren().iterator().hasNext()) {
                    isNeedSave = true;
                }
                return isNeedSave;
            }

            @Override
            public E next() {
                return result.getValue();
            }
        };
    }
}