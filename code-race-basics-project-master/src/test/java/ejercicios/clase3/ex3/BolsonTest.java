package ejercicios.clase3.ex3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static ejercicios.clase3.ex3.BolsonTestFixture.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BolsonTest {

    @Test
    @DisplayName("addFood | ok")
    void addFood () {
        final Bolson bolson = new Bolson();         // creo un objeto Bolsón (un Map), usando el constructor

        bolson.addFood(bananaFresh, 5);         // creo las distintas frutas, pasando el objeto (en algunos con su estado) y los kilos que quiera
        bolson.addFood(bananaRipe, 3);
        bolson.addFood(potato, 6);
        bolson.addFood(appleGreen, 1.5);
        bolson.addFood(appleGreen2, 2);
        bolson.addFood(carrot, 2);

        bolson.addFood(bananaFresh, 3); // no se puede agregar


        final Map<Food, Double> kgByFood = bolson.getKgByFood();            // creo un Map en el que guardo el bolsón creado arriba, porque el
                                                                            // bolsón original es "private"
        assertAll("Expected bolson",
                () -> assertEquals(5, kgByFood.size()),             // veo su tamaño (5 alimentos)
                () -> assertEquals(5, kgByFood.get(bananaFresh)),   // 5 kilos de banana fresca
                () -> assertEquals(3, kgByFood.get(bananaRipe)),    // 3 kilos de banana pasada
                () -> assertEquals(6, kgByFood.get(potato)),        // 6 kilos de papa
                () -> assertEquals(3.5, kgByFood.get(appleGreen)),  // 3.5 kilos de manzana madura
                () -> assertEquals(2, kgByFood.get(carrot))         // 2 kilos de zanahoria
                );
    }

    @Test
    @DisplayName("getFinalPrice | ok")
    void getFinalPrice () {
        final Bolson bolson = new Bolson();

        bolson.addFood(bananaFresh, 5); // 750  -> precios totales de cada alimento (precio individual * precio de estado)
        bolson.addFood(bananaRipe, 3); // 382.5
        bolson.addFood(potato, 6); // 480
        bolson.addFood(appleGreen, 1.5); // 315
        bolson.addFood(appleGreen2, 2);
        bolson.addFood(carrot, 2); // 60

        final double finalPrice = bolson.getFinalPrice();  // acá calculo los precios, de cada elemento del Map

        assertEquals(1987.5, finalPrice);
    }
}