package ejercicios.clase3.ex3;

import java.util.Objects;

public abstract class Fruit extends Food {          // igual a Vegetable, excepto por el cambio de precio según el estado
    private final FruitState state;         // enum de estados de la fruta


    public Fruit(FruitState state, double pricePerKg, String name) {
        super(pricePerKg, name);
        this.state = state;
    }

    @Override
    public double getPricePerKg() {
        return super.getPricePerKg() * this.state.getPriceMultiplier(); // precio individual * precio según el estado
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Fruit)) {
            return false;
        }

        final Fruit other = (Fruit) obj;

        return this.name.equals(other.name) && this.state == other.state;
    }

    @Override
    public int hashCode() {         // compara a ver si ya tiene la fruta
        return Objects.hash(name, state);
    }  // comparo nombre y estado
}
