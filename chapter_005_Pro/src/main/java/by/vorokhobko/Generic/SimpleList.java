package by.vorokhobko.Generic;

/**
 * SimpleList.
 *
 * Class SimpleList finish the containers SimpleList 005_Pro, lesson 2.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 19.06.2017.
 * @version 1.
 * @param <E>.
 */
public class SimpleList<E> {
	/**
	 * The class field.
	 */
	private Object[] objects;
	/**
	 * The class field.
	 */
	private int index = 0;
	/**
	 * Add constructor.
	 * @param size - size.
	 */
	public SimpleList(int size) {
		this.objects = new Object[size];
	}
	/**
	 * Add generic T in objects.
	 * @param value - value.
	 */
	public void add(E value) {
		this.objects[index++] = value;
	}
	/**
	 * Get generic E in position.
	 * @param position - position.
	 * @return tag.
	 */
	public E get(int position) {
		return (E) this.objects[position];
	}
	/**
	 * This generic delete one object.
	 * @param deleteValue - deleteValue.
	 */
	public void delete(E deleteValue) {
		for (int index = 0; index < objects.length; index++) {
			if (objects[index].equals(deleteValue)) {
				this.objects[index] = null;
				break;
			}
		}
	}
	/**
	 * This generic update one object.
	 * @param updateValue - updateValue.
	 * @param count - count.
	 */
	public void update(E updateValue, int count) {
		for (int index = 0; index < objects.length; index++) {
			if (index == count) {
				this.objects[index] = updateValue;
				break;
			}
		}
	}
}