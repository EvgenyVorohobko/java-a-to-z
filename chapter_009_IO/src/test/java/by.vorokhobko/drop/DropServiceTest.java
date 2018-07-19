package by.vorokhobko.drop;

import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @version 1.
 * @since 19.07.2018.
 */
public class DropServiceTest {
    /**
     * The method work starting for tests.
     * @param abuse - element for delete.
     * @return tag.
     */
    private String init(String[] abuse) {
        DropService service = new DropService();
        String line = "legends never die in my world";
        ByteArrayInputStream streamIn = new ByteArrayInputStream(line.getBytes());
        ByteArrayOutputStream streamOut = new ByteArrayOutputStream();
        service.dropAbuses(streamIn, streamOut, abuse);
        return streamOut.toString();
    }
    /**
     * Test.
     */
    @Test
    public void whenInInputStreamDeleteAllAbuseWords() {
        String[] abuse = {"legends ", "die "};
        String result = "never in my world";
        assertThat(init(abuse), is(result));
    }
    /**
     * Test.
     */
    @Test
    public void whenInInputStreamNotDeleteAllAbuseWord() {
        String[] abuse = {"again ", "please "};
        String result = "legends never die in my world";
        assertThat(init(abuse), is(result));
    }
    /**
     * Test.
     */
    @Test
    public void whenInInputStreamDeleteSplitAbuse() {
        String[] abuse = {" "};
        String result = "legendsneverdieinmyworld";
        assertThat(init(abuse), is(result));
    }
}