package ejercicios.clase3.ex3;

import java.util.Objects;

public abstract class Vegetable extends Food {  // hereda de Food (atributos: nombre y precio)
    private final VegetableType type;           // enums sobre tipo de verdura

    public Vegetable (VegetableType type, double pricePerKg, String name) {     // constructor
        super(pricePerKg, name);        // el super es Food
        this.type = type;               // atributo de solo esta clase
    }

    @Override
    public boolean equals(Object obj) {             // sobreescribo el método que compara las verduras
        if (!(obj instanceof Vegetable)) {          // si el objeto no se encuentra acá...
            return false;
        }

        final Vegetable other = (Vegetable) obj;    // otro vegetal = al objeto recibido

        return this.name.equals(other.name);        // true si coinciden, false si no
    }

    @Override
    public int hashCode() {         // compara a ver si ya tiene la verdura
        return Objects.hashCode(super.name);
    }  // comparo sólo nombre
}
