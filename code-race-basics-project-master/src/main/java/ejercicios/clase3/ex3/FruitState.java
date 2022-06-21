package ejercicios.clase3.ex3;

public enum FruitState {
    GREEN(0.9), FRESH(1), RIPE(0.85);       // enums con atributos

    private final double priceMultiplier;

    FruitState(double priceMultiplier) {
        this.priceMultiplier = priceMultiplier;
    }

    public double getPriceMultiplier () {
        return priceMultiplier;
    }
}
