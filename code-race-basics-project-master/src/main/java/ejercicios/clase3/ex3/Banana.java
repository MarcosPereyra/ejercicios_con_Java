package ejercicios.clase3.ex3;

public class Banana extends Fruit {
    public Banana(FruitState state) {                   // hereda: nombre, precio según estado y estado de la fruta
        super(state, 150, "banana");    // setea los atributos
    }
}
