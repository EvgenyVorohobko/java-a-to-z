package by.vorokhobko.Polymorphism;
/**
 * Paint.
 *
 * Class Paint draws in the drawing figures part 002, lesson 5.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 04.04.2017.
 * @version 1.
 */
public class Paint {
    /**
     * The class field.
     * Сreating shape.
     */
    private Shape shape;
    /**
     * Сreate the class constructor Paint.
     * @param shape - shape.
     */
    public Paint(Shape shape) {
        this.shape = shape;
    }
    /**
     * The method draws figures.
     * @param shape - shape.
     */
    public void draw(Shape shape) {
        System.out.print(shape.pic(shape));
    }
}