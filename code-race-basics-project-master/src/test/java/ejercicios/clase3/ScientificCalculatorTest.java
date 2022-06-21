package ejercicios.clase3;

import ejercicios.clase3.ex1.ScientificCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScientificCalculatorTest {

    @Test
    @DisplayName("power | ok")
    void powerOk () {
        final ScientificCalculator calculator = new ScientificCalculator(3, 4);

        assertEquals(81, calculator.power());
    }

    @Test
    @DisplayName("root | ok")
    void rootOk () {
        final ScientificCalculator calculator1 = new ScientificCalculator(9, 2);
        final ScientificCalculator calculator2 = new ScientificCalculator(27, 3);

        assertEquals(3, calculator1.root());
        assertEquals(3, calculator2.root());
    }

    @Test
    @DisplayName("divide 5 and 3 | round up | ok")
    void divideUpOk () {
        final ScientificCalculator calculator1 = new ScientificCalculator(5, 3, 1);
        final ScientificCalculator calculator2 = new ScientificCalculator(5, 3);

        assertEquals(1.67, calculator1.divide());
        assertEquals(1.67, calculator1.divide());
    }

    @Test
    @DisplayName("divide 5 and 3 | round down | ok")
    void divideDownOk () {
        final ScientificCalculator calculator1 = new ScientificCalculator(10.198, 2, 2);

        assertEquals(5.09, calculator1.divide());
    }

    @Test
    @DisplayName("divide 5 and 3 | round half up | ok")
    void divideHalfUpOk () {
        final ScientificCalculator calculator1 = new ScientificCalculator(1.633, 2, 3);

        assertEquals(3.27, calculator1.multiply());
    }
}
