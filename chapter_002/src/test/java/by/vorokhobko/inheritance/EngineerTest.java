package by.vorokhobko.inheritance;

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

public class EngineerTest {
    /**
     * @Test.
     */
    @Test
    public void whenTheTeacherGoesToTraining() {
        Engineer engineer = new Engineer("Masha", 33, "BNTU", "page 8", 11);
        int experience = 2;
        engineer.setExperience(experience);
        int result = engineer.getExperience();
        assertThat(result, is(experience));
    }
}
