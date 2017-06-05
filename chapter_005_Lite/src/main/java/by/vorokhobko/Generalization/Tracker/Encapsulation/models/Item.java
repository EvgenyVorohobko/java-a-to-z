package by.vorokhobko.Generalization.Tracker.Encapsulation.models;

/**
 * Item.
 *
 * Class Item to create a basic data object part 002, lesson 3.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 24.02.2017.
 * @version 1.
 */

public class Item {
	/**
	* The class field.
	*/
	private String id;
	/**
	* The class field.
	*/
	private String name;
	/**
	* The class field.
	*/
	private String description;
	/**
	* The class field.
	*/
	private long create;
	/**
	* Create an overloaded constructor.
	* Add Item.
	*/
	public Item() {
	}
	/**
	* Add Item.
	* @param name - name.
	* @param description - description.
	* @param create - create.
	*/
	public Item(String name, String description, long create) {
		this.name = name;
		this.description = description;
		this.create = create;
	}
	/**
	* Add getter Name.
	* @return tag.
	*/
	public String getName() {
		return this.name;
	}
	/**
	* Add setter Name.
	* @param name - name.
	*/
	public void setName(String name) {
        this.name = name;
	}
	/**
	* Add getter Description.
	* @return tag.
	*/
	public String getDescription() {
		return this.description;
	}
	/**
	* Add setter Description.
	* @param description - description.
	*/
	public void setDescription(String description) {
        this.description = description;
    }
	/**
	* Add getter Create.
	* @return tag.
	*/
	public long getCreate() {
		return this.create;
	}
	/**
	* Add setter Create.
	* @param create - create.
	*/
	public void setCreate(long create) {
        this.create = create;
    }
	/**
	* Add getter Id.
	* @return tag.
	*/
	public String getId() {
		return this.id;
	}
	/**
	* Add setter Id.
	* @param id - id.
	*/
	public void setId(String id) {
		this.id = id;
	}
}