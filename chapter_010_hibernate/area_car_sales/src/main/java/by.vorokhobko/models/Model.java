package by.vorokhobko.models;

import javax.persistence.*;

/**
 * GetModel.
 *
 * Class GetModel create element in area car sales part 010, lesson 2.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 14.10.2018.
 * @version 1.
 */
@Entity
@Table(name = "model")
public class Model {
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
    @Column(name = "modelCar")
    private String modelCar;
    /**
     * Add constructor.
     */
    public Model() {}
    /**
     * Add constructor.
     */
    public Model(int id) {
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
     * Add getter getModelCar.
     * @return tag.
     */
    public String getModelCar() {
        return modelCar;
    }
    /**
     * Add setter setModelCar.
     * @param modelCar - modelCar.
     */
    public void setModelCar(String modelCar) {
        this.modelCar = modelCar;
    }
}