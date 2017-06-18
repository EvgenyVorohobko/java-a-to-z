package by.vorokhobko.Iterator;

import java.util.Iterator;

/**
 * ConvertIterator.
 *
 * Class ConvertIterator for convert iterator 005_Pro, lesson 1.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 18.06.2017.
 * @version 1.
 */
public class ConvertIterator implements Iterator {
    /**
     * The class field.
     */
    private Iterator<Iterator<Integer>> it;
    /**
     * The class field.
     */
    private Iterator<Integer> iter;
    /**
     * Override method hasNext.
     * @return tag.
     */
    @Override
    public boolean hasNext() {
        return iter.hasNext() || it.hasNext();
    }
    /**
     * Override method next.
     * @return tag.
     */
    @Override
    public Object next() {
        Integer result = 0;
        if (iter.hasNext()) {
            result = iter.next();
        } else {
            iter = it.next();
            result = iter.next();
        }
        return result;
    }
    /**
     * Add constructor.
     * @param it - it.
     */
    public ConvertIterator(Iterator<Iterator<Integer>> it) {
        this.it = it;
    }
    /**
     * Add constructor.
     * @param it - it.
     * @return tag.
     */
    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        this.it = it;
        if (it.hasNext()) {
            this.iter = it.next();
        }
        return this;
    }
}