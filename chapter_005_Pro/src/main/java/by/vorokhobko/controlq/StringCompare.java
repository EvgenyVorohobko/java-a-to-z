package by.vorokhobko.controlq;

import java.util.HashSet;
import java.util.Set;

/**
 * StringCompare.
 *
 * Class StringCompare control questions for 005_Pro.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru.
 * @since 23.09.2017.
 * @version 1.
 */
public class StringCompare {
    /**
     * The helper method.
     * @param text - text.
     * @return tag.
     */
    private Set addElementInHashSet(String text) {
        Set hashSet = new HashSet();
        char[] array = text.toCharArray();
        for (int i = 0; i < array.length; i++) {
            hashSet.add(array[i]);
        }
        return hashSet;
    }
    /**
     * The method compare words.
     * @param text1 - text1.
     * @param text2 - text2.
     * @return tag.
     */
    public int compareString(String text1, String text2) {
        Set word1 = addElementInHashSet(text1.toLowerCase());
        Set word2 = addElementInHashSet(text2.toLowerCase());
        int wordBeforeSize = word1.size();
        word1.removeAll(word2);
        int wordAfterSize = word1.size();
        int result = wordBeforeSize - wordAfterSize;
        return result;
    }
}