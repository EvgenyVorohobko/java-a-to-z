package by.vorokhobko.Polymorphism;
/**
 * Square.
 *
 * Class Square creates a square in the drawing part 002, lesson 5.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 04.04.2017.
 * @version 1.
 */
public class Square implements Shape {
    /**
     * The method creates a square in the drawing.
     * @param h - h.
     * @return tag.
     */
    public String pic (int h) {
        StringBuilder sb = new StringBuilder();
        for (int first = 0; first < h; first++) {
            for (int second = 0; second < h; second++) {
                if (first == 0 || first == h - 1 || second == h - 1 || second == 0) {
                    sb.append("*");
                } else {
                    sb.append(" ");
                }
            }
            sb.append(System.getProperty("line.separator"));
        }
        return sb.toString();
    }
}