package Figurita;

public class Figurita {
    private int number;
    private boolean special;

    public Figurita (int number, boolean special) {
        this.number = number;
        this.special = special;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Figurita)) {   // comprueba que sea una figurita
            return false;
        }

        final Figurita other = (Figurita) obj;     // creo una variable que guarde dicha figurita (objeto)

        return this.number == other.number && this.special == other.special; // los comparo
    }

    @Override
    public String toString() {
        return number + " - " + (special ? "special" : "standard");
    }
}
