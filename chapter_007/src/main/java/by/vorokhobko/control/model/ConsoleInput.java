package by.vorokhobko.control.model;

import java.util.Scanner;

/**
 * ConsoleInput.
 *
 * Class ConsoleInput program for communication with the user part 007, Control Question.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @version 1.
 * @since 05.11.2017.
 */
public class ConsoleInput {
    /**
     * The class field.
     * Сreating scanner.
     */
    private Scanner scanner = new Scanner(System.in);
    /**
     * Сreate the class question.
     * @param question - question.
     * @return tag.
     */
    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }
    /**
    * The method question askUser.
    * @param question - question.
    * @return tag.
    */
    public String askUser(String question) {
        String text = "";
        while (text.equals("w") & text.equals("s") & text.equals("a") & text.equals("d")) {
            text = ask(question);
        }
        return text;
    }
}