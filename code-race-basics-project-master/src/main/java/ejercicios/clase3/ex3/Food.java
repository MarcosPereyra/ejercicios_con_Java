package ejercicios.clase3.ex3;

public abstract class Food {            // clase más alta, que heredan las Fruit y Vegetables
    private final double pricePerKG;    // precio
    protected final String name;        // nombre de fruta/verdura

    public Food(double pricePerKG, String name) {   // constructor que las inicializa
        this.pricePerKG = pricePerKG;
        this.name = name;
    }

    public double getPricePerKg () {
        return pricePerKG;
    }   // getter del precio
}

