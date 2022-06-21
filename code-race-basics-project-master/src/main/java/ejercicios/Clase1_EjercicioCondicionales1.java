package ejercicios;
import menu.Menu;
import util.IOUtil;

public class Clase1_EjercicioCondicionales1 {

    public static void subscribeToMenu(Menu mainMenu) {
        final Menu exercises = new Menu("Ejercicios, clase 1", mainMenu);  // creo un menú

        exercises.addItem("Ejercicio 1", Clase1_EjercicioCondicionales1::exercise1);  // añado el ejercicio a mi menú
        exercises.addItem("Ejercicio 2", Clase1_EjercicioCondicionales1::exercise2);
        exercises.addItem("Ejercicio 3", Clase1_EjercicioCondicionales1::exercise3);
        exercises.addItem("Ejercicio 4", Clase1_EjercicioCondicionales1::exercise4);
        exercises.addItem("Ejercicio 5", Clase1_EjercicioCondicionales1::exercise5);
        exercises.addItem("Ejercicio 6", Clase1_EjercicioCondicionales1::exercise6);
        exercises.addItem("Ejercicio 7", Clase1_EjercicioCondicionales1::exercise7);
        exercises.addItem("Ejercicio 8", Clase1_EjercicioCondicionales1::exercise8);
        exercises.addItem("Ejercicio 9", Clase1_EjercicioCondicionales1::exercise9);
        exercises.addItem("Ejercicio 10", Clase1_EjercicioCondicionales1::exercise10);

    }

    //1. Ingresar un número entero. En caso de ser positivo indicar ‘true’ por pantalla.
    // HECHO
    private static void exercise1() {
        int number = IOUtil.intInput("Ingrese un número entero");

        executeExercise1(number);
    }

    public static void executeExercise1 (int num) {
        if (isPositive(num)) {
            printTrue();
        }
    }


    //2. Ingresar un número entero. En caso de ser positivo indicar ‘true’ por pantalla.
    // En caso de ser negativo, y sólo si está entre -10 y -20, indicar ‘true’ por pantalla.
    // HECHO
    public static void exercise2() {
        int number = IOUtil.intInput("Ingrese un número entero");

        if (isPositive(number)) {
            printTrue();
        } else if (number < -10 && number > -20) {
            printTrue();
        }
    }


    //3. Ingresar un número entero. En caso de ser positivo y mayor que 10 indicar true por pantalla.
    // HECHO
    public static void exercise3() {
        int number = IOUtil.intInput("Ingrese un número entero");

        if (isPositive(number)) {
            if (number > 10) {
                printTrue();
            }
        }
    }


    //4. Ingresar dos números, 'a' y 'b'. En caso de que 'a' sea positivo, mostrar 'true' si 'b' es positivo.
    // En caso de que 'a' sea negativo, mostrar 'true' si 'b' es negativo.
    // HECHO
    public static void exercise4() {
        int numberA = IOUtil.intInput("Ingrese un primer número entero");
        int numberB = IOUtil.intInput("Ingrese un segundo número entero");

        if (isPositive(numberA)) {
            if (isPositive(numberB)) {
                printTrue();
            }
        } else if (numberB < 0) {
            printTrue();
        }
    }


    //5. Ingresar tres números. Mostrar “true” cada vez que el número ingresado sea par.
    // HECHO
    public static void exercise5() {
        int number1 = IOUtil.intInput("Ingrese un primer número");
        if (isEven(number1)) {
            printTrue();
        }

        int number2 = IOUtil.intInput("Ingrese un segundo número");
        if (isEven(number2)) {
            printTrue();
        }

        int number3 = IOUtil.intInput("Ingrese un tercer número");
        if (isEven(number3)) {
            printTrue();
        }
    }


    //6. Ingresar dos números, 'a' y 'b'. En caso de que ambos sean positivos,
    // para cada uno mostrar 'true' si el resultado de sumarle 1 es par.
    // De modo contrario hacer la misma operación pero sólo para 'a'.
    // HECHO
    public static void exercise6() {
        int numberA = IOUtil.intInput("Ingrese un número a");
        int numberB = IOUtil.intInput("Ingrese un número b");

        if (isEven(numberA + 1)) {
            printTrue();
        }
        if (isPositive(numberA) && isPositive(numberB) && (isEven(numberB + 1))) {
            printTrue();
        }
    }


    //7. Ingresar tres números 'a', 'b' y 'c'.
    // En caso de que 'a' sea positivo y la suma de 'b' y 'c' sea un número positivo, mostrar 'true'.
    // Si esto último no sucede pero la resta entre 'a' y 'b' es negativa, también mostrar 'true'.
    // En todos los demás casos indicar por pantalla si la resta de los tres números es igual a 0.
    // HECHO
    public static void exercise7() {
        int a = IOUtil.intInput("Ingrese un número a");
        int b = IOUtil.intInput("Ingrese un número b");
        int c = IOUtil.intInput("Ingrese un número c");

        if (isPositive(a)) {
            if (isPositive(b + c) || (a - b) < 0) {
                printTrue();
            }
        }


        if ((a - b - c) == 0) {
            IOUtil.print("La resta de " + a + ", " + b + " y " + c + " es igual a 0.");
        }

    }


    //8. Ingresar dos colores. Pueden ser los tres primarios o sus combinaciones.
    // Si los dos colores son primarios, devolver el color que se forma.
    // Si uno es secundario y el otro es uno de sus primarios, devolver el secundario sumándole "claro"/"oscuro"
    // según sea el caso. Si los dos son secundarios, o si uno es primario pero no forma parte del secundario,
    // devolver 'marrón'. Si alguno es inexistente, indicar "error". Pista -> pasar a minúscula.

    // HECHO
    public static void exercise8() {
        String color1 = IOUtil.stringInput("Ingrese un color").toLowerCase();
        String color2 = IOUtil.stringInput("Ingrese otro color").toLowerCase();

        final String rojo = "rojo";
        final String azul = "azul";
        final String amarillo = "amarillo";

        final String naranja = "naranja";
        final String verde = "verde";
        final String violeta = "violeta";

        final String marron = "marrón";
        final String error = "error";

        final String masOscuro = "más oscuro";
        final String masClaro = "más claro";

        if (!rojo.equals(color1) && !azul.equals(color1) && !amarillo.equals(color1) &&
                !violeta.equals(color1) && !naranja.equals(color1) && !verde.equals(color1)) {
            IOUtil.print(error);
            return;
        } else if (!rojo.equals(color2) && !azul.equals(color2) && !amarillo.equals(color2) &&
                !violeta.equals(color2) && !naranja.equals(color2) && !verde.equals(color2)) {
            IOUtil.print(error);
            return;
        }


        final String userInput = color1 + color2;

        if (color1.equals(color2)) {
            IOUtil.print(color1);
        }


        switch (userInput) {
            case rojo + amarillo:
            case amarillo + rojo:
                IOUtil.print(naranja);
                break;
            case rojo + azul:
            case azul + rojo:
                IOUtil.print(violeta);
                break;
            case azul + amarillo:
            case amarillo + azul:
                IOUtil.print(verde);
                break;

            case verde + amarillo:
            case amarillo + verde:
                IOUtil.print(verde + masClaro);
                break;
            case verde + azul:
            case azul + verde:
                IOUtil.print(verde + masOscuro);
                break;
            case violeta + rojo:
            case rojo + violeta:
                IOUtil.print(violeta + masClaro);
                break;
            case naranja + rojo:
            case rojo + naranja:
                IOUtil.print(naranja + masOscuro);
                break;
            case azul + violeta:
            case violeta + azul:
                IOUtil.print(violeta + masOscuro);
                break;
            case amarillo + naranja:
            case naranja + amarillo:
                IOUtil.print(naranja + masClaro);
                break;

            default:
                IOUtil.print(marron);
        }

    }


    //9. Calculadora:
    //	Ingresar un texto: "sum", "subtract", "multiply", "divide", "percentage".
    //	Ingresar dos números y mostrar por pantalla el resultado de la operación.
    //	Mostrar "error" si la operación es inválida o si se divide por 0.

    // HECHO
    public static void exercise9() {
        final String sum = "sum";
        final String subtract = "subtract";
        final String multiply = "multiply";
        final String divide = "divide";
        final String percentage = "percentage";

        String operation = IOUtil.stringInput("Ingrese la operación a realizar").toLowerCase();

        if (!sum.equals(operation) && !subtract.equals(operation) &&     // reviso que cumpla con las operaciones válidas (no debe ser distinto (!))
                !multiply.equals(operation) && !divide.equals(operation) &&
                !percentage.equals(operation)) {
            IOUtil.print("Error");
            return;
        }

        double num1 = IOUtil.doubleInput("Ingrese el primer número");
        double num2 = IOUtil.doubleInput("Ingrese el segundo número");

        switch (operation) {
            case sum:
                IOUtil.print(num1 + num2);
                break;
            case subtract:
                IOUtil.print(num1 - num2);
                break;
            case multiply:
                IOUtil.print(num1 * num2);
                break;
            case divide:
                if (num1 != 0 && num2 != 0) {
                    IOUtil.print(num1 / num2);
                } else {
                    IOUtil.print("Error");
                }
                break;
            case percentage:
                if (num1 != 0 && num2 != 0) {
                    IOUtil.print((num1 / 100) * num2);
                } else {
                    IOUtil.print("Error");
                }
                break;
            default:
                IOUtil.print("Error");
        }
    }


    //10. Modelar el juego “piedra, papel o tijera”. Primero cada jugador ingresará su nombre.
    //Luego elige la opción primero el jugador uno y luego el dos. Mostrar por pantalla el ganador o error si ingresan una opción inválida.
    //En caso de empate, repetir el juego, y si se vuelve a empatar mostrar “Empate”.

    // REVISAR
    public static void exercise10() {
        final String player1 = IOUtil.stringInput("Jugador 1: ingrese su nombre");
        final String player2 = IOUtil.stringInput("Jugador 2: ingrese su nombre");

        ejecutarJuego(player1, player2);
    }

    private static void ejecutarJuego (String player1, String player2) {
        final String resultado = piedraPapelOTijera(player1, player2);

        if (resultado.equals("Error")) {
            IOUtil.print("Error");
        } else if (resultado.equals("Empate")){
            ejecutarJuego(player1, player2);                          // se llama a sí mismo, y así no termina hasta que no gane alguien
        } else {
            IOUtil.print("El ganador es " + resultado);
        }
    }

        private static String piedraPapelOTijera (String player1, String player2) {
            String ganador = "";

            final String piedra = "piedra";
            final String papel = "papel";
            final String tijera = "tijera";

            final String player1Option = IOUtil.stringInput(player1 + ": ¿piedra, papel o tijera?").toLowerCase();
            if (!piedra.equals(player1Option) && !papel.equals(player1Option) && !tijera.equals(player1Option)) {
                return "Error";
            }
            final String player2Option = IOUtil.stringInput(player2 + ": ¿piedra, papel o tijera?").toLowerCase();
            if (!piedra.equals(player2Option) && !papel.equals(player2Option) && !tijera.equals(player2Option)) {
                return "Error";
            }


            switch (player1Option) {
                case piedra:
                    if (player2Option.equals(papel)) {
                        ganador = player2;
                    } else if (player2Option.equals(tijera)) {
                        ganador = player1;
                    } else {
                        ganador = "Empate";
                    }
                    break;
                case papel:
                    if (player2Option.equals(piedra)) {
                        ganador = player1;
                    } else if (player2Option.equals(tijera)) {
                        ganador = player2;
                    } else {
                        ganador = "Empate";
                    }
                    break;
                case tijera:
                    if (player2Option.equals(piedra)) {
                        ganador = player2;
                    } else if (player2Option.equals(papel)) {
                        ganador = player1;
                    } else {
                        ganador = "Empate";
                    }
                    break;
            }
            return ganador;
        }


    // métodos privados
    private static boolean isEven(int num){
        return num % 2 == 0;
    }

    private static boolean isPositive(int num) {
        return num > 0;
    }

    private static void printTrue() {
        IOUtil.print(true);
    }
}



