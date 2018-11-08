package by.vorokhobko.models;

/**
 * GetModel.
 *
 * Class GetModel create element in area car sales part 010, lesson 2.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 14.10.2018.
 * @version 1.
 */
public class Model {
    /**
     * The class field.
     */
    private int id;
    /**
     * The class field.
     */
    private String modelCar;
    /**
     * Add constructor.
     */
    public Model() {}
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