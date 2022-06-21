import ejercicios.Clase2_Colecciones;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Clase2_Ej_Colecciones_Test {

    @Test
    @DisplayName("podio | given three names and their scores | positions")
    void exercise3() {
        // given
        final String name1 = "x";
        final String name2 = "y";
        final String name3 = "z";

        final int score1 = 1;
        final int score2 = 2;
        final int score3 = 3;

        // when
        final String result = Clase2_Colecciones.exercise3Positions(name1, name2, name3, score1, score2, score3);

        // then
        assertEquals("CHAMPION - z / SUB_CHAMPION - y / THIRD_PLACE - x", result);
    }


    @Test
    @DisplayName("colores combinados | given two colours | combinations")
    void exercise5Cases() {
        // given
        final String lighter = " claro";
        final String darker = " oscuro";

        final String rojo = "rojo";
        final String azul = "azul";
        final String amarillo = "amarillo";
        final String violeta = "violeta";
        final String verde = "verde";
        final String naranja = "naranja";

        // when
        final String result1 = Clase2_Colecciones.exercise5(rojo, azul, lighter, darker);
        final String result2 = Clase2_Colecciones.exercise5(amarillo, azul, lighter, darker);
        final String result3 = Clase2_Colecciones.exercise5(verde, violeta, lighter, darker);
        final String result4 = Clase2_Colecciones.exercise5(rojo, naranja, lighter, darker);
        final String result5 = Clase2_Colecciones.exercise5(azul, verde, lighter, darker);

        // then
        assertEquals("violeta", result1);
        assertEquals("verde", result2);
        assertEquals("marrón", result3);
        assertEquals("naranja oscuro", result4);
        assertEquals("verde oscuro", result5);
    }


    @Test
    @DisplayName("number conversion | given numbers | results should be texts ")
    void exercise7CasesNumbers() {
        // given
        final int numbers1 = 123;
        final int numbers2 = 536;

        // when
        final String result1 = Clase2_Colecciones.exercise7(numbers1, "");
        final String result2 = Clase2_Colecciones.exercise7(numbers2, "");

        // then
        assertEquals("UNO-DOS-TRES", result1);
        assertEquals("CINCO-TRES-SEIS", result2);

    }

    @Test
    @DisplayName("text conversion | given texts | results should be numbers ")
    void exercise7CasesTexts() {
        // given
        final String numbers1 = "SIETE-DOS-TRES";
        final String numbers2 = "OCHO-DOS-DOS";

        // when
        final String result1 = Clase2_Colecciones.exercise7(0, numbers1);
        final String result2 = Clase2_Colecciones.exercise7(0, numbers2);

        // then
        assertEquals("723", result1);
        assertEquals("822", result2);
    }
}