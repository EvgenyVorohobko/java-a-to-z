package by.vorokhobko.encapsulation.start;

import by.vorokhobko.encapsulation.models.Item;
import java.util.Random;

/**
 * tracker.
 *
 * Class tracker a wrapper over an array part 002, lesson 3.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 24.02.2017.
 * @version 1.
 */

public class Tracker {
	/**
	* The class field.
	*/
	private Item[] items = new Item[10];
	/**
	* The class field.
	*/
	private int position = 0;
	/**
	* The class field.
	*/
	private static final Random RN = new Random();
	/**
	* The method the method generates random Id.
	* @return tag.
	*/
	public String generateId() {
		return String.valueOf(System.currentTimeMillis() + RN.nextInt());
	}
	/**
	* The method adds a cell to the array.
	* @param item - item.
	* @return tag.
	*/
	public Item add(Item item) {
		item.setId(this.generateId());
		this.items[position++] = item;
		return item;
	}
	/**
	* The method finds similar cells in the Id.
	* @param id - id.
	* @return tag.
	*/
	public Item findById(String id) {
		Item result = null;
		for (Item item : items) {
			if (item != null && item.getId().equals(id)) {
				result = item;
				break;
			}
		}
		return result;
	}
	/**
	* The method searches all cells.
	* @return tag.
	*/
	public Item[] findAll() {
		Item[] result = new Item[this.position];
		for (int index = 0; index != this.position; index++) {
			result[index] = this.items[index];
		}
		return result;
	}
	/**
	* The method looks up the cell name using the key.
	* @param key - key.
	* @return tag.
	*/
	public Item findByName(String key) {
		Item resultName = null;
		for (Item item : items) {
			if (item != null && key.equals(item.getName())) {
				resultName = item;
				break;
			}
		}
		return resultName;
	}
	/**
	* The method needs to replace the cell in the array.
	* @param item - item.
	*/
	public void update(Item item) {
		for (int index = 0; index < this.position; index++) {
			if (this.items[index].getId().equals(item.getId())) {
				this.items[index] = item;
				break;
			}
		}
	}
	/**
	* The method should delete the cells in the array.
	* @param itemDelete - itemDelete.
	*/
	public void delete(Item itemDelete) {
		for (int index = 0; index < this.position; index++) {
			if (this.items[index].getId().equals(itemDelete.getId())) {
				this.items[index] = null;
				break;
			}
		}
	}
}