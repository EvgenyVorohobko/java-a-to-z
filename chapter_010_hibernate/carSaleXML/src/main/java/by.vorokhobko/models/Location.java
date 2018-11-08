package by.vorokhobko.models;

/**
 * Location.
 *
 * Class Location create element in area car sales part 010, lesson 2.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 14.10.2018.
 * @version 1.
 */
public class Location {
    /**
     * The class field.
     */
    private int id;
    /**
     * The class field.
     */
    private String location;
    /**
     * Add constructor.
     */
    public Location() {}
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
     * Add getter getLocation.
     * @return tag.
     */
    public String getLocation() {
        return location;
    }
    /**
     * Add setter setLocation.
     * @param location - location.
     */
    public void setLocation(String location) {
        this.location = location;
    }
}