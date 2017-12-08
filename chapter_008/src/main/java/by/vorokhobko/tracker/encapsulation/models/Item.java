package by.vorokhobko.tracker.encapsulation.models;

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
	private long id;
	/**
	* The class field.
	*/
	private String author;
	/**
	* The class field.
	*/
	private String description;
	/**
	* The class field.
	*/
	private long creates;
	/**
	* Create an overloaded constructor.
	* Add Item.
	*/
	public Item() {
	}
	/**
	* Add Item.
	* @param author - name.
	* @param description - description.
	* @param creates - create.
	*/
	public Item(String author, String description, long creates) {
		this.author = author;
		this.description = description;
		this.creates = creates;
	}
	/**
	* Add getter Name.
	* @return tag.
	*/
	public String getAuthor() {
		return this.author;
	}
	/**
	* Add setter Name.
	* @param author - name.
	*/
	public void setAuthor(String author) {
        this.author = author;
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
	public long getCreates() {
		return this.creates;
	}
	/**
	* Add setter Create.
	* @param creates - create.
	*/
	public void setCreates(long creates) {
        this.creates = creates;
    }
	/**
	* Add getter Id.
	* @return tag.
	*/
	public long getId() {
		return this.id;
	}
	/**
	* Add setter Id.
	* @param id - id.
	*/
	public void setId(long id) {
		this.id = id;
	}
}