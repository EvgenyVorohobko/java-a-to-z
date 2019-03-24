package by.vorokhobko.models;

import javax.persistence.*;

/**
 * Image.
 *
 * Class Image create element in area car sales part 010, lesson 2.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 14.10.2018.
 * @version 1.
 */
@Entity
@Table(name = "image")
public class Image {
    /**
     * The class field.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    /**
     * The class field.
     */
    @Column(name = "URLImage")
    private String URLImage;
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