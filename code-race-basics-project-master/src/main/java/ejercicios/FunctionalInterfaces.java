package ejercicios;

import menu.Menu;
import util.IOUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static util.IOUtil.print;
import static util.IOUtil.stringInput;

public class FunctionalInterfaces {
    public static void suscribeToMenu(Menu mainMenu) {
        final Menu excercises = new Menu("Clase de Interfaces Funcionales", mainMenu);

        excercises.addItem("Ejemplo 1", FunctionalInterfaces::example1);
        excercises.addItem("Ejemplo 2", FunctionalInterfaces::example2);
        excercises.addItem("Ejemplo 3", FunctionalInterfaces::example3);
        excercises.addItem("Ejemplo 4", FunctionalInterfaces::example4);
    }

    public static void example1 () {

        executeSomething(() -> {
            String promptMessage = "Ingrese su nombre";
            String name = stringInput(promptMessage);

            print("Hola " + name);
        });
    }

    private static void executeSomething (Runnable action) {        // aquello que recibe, lo ejecuta
        action.run();
    }

    // --------------------------------------------------------------

    public static void example2 () {

    doThisWithName(n -> sayHelloTo(n));          // se ejecuta doThisWithName, y adentro se ejecuta sayHelloTo

    }

    private static void sayHelloTo (String name) {
        print("Hola " + name);
    }
    private static void doThisWithName (Consumer<String> consumer) {
        final String name = stringInput("Ingrese su nombre:");

        consumer.accept(name);
    }

    // --------------------------------------------------------------

    public static void example3 () {

        List<Integer> integerList = new ArrayList<>();
        integerList.add(2);
        integerList.add(22);
        integerList.add(222);

        iterateOverListAndDO(integerList, i -> print(i));         // puedo reutilizar la interfaz
        iterateOverListAndDO(integerList, i -> print(i + 1));
        iterateOverListAndDO(integerList, i -> print(i - 1));

        // lo anterior es lo mismo que
        integerList.forEach(i -> print(i));
        integerList.forEach(i -> print(i + 1));
        integerList.forEach(i -> print(i - 1));
    }

    private static void iterateOverListAndDO (List<Integer> integerList, Consumer<Integer> consumer) {
        for (Integer num : integerList) {
            consumer.accept(num);
        }
    }

    // -----------------------------------------------------

    public static void example4 () {

        List<Integer> integerList = new ArrayList<>();
        integerList.add(2);
        integerList.add(22);
        integerList.add(222);

        integerList.stream()
                .map(i -> "El número es: " + i)      // hago un Map con cada dato de la lista
                .forEach(IOUtil::print);            // imprimo cada uno
    }
}
