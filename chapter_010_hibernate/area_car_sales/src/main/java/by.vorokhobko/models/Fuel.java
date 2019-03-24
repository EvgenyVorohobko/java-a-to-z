package by.vorokhobko.models;

import javax.persistence.*;

/**
 * GetFuel.
 *
 * Class GetFuel create element in area car sales part 010, lesson 2.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 14.10.2018.
 * @version 1.
 */
@Entity
@Table(name = "fuel")
public class Fuel {
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
    @Column(name = "fuel")
    private String fuel;
    /**
     * Add constructor.
     */
    public Fuel() {}
    /**
     * Add constructor.
     */
    public Fuel(int id) {
        this.id = id;
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
     * Add getter getFuel.
     * @return tag.
     */
    public String getFuel() {
        return fuel;
    }
    /**
     * Add setter setFuel.
     * @param fuel - fuel.
     */
    public void setFuel(String fuel) {
        this.fuel = fuel;
    }
}