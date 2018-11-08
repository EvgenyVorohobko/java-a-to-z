package by.vorokhobko.models;

/**
 * GetFuel.
 *
 * Class GetFuel create element in area car sales part 010, lesson 2.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 14.10.2018.
 * @version 1.
 */
public class Fuel {
    /**
     * The class field.
     */
    private int id;
    /**
     * The class field.
     */
    private String fuel;
    /**
     * Add constructor.
     */
    public Fuel() {}
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