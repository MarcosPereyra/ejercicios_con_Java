package ejercicios.clase3.ex3;

import util.IOUtil;

import java.util.HashMap;
import java.util.Map;

public class Bolson {
    // constante de peso máximo del bolsón
    public static final int MAX_CAPACITY_IN_KG = 20;

    // Map con lista de frutas/verduras y sus pesos
    private final Map<Food, Double> kgByFood;

    // var. de precio final
    private double finalPrice;

    // método constructor (inicializa el Map y el valor inicial)
    public Bolson() {
        this.kgByFood = new HashMap<>();
        this.finalPrice = 0;
    }

    // método para añadir alimentos al bolsón (tipo y peso)
    public void addFood (Food food, double kg) {
        if (spaceAvailable(kg)) {                       // si no está lleno...
            if (kgByFood.containsKey(food)) {          // si contiene ya ese alimento...
                final double kgs = kgByFood.get(food);  // tomo el peso de ese alimento (value del Map)

                kgByFood.put(food, kgs + kg);           // y los sumo
            } else {
                kgByFood.put(food, kg);                 // si no lo tiene, lo agrego
            }

            this.finalPrice += food.getPricePerKg() * kg;       // retorno el precio total (precio individual * kilos recibido)
        } else {
            IOUtil.print(String.format("No hay capacidad para almacenar %s kgs", kg));      // si está lleno el bolsón, aviso
        }
    }

    // getter del precio final
    public double getFinalPrice () {
        return finalPrice;
    }

    // getter del Map del bolsón
    protected Map<Food, Double> getKgByFood() {
        return kgByFood;
    }

    // método para saber si hay lugar o no en el bolsón
    private boolean spaceAvailable(double kg) {     // recibe un peso y compara
        final double totalKgInBolson = kgByFood.values().stream().reduce(0d, Double::sum); // empiezo en cero y voy acumulando


        return totalKgInBolson + kg <= MAX_CAPACITY_IN_KG;  // retorna false o true
    }
}
