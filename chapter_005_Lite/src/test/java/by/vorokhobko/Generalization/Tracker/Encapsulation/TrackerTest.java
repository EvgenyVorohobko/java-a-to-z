package by.vorokhobko.Generalization.Tracker.Encapsulation;

import by.vorokhobko.Generalization.Tracker.Encapsulation.models.Item;
import by.vorokhobko.Generalization.Tracker.Encapsulation.start.Tracker;
import org.junit.Test;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @version 1.
 * @since 23.02.2017.
 */
public class TrackerTest {
	 /**
     * Test.
     */
	@Test
	public void whenItIsNecessaryToAddOneRequest() {
		Tracker tracker = new Tracker();
		Item itemFirst = new Item("first task", "first desc", 1L);
		tracker.add(itemFirst);
		assertThat(tracker.findAll().get(0), is(itemFirst));
	}
	 /**
     * Test.
     */
	 @Test
	 public void whenYouNeedToUpdateTheQueryOne() {
		 Tracker tracker = new Tracker();
		 Item itemSecond = new Item("second task", "second desc", 1L);
		 tracker.add(itemSecond);
		 Item itemUpdate = new Item("update task", "update desc", 2L);
		 itemUpdate.setId(itemSecond.getId());
		 tracker.update(itemUpdate);
		 List<Item> list = tracker.findAll();
		 assertThat(itemUpdate, is(list.get(0)));
	 }
	 /**
     * Test.
     */
	 @Test
	 public void whenItIsNecessaryToRemoveOneStatement() {
		 Tracker tracker = new Tracker();
		 Item itemSecond = new Item("second task", "second desc", 1L);
		 Item itemUpdate = new Item("update task", "update desc", 2L);
		 tracker.add(itemSecond);
		 tracker.add(itemUpdate);
		 List<Item> list = tracker.findAll();
		 assertThat(itemUpdate.getId(), is(list.get(1).getId()));
		 tracker.delete(itemSecond);
		 assertThat(itemUpdate.getId(), is(list.get(0).getId()));
	 }
	 /**
     * Test.
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
		 assertThat(id, is(tracker.findById(id).getId()));
	 }
	 /**
     * Test.
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
		 List<Item> list = tracker.findByName("first task");
		 List<Item> array = tracker.findAll();
		 assertThat(list.get(0), is(array.get(0)));
	 }
	 /**
     * Test.
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
		 List<Item> list = tracker.findAll();
		 assertThat(list, is(tracker.findAll()));
	 }
}