package by.vorokhobko.models;

import javax.persistence.*;

/**
 * Engine.
 *
 * Class Engine create element in area car sales part 010, lesson 2.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 14.10.2018.
 * @version 1.
 */
@Entity
@Table(name = "engine")
public class Engine {
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
    @Column(name = "engineSize")
    private double engineSize;
    /**
     * Add constructor.
     */
    public Engine() {}
    /**
     * Add constructor.
     */
    public Engine(int idEngine) {
        this.id = idEngine;
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
     * Add getter getEngineSize.
     * @return tag.
     */
    public double getEngineSize() {
        return engineSize;
    }
    /**
     * Add setter setEngineSize.
     * @param engineSize - engineSize.
     */
    public void setEngineSize(double engineSize) {
        this.engineSize = engineSize;
    }
}
