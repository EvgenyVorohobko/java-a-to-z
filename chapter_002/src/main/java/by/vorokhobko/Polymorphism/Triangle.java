package by.vorokhobko.Polymorphism;
/**
 * Triangle.
 *
 * Class Triangle creates a triangle in the drawing part 002, lesson 5.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 04.04.2017.
 * @version 1.
 */
public class Triangle implements Shape {
    /**
     * The method creates a triangle in the drawing.
     * @param h - h.
     * @return tag.
     */
    public String pic (int h) {
        StringBuilder sb = new StringBuilder();
        for (int first = 0; first < h; first++) {
            for (int second = 0; second <= (h - second); second++) {
                sb.append(" ");
            }
            for (int three = 0; three <= first; three++) {
                sb.append("^ ");
            }
            sb.append(System.getProperty("line.separator"));
        }
        return sb.toString();
    }
}