package by.vorokhobko.servletwithuser;

import java.util.Objects;

/**
 * Role.
 *
 * Class Role to create a user with different descriptions part 004, lesson 2.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 21.01.2018.
 * @version 1.
 */
public class Role {
    /**
     * The class field.
     */
    private int id;
    /**
     * The class field.
     */
    private String name;
    /**
     * Add constructor.
     * @param name - name.
     * @param id - id.
     */
    public Role(int id, String name) {
        this.id = id;
        this.name = name;
    }
    /**
     * Add constructor.
     * @param name - name.
     */
    public Role(String name) {
        this.name = name;
    }
    /**
     * Add getter password.
     * @return tag.
     */
    public int getId() {
        return id;
    }
    /**
     * Add getter password.
     * @return tag.
     */
    public String getName() {
        return name;
    }
    /**
     * Add setter setId.
     * @param id - id.
     */
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return id == role.id &&
                Objects.equals(name, role.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}