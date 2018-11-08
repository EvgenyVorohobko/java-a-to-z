package by.vorokhobko.models;

/**
 * Transmission.
 *
 * Class Transmission create element in area car sales part 010, lesson 2.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 14.10.2018.
 * @version 1.
 */
public class Transmission {
    /**
     * The class field.
     */
    private int id;
    /**
     * The class field.
     */
    private String transmission;
    /**
     * Add constructor.
     */
    public Transmission() {}
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
     * Add getter transmission.
     * @return tag.
     */
    public String getTransmission() {
        return transmission;
    }
    /**
     * Add setter setTransmission.
     * @param transmission - transmission.
     */
    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }
}