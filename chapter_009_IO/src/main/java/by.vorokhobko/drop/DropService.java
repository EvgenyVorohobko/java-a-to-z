package by.vorokhobko.drop;

import java.io.*;

/**
 * CheckEvenNumbers.
 *
 * Class CheckEvenNumbers drop words in stream for 009_IO, lesson 1.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 18.07.2018.
 * @version 1.
 */
public class DropService {
    /**
     * The method to check even number.
     * @param in - input stream.
     * @param out - output stream.
     * @param abuse - element for delete.
     */
    public void dropAbuses(InputStream in, OutputStream out, String[] abuse) {
        StringBuilder builder = new StringBuilder();
        int element;
        boolean isNeedSave = false;
        try (InputStreamReader reader = new InputStreamReader(in);
             OutputStreamWriter writer = new OutputStreamWriter(out)) {
            while ((element = reader.read()) > 0) {
                builder.append((char) element);
                for (String s : abuse) {
                    if (s.startsWith(builder.toString())) {
                        isNeedSave = true;
                        if (s.equals(builder.toString())) {
                            builder.delete(0, builder.length());
                        }
                        break;
                    } else {
                        isNeedSave = false;
                    }
                }
                if (!isNeedSave) {
                    writer.write(builder.toString());
                    builder.delete(0, builder.length());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}