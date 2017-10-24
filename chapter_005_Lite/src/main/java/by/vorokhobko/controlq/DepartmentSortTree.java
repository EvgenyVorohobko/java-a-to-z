package by.vorokhobko.controlq;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * DepartmentSortTree.
 *
 * Class DepartmentSortTree for control questions 005_Lite, lesson 4.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 08.09.2017.
 * @version 1.
 */
public class DepartmentSortTree {
    /**
     * The class field.
     */
    private int count;
    /**
     * The method return all departments in increase.
     * @param department - department.
     * @return tag.
     */
    public Set<String> sortInIncrease(TreeSet<String> department) {
        Set<String> result = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                count = s1.compareTo(s2);
                return count;
            }
        });
        result.addAll(department);
        return department;
    }
    /**
     * The method return all departments in descending.
     * @param department - department.
     * @return tag.
     */
    public Set<String> sortInDescending(TreeSet<String> department) {
        Set<String> result = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                count = s2.compareTo(s1);
                return count;
            }
        });
        result.addAll(department);
        return department;
    }
}