package by.vorokhobko.question;

import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Test.
 *
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @version 1.
 * @since 15.11.2017.
 */
public class ATMTest {
    /**
     * The class field.
     */
    private ATM atm = new ATM();
    /**
     * The class field.
     */
    private ArrayList<Integer> arrayList;
    /**
     * Test.
     * @throws NullException tag.
     */
    @Test
    public void whenATMGiveMeMoney1() throws NullException {
        int value = 50;
        int price = 35;
        arrayList = atm.changes(value, price);
        ArrayList<Integer> listControl  = new ArrayList<>();
        listControl.add(10);
        listControl.add(5);
        assertThat(listControl, is(arrayList));
    }
    /**
     * Test.
     * @throws NullException tag.
     */
    @Test
    public void whenATMGiveMeMoney2() throws NullException {
        int value = 100;
        int price = 35;
        arrayList = atm.changes(value, price);
        ArrayList<Integer> listControl  = new ArrayList<>();
        listControl.add(10);
        listControl.add(10);
        listControl.add(10);
        listControl.add(10);
        listControl.add(10);
        listControl.add(10);
        listControl.add(5);
        assertThat(listControl, is(arrayList));
    }
    /**
     * Test.
     * @throws NullException tag.
     */
    @Test
    public void whenATMGiveMeMoney3() throws NullException {
        int value = 100;
        int price = 22;
        arrayList = atm.changes(value, price);
        ArrayList<Integer> listControl  = new ArrayList<>();
        listControl.add(10);
        listControl.add(10);
        listControl.add(10);
        listControl.add(10);
        listControl.add(10);
        listControl.add(10);
        listControl.add(10);
        listControl.add(5);
        listControl.add(2);
        listControl.add(1);
        assertThat(listControl, is(arrayList));
    }
    /**
     * Test.
     * @throws NullException tag.
     */
    @Test
    public void whenATMGiveMeMoney4() throws NullException {
        int value = 35;
        int price = 3;
        arrayList = atm.changes(value, price);
        ArrayList<Integer> listControl  = new ArrayList<>();
        listControl.add(10);
        listControl.add(10);
        listControl.add(10);
        listControl.add(2);
        assertThat(listControl, is(arrayList));
    }
    /**
     * Test.
     * @throws NullException tag.
     */
    @Test(expected = NullException.class)
    public void whenATMDoNotGiveMeMoney() throws NullException {
        int value = 20;
        int price = 35;
        arrayList = atm.changes(value, price);
    }
}