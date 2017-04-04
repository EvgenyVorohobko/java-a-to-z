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
     * The class field.
     * Сreating sizeSquare.
     */
    private int sizeSquare;
    /**
     * Сreate the class constructor Square.
     * @param sizeSquare - sizeSquare.
     */
    public Square(int sizeSquare) {
        this.sizeSquare = sizeSquare;
    }
    /**
     * The method creates a square in the drawing.
     * @param shape - shape.
     * @return tag.
     */
    public String pic (Shape shape) {
        StringBuilder sb = new StringBuilder();
        for (int first = 0; first < sizeSquare; first++) {
            for (int second = 0; second < sizeSquare; second++) {
                if (first == 0 || first == sizeSquare - 1 || second == sizeSquare - 1 || second == 0) {
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