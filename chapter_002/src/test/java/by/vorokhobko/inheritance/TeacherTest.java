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

public class TeacherTest {
    /**
     * @Test.
     */
    @Test
    public void whenTheTeacherGoesToTraining() {
        Teacher teacher = new Teacher("Zuk", 46, "Masherova", "page 12", 3);
        int refTrain = 2;
        teacher.setRefTrain(refTrain);
        int result = teacher.getRefTrain();
        assertThat(result, is(refTrain));
    }
}
