package by.vorokhobko.models;

import javax.persistence.*;

/**
 * Transmission.
 *
 * Class Transmission create element in area car sales part 010, lesson 2.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 14.10.2018.
 * @version 1.
 */
@Entity
@Table(name = "transmission")
public class Transmission {
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
    @Column(name = "transmission")
    private String transmission;
    /**
     * Add constructor.
     */
    public Transmission() {}
    /**
     * Add constructor.
     */
    public Transmission(int id) {
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