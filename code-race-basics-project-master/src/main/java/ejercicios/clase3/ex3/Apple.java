package ejercicios.clase3.ex3;

public class Apple extends Fruit {                  // hereda: nombre, precio según estado y estado de la fruta
    public Apple(FruitState state) {
        super(state, 100, "apple");  // setea los atributos
    }
}
