package by.vorokhobko.scan;

import org.junit.Test;
import java.io.File;
import java.util.ArrayList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @version 1.
 * @since 23.01.2019.
 */
public class SearchTest {
    /**
     * The class field.
     */
    private Search search = new Search();
    /**
     * Test.
     */
    @Test
    public void whenBinaryElementsInMap() {
        String parent = System.getProperty("java.io.tmpdir");
        ArrayList<String> exts = new ArrayList<>();
        exts.add("docx");
        exts.add("jpg");

        ArrayList<File> resultList = new ArrayList<>();
        resultList.add(new File("java_method_1.docx"));
        resultList.add(new File("java_method_2.docx"));
        resultList.add(new File("sql.jpg"));

        assertThat(this.search.files(parent, exts), is(resultList));
    }
}