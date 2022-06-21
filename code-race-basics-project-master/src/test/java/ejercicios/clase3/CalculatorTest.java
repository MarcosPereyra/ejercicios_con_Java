package ejercicios.clase3;

import ejercicios.clase3.ex1.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    @DisplayName("sum | ok")
    void sum() {
        final Calculator calculator1 = new Calculator(2, 7);

        assertEquals(9, calculator1.sum());
    }

    @Test
    @DisplayName("subtract | ok")
    void subtract() {
        final Calculator calculator1 = new Calculator(2, 7);

        assertEquals(-5, calculator1.subtract());
    }

    @Test
    @DisplayName("multiply | ok")
    void multiply() {
        final Calculator calculator1 = new Calculator(10, 5);

        assertEquals(50, calculator1.multiply());
    }

    @Test
    @DisplayName("divide | ok")
    void divide() {
        final Calculator calculator1 = new Calculator(14, 7);

        assertEquals(2, calculator1.divide());
    }
}