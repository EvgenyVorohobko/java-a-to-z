package by.vorokhobko.models;

import javax.persistence.*;

/**
 * Location.
 *
 * Class Location create element in area car sales part 010, lesson 2.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 14.10.2018.
 * @version 1.
 */
@Entity
@Table(name = "location")
public class Location {
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
    @Column(name = "location")
    private String location;
    /**
     * Add constructor.
     */
    public Location() {}
    /**
     * Add constructor.
     */
    public Location(int idLocation) {
        this.id = idLocation;
    }
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