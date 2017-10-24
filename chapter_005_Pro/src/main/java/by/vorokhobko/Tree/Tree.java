package by.vorokhobko.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * tree.
 *
 * Class tree for create simple tree part 005_pro, lesson 6.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 22.07.2017.
 * @version 1.
 * @param <E> - element.
 */
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
     * The method insert element in tree.
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
     * Method search element in tree.
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
     * The method should check the number of child elements in the tree.
     * @return tag.
     */
    @Override
    public boolean isBinary() {
        int number = 2;
        boolean isNeedSave = true;
        if (root != null) {
            for (Node<E> element : root.getChildren()) {
                if (root.getChildren().size() > number) {
                    isNeedSave = false;
                }
            }
        }
        return isNeedSave;
    }

    /**
     * Override iterator constructor.
     * @return tag.
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private List<E> listE = new ArrayList<>();
            private int index = 0;

            private List<E> addElementToIterator(Node<E> node) {
                for (Node<E> element : node.getChildren()) {
                    if (element.getChildren().size() > 1) {
                        addElementToIterator(element);
                    }
                    this.listE.add(element.getValue());
                }
                return this.listE;
            }

             @Override
            public boolean hasNext() {
                 addElementToIterator(root);
                 return this.index < this.listE.size();
             }

            @Override
            public E next() {
                addElementToIterator(root);
                return this.listE.get(this.index++);
            }
        };
    }
}