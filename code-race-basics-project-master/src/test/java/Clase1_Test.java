import ejercicios.Clase1_EjercicioCondicionales1;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Clase1_Test extends ConsoleOutputTest {

    @Test
    @DisplayName("exercise1 | given 5 | should output true")
    void executeExercise1Case5() {
        // given
        Clase1_EjercicioCondicionales1.executeExercise1(5);

        //then
        assertConsoleOutput(true);
    }


    @Test
    @DisplayName("exercise1 | given 10 | should output true")
    void executeExercise1Case10() {
        // given
        Clase1_EjercicioCondicionales1.executeExercise1(10);

        //then
        assertConsoleOutput(true);
    }


    @Test
    @DisplayName("exercise1 | given -1 | should output nothing")
    void executeExercise1CaseMinus1() {
        // given
        Clase1_EjercicioCondicionales1.executeExercise1(-1);

        //then
        assertConsoleOutputNothing();
    }
}