package by.vorokhobko.chat;

import org.junit.Test;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @version 1.
 * @since 07.02.2019.
 */
public class ChatTest {
    /**
     * The class field.
     */
    private static final File LOG =  new File("d:/Programming/Java/Projects/log.txt");
    /**
     * Test.
     */
    @Test
    public void whenEnterStopThenProgramWriteOnlyUserPhrase() {
        String input = "стоп\r\nhello\r\nbye";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        new Chat().workChat();
        ArrayList<String> result = new ArrayList<>();
        ArrayList<String> example = new ArrayList<>(Arrays.asList("User: стоп", "User: hello", "User: bye"));
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(LOG), StandardCharsets.UTF_8))) {
            while (reader.ready()) {
                result.add(reader.readLine());
            }
            assertThat(example, is(result));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}