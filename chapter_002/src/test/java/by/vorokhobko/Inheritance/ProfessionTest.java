package by.vorokhobko.Inheritance;

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

public class ProfessionTest {
    /**
     * @Test.
     */
    @Test
    public void whenGetNewName() {
        Profession prof = new Profession("Nick", 22, "Colorado", "page 12", 2);
        String name = "Mixail";
        prof.setName(name);
        String result = prof.getName();
        assertThat(result, is(name));
    }
    /**
     * @Test.
     */
    @Test
    public void whenGetNewAge() {
        Profession prof = new Profession("Nick", 22, "Colorado", "page 12", 2);
        int age = 35;
        prof.setAge(age);
        int result = prof.getAge();
        assertThat(result, is(age));
    }
    /**
     * @Test.
     */
    @Test
    public void whenGetNewUniversity() {
        Profession prof = new Profession("Nick", 22, "Colorado", "page 12", 2);
        String university = "Novosibirsk";
        prof.setUniversity(university);
        String result = prof.getUniversity();
        assertThat(result, is(university));
    }
    /**
     * @Test.
     */
    @Test
    public void whenGetNewRecommendations() {
        Profession prof = new Profession("Nick", 22, "Colorado", "page 12", 2);
        String recommendations = "page 22";
        prof.setRecommendations(recommendations);
        String result = prof.getRecommendations();
        assertThat(result, is(recommendations));
    }
    /**
     * @Test.
     */
    @Test
    public void whenGetNewAScore() {
        Profession prof = new Profession("Nick", 22, "Colorado", "page 12", 2);
        int aScore = 8;
        prof.setAScore(aScore);
        int result = prof.getAScore();
        assertThat(result, is(aScore));
    }
}
