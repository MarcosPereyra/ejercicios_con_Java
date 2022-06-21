package Animales;


// Dog dog1 = new Dog();

public class Dog extends Animal {       // Herencia

    // constructor
    public Dog(String name, boolean speaker) {
        super(name, speaker, "guau ");                       // llamo al constructor de Animal (se llama super())
    }
}
