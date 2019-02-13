package by.vorokhobko.chat;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 * Chat.
 *
 * Class Chat talks with users using a random phrase for 009_IO, lesson 1.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 07.02.2019.
 * @version 1.
 */
public class Chat {
    /**
     * The class field.
     */
    private static final String STOP = "стоп";
    /**
     * The class field.
     */
    private static final String CONTINUE = "продолжить";
    /**
     * The class field.
     */
    private static final String END = "закончить";
    /**
     * The class field.
     */
    private static final File LOG =  new File("d:/Programming/Java/Projects/log.txt");
    /**
     * The class field.
     */
    private static final File TEXT = new File("d:/Programming/Java/Projects/text.txt");
    /**
     * The class field.
     */
    private final Random RN = new Random();
    /**
     * The class generated id.
     *
     * @return tag.
     */
    private int generateId(int element) {
        return RN.nextInt(element);
    }
    /**
     * The class generated take random String line from txt document.
     *
     * @return tag.
     */
    private ArrayList<String> takeRandomLineFromTextDocument(BufferedReader reader) throws IOException {
        ArrayList<String> list = new ArrayList<>();
        while ((reader.readLine()) != null) {
            list.add(reader.readLine());
        }
        Collections.shuffle(list);

        return list;
    }
    /**
     * Method works chat.
     */
    public void workChat(File text, File log) {
        System.out.println("Please, let's begin chat with bot.");
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(text), StandardCharsets.UTF_8));
             Scanner scanner = new Scanner(System.in);
             BufferedWriter writer = new BufferedWriter(new FileWriter(log))) {

            ArrayList<String> list = takeRandomLineFromTextDocument(reader);
            boolean isNeedSave = false;
            while (scanner.hasNext()) {
                String phrase = scanner.nextLine();
                switch (phrase.toLowerCase()) {
                    case END:
                        writer.write(String.format("User: %s%s", phrase, System.lineSeparator()));
                        break;
                    case STOP:
                        isNeedSave = true;
                        break;
                    case CONTINUE:
                        isNeedSave = false;
                        break;
                }
                if (isNeedSave) {
                    writer.write(String.format("User: %s%s", phrase, System.lineSeparator()));
                } else {
                    writer.write(String.format("User: %s%s", phrase, System.lineSeparator()));
                    String result = list.get(generateId(list.size()));
                    writer.write(String.format("Program: %s%s", result, System.lineSeparator()));
                    System.out.println(result);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Main menu in this program.
     */
    public static void main(String[] args) {
        new Chat().workChat(TEXT, LOG);
    }
}