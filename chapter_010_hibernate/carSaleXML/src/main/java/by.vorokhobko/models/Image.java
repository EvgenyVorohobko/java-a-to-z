package by.vorokhobko.models;

/**
 * Image.
 *
 * Class Image create element in area car sales part 010, lesson 2.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 14.10.2018.
 * @version 1.
 */
public class Image {
    /**
     * The class field.
     */
    private int id;
    /**
     * The class field.
     */
    private String URLImage;
    /**
     * Add constructor.
     */
    public Image() {}
    /**
     * Add getter getId.
     * @return tag.
     */
    public int getId() {
        return id;
    }
    /**
     * Add setter setId.
     * @param id - id.
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * Add getter.
     * @return tag.
     */
    public String getURLImage() {
        return URLImage;
    }
    /**
     * Add setter.
     * @param URLImage - URLImage.
     */
    public void setURLImage(String URLImage) {
        this.URLImage = URLImage;
    }
}