import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static clases.Clase3.isEven;
import static org.junit.jupiter.api.Assertions.*;

public class Clase3_Ejemplo_de_Test {

    @Test
    @DisplayName("sum | given 2 and 3 | result should be 5")
    public void sumOk () {
        // given
        int num1 = 2;
        int num2 = 3;

        // when
        final int sum = sum(num1, num2);

        // then
        assertEquals(5, sum);               // primero paso lo que espero, y después lo que pasó
    }

    private static int sum (int n1, int n2) {
        return n1 + n2;
    }


    @Test
    @DisplayName("isEven | true cases")
    public void isEvenTrueCases () {
        assertTrue(isEven(2));
        assertTrue(isEven(20));
        assertTrue(isEven(220));
    }
    @Test
    @DisplayName("isEven | false cases")
    public void isEvenFalseCases () {
        assertFalse(isEven(3));
        assertFalse(isEven(31));
        assertFalse(isEven(57));
    }
}