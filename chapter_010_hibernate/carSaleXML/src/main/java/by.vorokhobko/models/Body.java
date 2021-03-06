package by.vorokhobko.models;

/**
 * Body.
 *
 * Class Body create element in area car sales part 010, lesson 2.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 14.10.2018.
 * @version 1.
 */
public class Body {
    /**
     * The class field.
     */
    private int id;
    /**
     * The class field.
     */
    private String body;
    /**
     * Add constructor.
     */
    public Body() {}
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
     * Add getter body.
     * @return tag.
     */
    public String getBody() {
        return body;
    }
    /**
     * Add setter setBody.
     * @param body - body.
     */
    public void setBody(String body) {
        this.body = body;
    }
}