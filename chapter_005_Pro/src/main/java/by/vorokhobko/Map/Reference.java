package by.vorokhobko.Map;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Reference.
 *
 * Class Reference the class for work HashMap, lesson 5.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 17.07.2017.
 * @version 1.
 * @param <K> - key.
 * @param <V> - value.
 */
public class Reference<K, V> implements Book<K, V> {
    /**
     * The class field.
     */
    private static final int INIT_ARRAY = 16;
    /**
     * The class field.
     */
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    /**
     * The class field.
     */
    private Node<K, V>[] array;
    /**
     * The class field.
     */
    private int size = 0;
    /**
     * The class field.
     */
    private float threshold;

    /**
     * Method hash to obtain cells in which to place the element.
     * @param key - key.
     * @return tag.
     */
    public int hash(K key) {
        int hash = 31;
        hash = hash * 17 + key.hashCode();
        return hash % array.length;
    }

    /**
     * Add constructor.
     */
    public Reference() {
        array = new Node[INIT_ARRAY];
        threshold = array.length * DEFAULT_LOAD_FACTOR;
    }

    /**
     * The method insert element in Book.
     * @param key   - key.
     * @param value - value.
     * @return tag.
     */
    @Override
    public boolean insert(K key, V value) {
        boolean isNeedSave = false;
        if (size + 1 >= threshold) {
            threshold *= 2;
            arrayDoubling();
        }
        Node<K, V> newNode = new Node<>(key, value);
        int index = hash(key);
        if (array[index] == null) {
            return simpleAdd(index, newNode);
        }
        List<Node<K, V>> nodeList = array[index].getNodes();
        for (Node<K, V> thisNode : nodeList) {
            if ((keyExistButValueNew(thisNode, newNode, value))
                    || collisionProcessing(thisNode, newNode, nodeList)) {
                isNeedSave = true;
            }
        }
        return isNeedSave;
    }
    /**
     * The method overwrites elements in a new array.
     */
    private void arrayDoubling() {
        Node<K, V>[] oldArray = array;
        array = new Node[oldArray.length * 2];
        size = 0;
        for (Node<K, V> node : oldArray) {
            if (node != null) {
                for (Node<K, V> newNode : node.getNodes()) {
                    insert(newNode.key, newNode.value);
                }
            }
        }
    }
    /**
     * Method when the element is simply added to Book.
     * @param index - index.
     * @param node  - node.
     * @return tag.
     */
    private boolean simpleAdd(int index, Node<K, V> node) {
        array[index] = new Node<>(null, null);
        array[index].getNodes().add(node);
        size++;
        return true;
    }
    /**
     * Method when key have in List, but value do not match.
     * @param nodeFromList - node is list.
     * @param newNode      - newNode.
     * @param value        - value.
     * @return tag.
     */
    private boolean keyExistButValueNew(
            final Node<K, V> nodeFromList,
            final Node<K, V> newNode,
            final V value) {
        boolean isNeedSave = false;
        if (nodeFromList.getKey().equals(newNode.getKey())
                && !nodeFromList.getValues().equals(newNode.getValues())) {
            nodeFromList.setValue(value);
            isNeedSave = true;
        }
        return isNeedSave;
    }
    /**
     * Method for handling collisions.
     * @param nodeFromList - node is list.
     * @param newNode      - newNode.
     * @param nodeList     - nodeList.
     * @return tag.
     */
    private boolean collisionProcessing(
            final Node<K, V> nodeFromList,
            final Node<K, V> newNode,
            final List<Node<K, V>> nodeList) {
        boolean isNeedSave = false;
        if ((nodeFromList.hashCode() == newNode.hashCode())
                && !Objects.equals(nodeFromList.getKey(), newNode.getKey())
                && !Objects.equals(nodeFromList.getValues(), newNode.getValues())) {
            nodeList.add(newNode);
            size++;
            isNeedSave = true;
        }
        return isNeedSave;
    }

    /**
     * The method delete element in Book.
     * @param key - key.
     * @return tag.
     */
    @Override
    public boolean delete(K key) {
        boolean isNeedSave = false;
        int index = hash(key);
        if (array[index] != null) {
            if (array[index].getNodes().size() == 1) {
                array[index].getNodes().remove(0);
                isNeedSave = true;
            }
            List<Node<K, V>> nodelist = array[index].getNodes();
            for (Node<K, V> node : nodelist) {
                if (key.equals(node.getKey())) {
                    nodelist.remove(node);
                    isNeedSave = true;
                }
            }
            return isNeedSave;
        }
        throw new NullPointerException();
    }

    /**
     * The method get key element in Book.
     * @param key - key.
     * @return tag.
     */
    @Override
    public V get(K key) {
        int index = hash(key);
        if (index < array.length) {
            if (array[index] != null) {
                if (array[index].getNodes().size() == 1) {
                    return array[index].getNodes().get(0).getValues();
                }
                List<Node<K, V>> list = array[index].getNodes();
                for (Node<K, V> node : list) {
                    if (key.equals(node.getKey())) {
                        return node.getValues();
                    }
                }
            }
            throw new NullPointerException();
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    /**
     * The method size Book.
     * @return tag.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Override iterator constructor.
     * @return tag.
     */
    @Override
    public Iterator<V> iterator() {
        return new Iterator<V>() {

            private int counterArray = 0;
            private int valuesCounter = 0;
            private Iterator<Node<K, V>> subIterator = null;

            @Override
            public boolean hasNext() {
                boolean isNeedSave = false;
                if (valuesCounter == size) {
                    isNeedSave = false;
                }
                if (subIterator == null || !subIterator.hasNext()) {
                    if (moveToNextCell()) {
                        subIterator = array[counterArray].getNodes().iterator();
                    } else {
                        return isNeedSave;
                    }
                }
                return subIterator.hasNext();
            }
            private boolean moveToNextCell() {
                counterArray++;
                while (counterArray < array.length && array[counterArray] == null) {
                    counterArray++;
                }
                return counterArray < array.length && array[counterArray] != null;
            }

            @Override
            public V next() {
                valuesCounter++;
                return subIterator.next().getValues();
            }
        };
    }

    /**
     * Node.
     *
     * Class Node for start Reference 005_Pro, lesson 5.
     * @param <K> - key.
     * @param <V> - value.
     */
    protected class Node<K, V> {
        /**
         * The class field.
         */
        private List<Node<K, V>> nodes;
        /**
         * The class field.
         */
        private V value;
        /**
         * The class field.
         */
        private K key;
        /**
         * The class field.
         */
        private int hash;

        /**
         * Add constructor.
         * @param key - key.
         * @param value - value.
         */
        private Node(K key, V value) {
            this.value = value;
            this.key = key;
            nodes = new LinkedList<>();
        }
        /**
         * Add getter nodes.
         * @return tag.
         */
        private List<Node<K, V>> getNodes() {
            return nodes;
        }
        /**
         * Add getter values.
         * @return tag.
         */
        public V getValues() {
            return value;
        }
        /**
         * Add getter key.
         * @return tag.
         */
        public K getKey() {
            return key;
        }
        /**
         * Add setter key.
         * @param value - value.
         */
        public void setValue(V value) {
            this.value = value;
        }
    }
}