package by.vorokhobko.check;

import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * CheckEvenNumbers.
 *
 * Class CheckEvenNumbers to check the byte streame for 009_IO, lesson 1.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 17.07.2018.
 * @version 1.
 */
public class CheckEvenNumbers {
    /**
     * The method to check even number.
     * @param in - input stream.
     * @return tag.
     */
    public boolean isNumber(InputStream in) {
        boolean isNeedSave = false;
        try (Scanner scanner = new Scanner(in)) {
            int element = scanner.nextInt();
            if (element % 2 == 0) {
                isNeedSave = true;
            }
        } catch (Exception e) {
            throw new InputMismatchException("You enter not number!");
        }
        return isNeedSave;
    }
}