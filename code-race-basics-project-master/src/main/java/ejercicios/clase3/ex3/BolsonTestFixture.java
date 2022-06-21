package ejercicios.clase3.ex3;

public class BolsonTestFixture {
    public final static Banana bananaRipe = new Banana(FruitState.RIPE);        // acá inicializo los objetos del test, según su estado de fruta
    public final static Banana bananaFresh = new Banana(FruitState.FRESH);

    public final static Apple appleGreen = new Apple(FruitState.GREEN);
    public final static Apple appleGreen2 = new Apple(FruitState.GREEN);

    public final static Potato potato = new Potato();
    public final static Carrot carrot = new Carrot();
}
