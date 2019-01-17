package by.vorokhobko.fit;

import org.junit.Test;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

public class FitTest {
    /**
     * @Test.
     */
    @Test
    public void manWeight() {
        Fit fit = new Fit();
        double weight = fit.manWeight(180);
        assertThat(weight, closeTo(92.0, 0.1));
    }
    /**
     * @Test.
     */
    @Test
    public void womanWeight() {
        Fit fit = new Fit();
        double weight = fit.womanWeight(170);
        assertThat(weight, closeTo(69.0, 0.1));
    }
}