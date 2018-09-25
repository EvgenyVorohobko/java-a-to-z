package by.vorokhobko.models;

import java.sql.Timestamp;

/**
 * Item.
 *
 * Class Item create element on toDolist part 010, lesson 1.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 11.09.2018.
 * @version 1.
 */
public class Item {
    /**
     * The class field.
     */
    private int id;
    /**
     * The class field.
     */
    private String description;
    /**
     * The class field.
     */
    private Timestamp createDate;
    /**
     * The class field.
     */
    private boolean done;
    /**
     * Add getter id.
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
     * Add getter description.
     * @return tag.
     */
    public String getDescription() {
        return description;
    }
    /**
     * Add setter setDescription.
     * @param description - description.
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * Add getter done.
     * @return tag.
     */
    public boolean isDone() {
        return done;
    }
    /**
     * Add setter setDone.
     * @param done - done.
     */
    public void setDone(boolean done) {
        this.done = done;
    }
    /**
     * Add getter createDate.
     * @return tag.
     */
    public Timestamp getCreateDate() {
        return createDate;
    }
    /**
     * Add setter setCreateDate.
     * @param createDate - createDate.
     */
    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }
}