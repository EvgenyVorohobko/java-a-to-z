package by.vorokhobko.lamda;

import org.junit.Test;

import java.util.List;

public class CountFunctionTest {

    private CountFunction function = new CountFunction();
    @Test
    public void solution() {
        List<Double> resultLine = this.function.diapason(-5, 5, x -> 1D * x + 2D);
        List<Double> resultSquad = this.function.diapason(-5, 5, x -> 1D * Math.pow(x, 2) + 2 * x + 2D);
        List<Double> resultLog = this.function.diapason(1, 10,  Math::log);

        System.out.println("Line function in range " + resultLine);
        System.out.println("Squad function in range " + resultSquad);
        System.out.println("Log function in range " + resultLog);
    }
}