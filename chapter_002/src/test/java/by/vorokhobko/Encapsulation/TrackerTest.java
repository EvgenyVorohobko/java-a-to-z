package by.vorokhobko.Encapsulation;

import by.vorokhobko.Encapsulation.models.Item;
import by.vorokhobko.Encapsulation.start.Tracker;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import org.junit.Test;

/**
 * Test.
 *
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @version 1.
 * @since 23.02.2017.
 */

public class TrackerTest {
	 /**
     * @Test.
     */
	@Test
	public void whenItIsNecessaryToAddOneRequest() {
		Tracker tracker = new Tracker();
		Item itemFirst = new Item("first task", "first desc", 1L);
		tracker.add(itemFirst);
		assertThat(itemFirst, is(tracker.findAll()[0]));
	}
	 /**
     * @Test.
     */
	 @Test
	 public void whenYouNeedToUpdateTheQueryOne() {
		 Tracker tracker = new Tracker();
		 Item itemSecond = new Item("second task", "second desc", 1L);
		 Item itemUpdate = new Item("update task", "update desc", 2L);
		 tracker.add(itemSecond);
		 itemUpdate.setId(itemSecond.getId());
		 tracker.update(itemUpdate);
		 assertThat(itemUpdate, is(tracker.findAll()[0]));
	 }
	 /**
     * @Test.
     */
	 @Test
	 public void whenItIsNecessaryToRemoveOneStatement() {
		 Tracker tracker = new Tracker();
		 Item itemSecond = new Item("second task", "second desc", 1L);
		 tracker.add(itemSecond);
		 tracker.delete(itemSecond);
		 assertThat(null, is(tracker.findAll()[0]));
	 }
	 /**
     * @Test.
     */
	 @Test
	 public void whenLookingForAnApplicationOnId() {
		 Tracker tracker = new Tracker();
		 Item itemFirst = new Item("first task", "first desc", 1L);
		 Item itemSecond = new Item("second task", "second desc", 2L);
		 Item itemThree = new Item("three task", "three desc", 3L);
		 tracker.add(itemFirst);
		 tracker.add(itemSecond);
		 tracker.add(itemThree);
		 String id = itemThree.getId();
		 assertThat(tracker.findById(id), is(itemThree));
	 }
	 /**
     * @Test.
     */
	 @Test
	 public void whenLookingForAnApplicationOnName() {
		 Tracker tracker = new Tracker();
		 Item itemFirst = new Item("first task", "first desc", 1L);
		 Item itemSecond = new Item("second task", "second desc", 2L);
		 Item itemThree = new Item("three task", "three desc", 3L);
		 tracker.add(itemFirst);
		 tracker.add(itemSecond);
		 tracker.add(itemThree);
		 String name = itemThree.getName();
		 assertThat(tracker.findByName(name), is(itemThree));
	 }
	 /**
     * @Test.
     */
	 @Test
	 public void whenLookingForAnApplicationAll() {
		 Tracker tracker = new Tracker();
		 Item itemFirst = new Item("first task", "first desc", 1L);
		 Item itemSecond = new Item("second task", "second desc", 2L);
		 Item itemThree = new Item("three task", "three desc", 3L);
		 tracker.add(itemFirst);
		 tracker.add(itemSecond);
		 tracker.add(itemThree);
		 Item[] items = new Item[]{itemFirst, itemSecond, itemThree};
		 assertThat(tracker.findAll(), is(items));
	 }
}