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

public class DoctorTest {
    /**
     * @Test.
     */
    @Test
    public void whenTheDoctorComesIntern() {
        Doctor doctor = new Doctor("Nick", 43, "Oclaxoma", "page 13", 11);
        int internship = 3;
        doctor.setInternship(internship);
        int result = doctor.getInternship();
        assertThat(result, is(internship));
    }
    /**
     * @Test.
     */
    @Test
    public void whenTheDoctorComesResidency() {
        Doctor doctor = new Doctor("Maik", 39, "Visconsin", "page 11", 7);
        int residency = 2;
        doctor.setResidency(residency);
        int result = doctor.getResidency();
        assertThat(result, is(residency));
    }
}