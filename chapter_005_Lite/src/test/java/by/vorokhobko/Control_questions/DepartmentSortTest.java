package by.vorokhobko.Control_questions;

import org.junit.Test;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @version 1.
 * @since 08.09.2017.
 */
public class DepartmentSortTest {
    /**
     * The class field.
     */
    private DepartmentSortTree tree = new DepartmentSortTree();
    /**
     * The class field.
     */
    private TreeSet<String> set = new TreeSet<>(Arrays.asList(
            ("K1/SK1/SSK1"),
            ("K1/SK2"),
            ("K1/SK1"),
            ("K2/SK1/SSK1"),
            ("K2/SK1"),
            ("K2"),
            ("K1/SK1/SSK2"),
            ("K1"),
            ("K2/SK1/SSK2")));

    /**
     * Test.
     */
    @Test
    public void whenArraySortInIncrease() {
        Set<String> result = tree.sortInIncrease(set);
        Set<String> listOut = new TreeSet<>(Arrays.asList(
                ("K1"),
                ("K1/SK1"),
                ("K1/SK1/SSK1"),
                ("K1/SK1/SSK2"),
                ("K1/SK2"),
                ("K2"),
                ("K2/SK1"),
                ("K2/SK1/SSK1"),
                ("K2/SK1/SSK2")));
        assertThat(listOut, is(result));
    }
    /**
     * Test.
     */
    @Test
    public void whenArraySortInDescending() {
        Set<String> result = tree.sortInDescending(set);
        Set<String> listOut = new TreeSet<>(Arrays.asList(
                ("K2"),
                ("K2/SK1"),
                ("K2/SK1/SSK2"),
                ("K2/SK1/SSK1"),
                ("K1"),
                ("K1/SK2"),
                ("K1/SK1"),
                ("K1/SK1/SSK2"),
                ("K1/SK1/SSK1")));
        assertThat(listOut, is(result));
    }
}