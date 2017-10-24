package by.vorokhobko.generalization.tracker.encapsulation.start;

import by.vorokhobko.generalization.tracker.encapsulation.models.Item;
import java.util.ArrayList;
import java.util.List;
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
	private List<Item> items = new ArrayList<>();
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
	*/
	public void add(Item item) {
		item.setId(this.generateId());
		this.items.add(item);
	}
	/**
	* The method finds similar cells in the Id.
	* @param id - id.
	* @return tag.
	*/
	public Item findById(String id) {
		Item result = null;
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getId().equals(id)) {
				result = items.get(i);
			}
		}
		return result;
	}
	/**
	* The method searches all cells.
	* @return tag.
	*/
	public List<Item> findAll() {
		return items;
	}
	/**
	* The method looks up the cell name using the key.
	* @param key - key.
	* @return tag.
	*/
	public List<Item> findByName(String key) {
		List<Item> result = new ArrayList<>();
		for (int i = 0; i < items.size(); i++) {
			if (key.equals(items.get(i).getName())) {
				result.add(items.get(i));
			}
		}
		return result;
	}
	/**
	* The method needs to replace the cell in the array.
	* @param item - item.
	*/
	public void update(Item item) {
		for (int index = 0; index < items.size(); index++) {
			if (this.items.get(index).getId().equals(item.getId())) {
				this.items.set(index, item);
				break;
			}
		}
	}
	/**
	* The method should delete the cells in the array.
	* @param itemDelete - itemDelete.
	*/
	public void delete(Item itemDelete) {
		for (int index = 0; index < items.size(); index++) {
			if (this.items.get(index).getId().equals(itemDelete.getId())) {
				this.items.remove(index);
				break;
			}
		}
	}
}