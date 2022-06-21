package ejercicios;

import menu.Menu;

import java.util.Random;

import static util.IOUtil.*;

public class Clase2_Ejercicios_Con_Listas {

    public static void suscribeToMenu(Menu mainMenu) {
        final Menu excercises = new Menu("Ejercicios, clase 2", mainMenu);

        excercises.addItem("Ejercicio 1", Clase2_Ejercicios_Con_Listas::exercise1);
        excercises.addItem("Ejercicio 2", Clase2_Ejercicios_Con_Listas::exercise2);
        excercises.addItem("Ejercicio 3", Clase2_Ejercicios_Con_Listas::exercise3);
        excercises.addItem("Ejercicio 4", Clase2_Ejercicios_Con_Listas::exercise4);
        excercises.addItem("Ejercicio 5", Clase2_Ejercicios_Con_Listas::exercise5);
        excercises.addItem("Ejercicio 6", Clase2_Ejercicios_Con_Listas::exercise6);
        excercises.addItem("Ejercicio 7", Clase2_Ejercicios_Con_Listas::exercise7);
        excercises.addItem("Ejercicio 8", Clase2_Ejercicios_Con_Listas::exercise8);
        excercises.addItem("Ejercicio 9", Clase2_Ejercicios_Con_Listas::exercise9);
        excercises.addItem("Ejercicio 10", Clase2_Ejercicios_Con_Listas::exercise10);
        excercises.addItem("Ejercicio 11", Clase2_Ejercicios_Con_Listas::exercise11);
        excercises.addItem("Ejercicio 12", Clase2_Ejercicios_Con_Listas::exercise12);
        excercises.addItem("Ejercicio 13", Clase2_Ejercicios_Con_Listas::exercise13);
        excercises.addItem("Ejercicio 15", Clase2_Ejercicios_Con_Listas::exercise15);
        excercises.addItem("Ejercicio 16", Clase2_Ejercicios_Con_Listas::exercise16);
        excercises.addItem("Ejercicio 17", Clase2_Ejercicios_Con_Listas::exercise17);
        excercises.addItem("Ejercicio 18", Clase2_Ejercicios_Con_Listas::exercise18);
        excercises.addItem("Ejercicio 19", Clase2_Ejercicios_Con_Listas::exercise19);
        excercises.addItem("Ejercicio 20", Clase2_Ejercicios_Con_Listas::exercise20);
    }


    // Ingresar un número. Mostrar todos los números hasta llegar a su opuesto.
    // HECHO
    private static void exercise1() {
        final int numIngresado = intInput("Ingrese un número entero:");
        int index = numIngresado;

        if (numIngresado > 0) {         // si es positivo
            while (index != (-numIngresado - 1)) {
                print(index);
                index--;
            }
        } else if (numIngresado < 0) {                        // si es negativo
            while (index != ((numIngresado * -1) + 1)) {
                print(index);
                index++;
            }
        } else {
            print("El número es 0; no puede realizarse la operación.");
        }

        /*  OPCIÓN 2
        final int num = intInput("Ingrese un número entero");
        final int oppositeNum = num * -1;

        final int step = num < 0 ? 1 : -1;

        int numToPrint = num;

        while(numToPrint != oppositeNum + step) {
            print(numToPrint);
            numToPrint += step;
        }
        */
    }


    // Ingresar un número. Mostrar todos los múltiplos de 2 de ese número.
    // HECHO
    private static void exercise2() {
        int num = intInput("Ingrese un número entero positivo:", i -> i > 0);

        for (int i = 2; i <= num; i += 2 ) {
            print(i);
        }
    }


    // Ingresar números, 0 para terminar. Indicar si el número ingresado es par.
    //Tip: para resolver el proceso de “ingresar números hasta que el ingreso sea 0” conviene utilizar while
    // HECHO
    private static void exercise3() {
        int numIngresado = 1;

        if (numIngresado != 0) {
            while (numIngresado != 0) {
                numIngresado = intInput("Ingrese un número (recuerde que si es 0, el programa finaliza).");
                if (numIngresado % 2 == 0) {
                    print("EL NÚMERO ES PAR");
                }
            }
            print("PROGRAMA FINALIZADO");
        } else {
            print("PROGRAMA FINALIZADO");
        }
    }


    // Ingresar números, 0 para terminar. Si el número es par, ingresar otro número e indicar si la suma
    // de ambos es par (IOUtil.print(true)). Si la suma es impar, o el primer número lo es, indicar que
    // es impar (IOUtil.print(false)).

    // HECHO
    private static void exercise4() {
        int num1 = intInput("Ingrese un número (si es 0, el programa finaliza).");

        while (num1 != 0) {             // mientras no sea 0, sigue
            if (num1 % 2 == 0) {        // si el primero es par
                final int num2 = intInput("El número es par. Ingrese un nuevo número, para sumar ambos (recuerde que si es 0, el programa finaliza).");

                print(num2 % 2 == 0);   // si el segundo es par -> true / si es impar -> false

            } else {
                    print(false);       // si el primero es impar
            }

            num1 = intInput("Ingrese un número (si es 0, el programa finaliza).");
        }
    }


    // Ingresar un texto. Mostrar la secuencia de caracteres de forma inversa.
    //Tip: para iterar sobre los caracteres de un texto se puede usar la función toCharArray()
    // de una variable String. Esto devuelve un array char[] con cada caracter en una posición.
    // Los char, al ser primitivos, se comparan con ==
    //final char[] charArray = myString.toCharArray();

    // HECHO
    private static void exercise5() {
        final String frase = stringInput("Ingrese una frase:");
        final char[] arrayCaracteres = frase.toCharArray();
        // si length es 8, el index debe ser 7; por lo que el 1 del length es 0 en el array
        int index = arrayCaracteres.length - 1;
        String resultado = "";

        while (index != -1) {
            resultado += arrayCaracteres[index];
            index--;
        }
        print(resultado);
    }


    // Ingresar un texto. Mostrar sólo las consonantes en mayúscula.
    // HECHO
    private static void exercise6() {
        char letraA = 'A';
        char letraE = 'E';
        char letraI = 'I';
        char letraO = 'O';
        char letraU = 'U';

        String frase = stringInput("Ingrese una frase:");
        char[] arrayDeLetras = frase.toCharArray();

        for (int i = 0; i < arrayDeLetras.length; i++) {
            if (Character.isUpperCase(arrayDeLetras[i])) {          // si es mayúscula...
                if (arrayDeLetras[i] != letraA || arrayDeLetras[i] != letraE || arrayDeLetras[i] != letraI    // si no es vocal minúscula
                        || arrayDeLetras[i] != letraO || arrayDeLetras[i] != letraU) {
                    print(arrayDeLetras[i]);
                }
            }
        }
    }


    // Ingresar un texto y una letra. Mostrar la cantidad de ocurrencias de esa
    // letra ignorando mayúsculas/minúsculas.

    // HECHO
    private static void exercise7() {
        int contador = 0;
        String frase = stringInput("Ingrese un texto:").toLowerCase();
        String letra = stringInput("Ahora ingrese una letra:", s -> s.length() == 1).toLowerCase();

        for (char c : frase.toCharArray()) {        // recorro el array de la frase
            final String stringValue = String.valueOf(c);   // convierto cada letra en string

            if (stringValue.equals(letra)) {                // lo comparo con la letra ingresada
                contador ++;
            }
        }
        print("Hay un total de " + contador + " letras '" + letra + "'.");

        /*  OPCIÓN 2
        final String text = stringInput("Ingrese un texto").toLowerCase();
        final String character = stringInput("Ingrese una letra", s -> s.length() == 1).toLowerCase();

        final int originalLength = text.length();
        final int lengthWithoutCharacter = text.replace(character, "").length();

        final int occurrencesOfCharacter = originalLength - lengthWithoutCharacter;

        print(occurrencesOfCharacter);
         */
    }


    // Ingresar un texto. Devolver un texto conteniendo las vocales primero
    // y luego las consonantes. Eliminar los espacios.
    // Ej.: entrada = “Hola Mundo” salida = “oauoHlMnd”

    // HECHO
    private static void exercise8() {
        char a = 'a';
        char e = 'e';
        char i = 'i';
        char o = 'o';
        char u = 'u';
        char empty = ' ';

        String frase = stringInput("Ingrese una frase:");
        char[] arrayLetras = frase.toCharArray();

        StringBuilder nuevaFrase = new StringBuilder();
        String nuevaLetra;

        for (int index = 0; index < arrayLetras.length; index++) {                 // SI ES VOCAL
            if (Character.toLowerCase(arrayLetras[index]) == a || Character.toLowerCase(arrayLetras[index]) == e
                    || Character.toLowerCase(arrayLetras[index]) == i || Character.toLowerCase(arrayLetras[index]) == o
                    || Character.toLowerCase(arrayLetras[index]) == u) {
                nuevaLetra = String.valueOf(arrayLetras[index]);
                nuevaFrase.append(nuevaLetra);
            }
        }
        // ya tengo todas las vocales
        for (int index = 0; index < arrayLetras.length; index++) {                 // SI ES CONSONANTE Y NO ES ESPACIO
            if (Character.toLowerCase(arrayLetras[index]) != a && Character.toLowerCase(arrayLetras[index]) != e
                    && Character.toLowerCase(arrayLetras[index]) != i && Character.toLowerCase(arrayLetras[index]) != o
                    && Character.toLowerCase(arrayLetras[index]) != u && Character.toLowerCase(arrayLetras[index]) != empty) {
                nuevaLetra = String.valueOf(arrayLetras[index]);
                nuevaFrase.append(nuevaLetra);
            }
        }
        print(nuevaFrase.toString());
    }


    // Ingresar números hasta que la suma de todos supere 100.
    // Tip: siempre que vea “hasta que” en una consigna ya pienso en un while...

    // HECHO
    private static void exercise9() {
        final int max = 100;
        int contador = 0;

        while (contador <= max) {
            contador += intInput("Ingrese un número mayor a 0:", i -> i > 0);
        }
        print("Ha superado el número 100 -> " + contador);
    }


    // Ingresar un número n. Ingresar n cantidad de caracteres. Mostrar la concatenación.
    //Ej.: ingreso 5. Muestro “Ingresar 5 caracteres”. Ingreso “a” “b” “c” “d” “e”. Muestro “abcde”

    // HECHO
    private static void exercise10() {
        int contador = 0;
        StringBuilder concat = new StringBuilder();
        int numIngresado = intInput("Ingrese un número entero positivo: ", i -> i > 0);

        while (contador < numIngresado) {       // NO ES <= PORQUE EL CONTADOR EMPIEZA DESDE 0
            String nuevoCarácter = stringInput("Ingrese un carácter:", s -> s.length() == 1);
            concat.append(nuevoCarácter);
            contador++;
        }
        print(concat.toString());
    }


    // Ingresar un número entero de 6 cifras. Mostrar la secuencia de números ordenada de forma ascendente.
    //Ej.: entrada = 874396, salida = 346789

    // HECHO
    private static void exercise11() {
        final int num = intInput("Ingrese un número de 6 cifras:", i -> i > 0 && String.valueOf(i).length() == 6);

        // LO CONVIERTO EN UN CHAR[]
        String numString = String.valueOf(num);
        char[] arrayChar = numString.toCharArray();

        // HAGO UN ORDENAMIENTO POR INSERCIÓN, COMPARANDO UN VALOR ACTUAL CON LOS SIGUIENTES, PARA VER SI ES MENOR, Y LOS INTERCAMBIO
        int pos;    // posición actual
        int aux;    // auxiliar donde guardo el dato encontrado
        for (int i = 0; i < arrayChar.length; i++) {   // repito el proceso 6 veces
            pos = i;        // posición actual
            aux = arrayChar[i];    // dato auxiliar que vamos comparando

            while (pos > 0 && arrayChar[pos - 1] > aux) {   // mientras la posición actual sea mayor a 0 y la posición de la izquierda sea mayor de la actual
                arrayChar[pos] = arrayChar[pos - 1];   // cambio a actual por la de la izquierda
                pos--;
            }
            arrayChar[pos] = (char) aux;  // volvemos a hacer el while
        }
        print(String.valueOf(arrayChar));
    }


    // Idem anterior indicando primero la cantidad de cifras a ingresar.
    // HECHO
    private static void exercise12() {
        int cantidadCifras = intInput("Ingrese la cantidad de cifras que quiera para su número:");
        while (cantidadCifras <= 0) {
            print("NO VÁLIDO");
            cantidadCifras = intInput("Ingrese la cantidad de cifras que quiera para su número:");
        }

        int num = intInput("Ahora ingrese dicho número:");
        String largoNum = String.valueOf(num);

        while (largoNum.length() != cantidadCifras) {
            print("NO VÁLIDO");
            num = intInput("Ingrese dicho número:");
            largoNum = String.valueOf(num);
        }

        char[] arrayChar = largoNum.toCharArray();

        int pos, aux;
        for (int i = 0; i < arrayChar.length; i++) {
            pos = i;
            aux = arrayChar[i];
            while (pos > 0 && arrayChar[pos - 1] > aux) {
                arrayChar[pos] = arrayChar[pos - 1];
                pos--;
            }
            arrayChar[pos] = (char) aux;
        }
        print(String.valueOf(arrayChar));
    }


    // Ingresar un número entero de 3 cifras. Mostrar los siguientes 3 números que contengan esas 3 cifras
    // HECHO
    private static void exercise13() {
        int num = intInput("Ingrese un número de tres cifras:");
        String largoNum = String.valueOf(num);
        while (largoNum.length() != 3) {
            print("NO VÁLIDO");
            num = intInput("Ingrese un número de tres cifras:");
            largoNum = String.valueOf(num);
        }

        char[] arrayNum = largoNum.toCharArray();   // 123  -> 132 / 213 / 231
        final char cifra1 = arrayNum[0];
        final char cifra2 = arrayNum[1];
        final char cifra3 = arrayNum[2];

        if (arrayNum[0] == arrayNum[1] || arrayNum[1] == arrayNum[2] || arrayNum[0] == arrayNum[2]) {   // g
            print("DOS O MÁS NÚMEROS SON IDÉNTICOS.");
            print("NO PUEDE REALIZARSE LA OPERACIÓN.");
            print("--------------------------------.");
            return;
        }
        if (arrayNum[0] < arrayNum[1]) {        // a - b - d
            if (arrayNum[1] > arrayNum[2]) {    // b - d
                if (arrayNum[0] < arrayNum[2]) {
                    print(String.valueOf(arrayNum));    // B

                    arrayNum[0] = cifra3;
                    arrayNum[1] = cifra1;
                    arrayNum[2] = cifra2; // -> c
                    print(String.valueOf(arrayNum));

                    arrayNum[1] = cifra2;
                    arrayNum[2] = cifra1; // -> d
                    print(String.valueOf(arrayNum));

                    arrayNum[0] = cifra2;
                    arrayNum[1] = cifra1;
                    arrayNum[2] = cifra3; // -> e
                    print(String.valueOf(arrayNum));
                } else {
                    print(String.valueOf(arrayNum));    // D

                    arrayNum[0] = cifra2;
                    arrayNum[1] = cifra3;
                    arrayNum[2] = cifra1; // -> e
                    print(String.valueOf(arrayNum));

                    arrayNum[1] = cifra1;
                    arrayNum[2] = cifra3; // -> f
                    print(String.valueOf(arrayNum));

                    print("No puede realizarse la operación completa por falta de números mayores.");
                    print("--------------------------------.");
                }
            } else {
                print(String.valueOf(arrayNum));    // A

                arrayNum[1] = cifra3;
                arrayNum[2] = cifra2; // -> b
                print(String.valueOf(arrayNum));

                arrayNum[0] = cifra2;
                arrayNum[1] = cifra1;
                arrayNum[2] = cifra3; // -> c
                print(String.valueOf(arrayNum));

                arrayNum[1] = cifra3;
                arrayNum[2] = cifra1; // -> d
                print(String.valueOf(arrayNum));
            }


        } else {                                // c - e - f
            if (arrayNum[1] < arrayNum[2]) {    // c - e
                if (arrayNum[0] < arrayNum[2]) {
                    print(String.valueOf(arrayNum));    // C

                    arrayNum[1] = cifra3;
                    arrayNum[2] = cifra2; // -> d
                    print(String.valueOf(arrayNum));

                    arrayNum[0] = cifra3;
                    arrayNum[1] = cifra2;
                    arrayNum[2] = cifra1; // -> e
                    print(String.valueOf(arrayNum));

                    arrayNum[1] = cifra1;
                    arrayNum[2] = cifra2; // -> f
                    print(String.valueOf(arrayNum));
                } else {
                    print(String.valueOf(arrayNum));    // E

                    arrayNum[1] = cifra3;
                    arrayNum[2] = cifra2; // -> f
                    print(String.valueOf(arrayNum));

                    print("No puede realizarse la operación completa por falta de números mayores.");
                    print("--------------------------------.");
                }
            } else {
                print(String.valueOf(arrayNum));    // F
                print("No puede realizarse la operación por falta de números mayores.");
                print("--------------------------------.");
            }
        }
    }


    // Ingresar un número del 1 al 10 y un carácter. Imprimir un cuadro de "-" con una escalera descendente formada con ese carácter.
    //Por ejemplo
    //Entrada: 6 y 'a'
    //Salida:
    //a-----
    //aa----
    //aaa---
    //aaaa--
    //aaaaa-
    //aaaaaa

    // HECHO
    private static void exercise15() {
        final int num = intInput("Ingrese un número entre 1 y 10:", i -> i >= 1 && i <= 10);
        char[] caracter = stringInput("Ingrese un carácter:", s -> s.length() == 1).toCharArray();


        char[] listaDeCaracteres = new char[num];

        for (int i = 0; i < num; i++) {
            listaDeCaracteres[i] = '-';
        }

        for (int j = 0; j < num; j++) {
            listaDeCaracteres[j] = caracter[0];
            print(String.valueOf(listaDeCaracteres));
        }
    }


    //Ingresar un número del 1 al 10 y un caracter. Imprimir una pirámide con ese caracter.
    //Por ejemplo
    //Entrada: 6 y 'a'
    //Salida:
    //-----aa-----
    //----aaaa----
    //---aaaaaa---
    //--aaaaaaaa--
    //-aaaaaaaaaa-
    //aaaaaaaaaaaa
    //¿Se puede reutilizar la solución del ejercicio anterior?

    // HECHO
    private static void exercise16() {
        final int num = intInput("Ingrese un número entre 1 y 10:", i -> i >= 1 && i <= 10);
        char[] caracter = stringInput("Ingrese un carácter:", s -> s.length() == 1).toCharArray();

        char[] listaDeCaracteres = new char[num * 2];

        for (int i = 0; i < (num * 2); i++) {        // lleno el array de "-"
            listaDeCaracteres[i] = '-';
        }

        for (int j = 0; j < num; j++) {
            listaDeCaracteres[num + j] = caracter[0];           // [6] -> [7] -> [8]     HAY QUE TENER EN CUENTA QUE EL ARRAY EMPIEZA EN 0
            listaDeCaracteres[(num - 1) - j] = caracter[0];     // [5] -> [4] -> [3]

            print(String.valueOf(listaDeCaracteres));
        }
    }


    // Ingresar un número entero del 1 al 19. Randomizar un número entero positivo (tipo de dato long) cuya cantidad de cifras sea el número ingresado.
    //
    //Nerd stuff:
    //-	el tipo de dato int es para números enteros de hasta 10 cifras
    //-	el tipo de dato long es para números enteros de hasta 19 cifras
    //-	De ambos tipos de datos podemos consultar los valores mínimos y máximos, buscando por ejemplo Integer.MAX_VALUE, Long.MIN_VALUE, etc.
    //
    //Tip: para randomizar un long se puede utilizar este algoritmo:
    //                 final Random random = new Random();
    //        final long randomLong = random.nextLong();
    //
    //Ese randomLong puede ser positivo o negativo y tener entre 1 y 19 cifras.

    // HECHO
    private static void exercise17() {
        final int cifras = intInput("Ingrese un número del 1 al 19:", i -> i > 0 && i <= 19);

        final Random random = new Random();
        final long randomLong = random.nextLong();      // nextLong toma el input de random como un valor ingresado

        final String stringResult = String.valueOf(randomLong)
                .replace("-", "")       // elimino los números negativos
                .substring(0, cifras);                  // extraigo un string de 4 caracteres

        print(stringResult);
    }


    // Billetera
    //Ingresar un monto inicial de balance (double).
    //Ingresar operación: 1 = ingreso, 2 = extracción, 3 = terminar.
    //Si se elige ingreso, ingresar un monto y descontarle el 30% de ganancias (redondear a entero). Sumar al balance
    //Si se elige extracción, ingresar un monto y descontarlo del balance. No puede bajar de 0.
    //Al finalizar mostrar el balance.

    // HECHO
    private static void exercise18() {
        double montoTotal = doubleInput("Ingrese un monto inicial:", i -> i > 0);
        boolean finalizar = false;

        while (!finalizar) {
            int operation = intInput("Ingrese la operación a realizar: \n1-ingreso \n2-extracción \n3-terminar", i -> i > 0 && i <= 3);

            switch (operation) {
                case 1:
                    double montoIngresado = doubleInput("Monto a ingresar:", i -> i > 0);
                    double resultadoConDescuento = montoIngresado * 0.7;

                    montoTotal = montoTotal + Math.round(resultadoConDescuento);

                    print("Usted tiene un total de $" + montoTotal);
                    print("---------------------------------------------------------");
                    break;
                case 2:
                    double montoARetirar = doubleInput("Monto a retirar:", i -> i > 0);

                    if ((montoTotal - montoARetirar) < 0) {
                        print("No puede retirar dicha cantidad por saldo insuficiente.");
                    } else {
                        montoTotal = montoTotal - montoARetirar;
                    }

                    print("Usted tiene un total de $" + montoTotal);
                    print("---------------------------------------------------------");
                    break;
                case 3:
                    print("Usted tiene $" + montoTotal);
                    print("¡Hasta luego!");
                    print("---------------------------------------------------------");
                    finalizar = true;
                    break;
            }
        }
    }


    // Movimiento
    //Nivel 1. Nos encontramos en una habitación de 4x4 (metros).
    //Ingresar un número para avanzar un metro: 1 = adelante, 2 = atrás, 3 = izquierda, 4 = derecha,
    //         cualquier otro = terminar. Informar cuando se llegue a una pared y no permitir el avance
    //         en esa dirección. En cada paso mostrar las coordenadas, empezando siempre en [0-0].
    //Nivel 2. Ingresar el metraje del recinto (siempre cubo). Ej.: ingreso 10, la habitación será de 10x10.
    //Nivel 3. Rectángulo. Ej.: ingreso 4 y 6, la habitación es de 4x6.

    // HECHO
    private static void exercise19() {
        final int nivel = intInput("Ingrese el nivel al que quiera jugar: 1, 2 o 3.", i -> i > 0 && i <= 3);

        // --------------------------------------------------------------------------------
        switch (nivel) {
            case 1: {                       //  NIVEL 1

                boolean finaliza = false;
                int arribaOAbajo = 2;
                int derechaOIzquierda = 2;

                print("Usted se encuentra en el centro de una habitación de 4x4 metros.");

                while (!finaliza) {
                    char[][] espacio = new char[5][5];                      // reinicio siempre el array
                    for (int i = 0; i < espacio.length; i++) {
                        for (int j = 0; j < espacio.length; j++) {
                            espacio[i][j] = '-';
                        }
                    }

                    espacio[arribaOAbajo][derechaOIzquierda] = 'X';        // posición actual (gracias al while se posiciona)

                    for (int x = 0; x < espacio.length; x++) {
                        for (int y = 0; y < espacio[x].length; y++) {
                            System.out.print(espacio[x][y] + " ");
                        }
                        print("");
                    }
                    print("\n\n");
                    String accion = stringInput("Para moverse utilice w-a-s-d. Con el 0 finaliza.\n", s -> s.equals("w") || s.equals("a") || s.equals("s") || s.equals("d") || s.equals("0"));

                    switch (accion) {
                        case "w":                         // arriba
                            if (arribaOAbajo == 0) {
                                print("LLEGÓ A UNA PARED");
                            } else {
                                arribaOAbajo--;
                                if (arribaOAbajo == 0) {
                                    print("LLEGÓ A UNA PARED");
                                }
                            }
                            break;
                        case "s":                         // abajo
                            if (arribaOAbajo == 4) {
                                print("LLEGÓ A UNA PARED");
                            } else {
                                arribaOAbajo++;
                                if (arribaOAbajo == 4) {
                                    print("LLEGÓ A UNA PARED");
                                }
                            }
                            break;
                        case "a":                         // izquierda
                            if (derechaOIzquierda == 0) {
                                print("LLEGÓ A UNA PARED");
                            } else {
                                derechaOIzquierda--;
                                if (derechaOIzquierda == 0) {
                                    print("LLEGÓ A UNA PARED");
                                }
                            }
                            break;
                        case "d":                         // derecha
                            if (derechaOIzquierda == 4) {
                                print("LLEGÓ A UNA PARED");
                            } else {
                                derechaOIzquierda++;
                                if (derechaOIzquierda == 4) {
                                    print("LLEGÓ A UNA PARED");
                                }
                            }
                            break;
                        default:
                            print("JUEGO TERMINADO");
                            finaliza = true;
                    }
                }


                // --------------------------------------------------------------------------------
                break;
            }
            default: {
                boolean finaliza = false;
                if (nivel == 2) {                //  NIVEL 2
                    int arribaOAbajo;
                    int derechaOIzquierda;

                    int dimensiones = intInput("Ingrese un número entre 1 y 20:", i -> i > 0 && i <= 20);
                    print("Usted se encuentra en el centro de una habitación de " + dimensiones + "m x" + dimensiones + "m.");

                    if (dimensiones % 2 == 0) {   // si es par, empieza en el centro
                        arribaOAbajo = dimensiones / 2;
                        derechaOIzquierda = dimensiones / 2;
                    } else {                    // si es impar, empieza levemente descentrado
                        arribaOAbajo = (dimensiones - 1) / 2;
                        derechaOIzquierda = (dimensiones - 1) / 2;
                    }

                    while (!finaliza) {
                        char[][] espacio = new char[dimensiones + 1][dimensiones + 1];                      // reinicio siempre el array
                        for (int i = 0; i < espacio.length; i++) {
                            for (int j = 0; j < espacio.length; j++) {
                                espacio[i][j] = '-';
                            }
                        }

                        espacio[arribaOAbajo][derechaOIzquierda] = 'X';        // posición actual (gracias al while se posiciona)

                        for (int x = 0; x < espacio.length; x++) {
                            for (int y = 0; y < espacio[x].length; y++) {
                                System.out.print(espacio[x][y] + " ");
                            }
                            print("");
                        }
                        print("\n\n");
                        String accion = stringInput("Para moverse utilice w-a-s-d. Con el 0 finaliza.\n", s -> s.equals("w") || s.equals("a") || s.equals("s") || s.equals("d") || s.equals("0"));

                        switch (accion) {
                            case "w":                         // arriba
                                if (arribaOAbajo == 0) {
                                    print("LLEGÓ A UNA PARED");
                                } else {
                                    arribaOAbajo--;
                                    if (arribaOAbajo == 0) {
                                        print("LLEGÓ A UNA PARED");
                                    }
                                }
                                break;
                            case "s":                         // abajo
                                if (arribaOAbajo == dimensiones) {
                                    print("LLEGÓ A UNA PARED");
                                } else {
                                    arribaOAbajo++;
                                    if (arribaOAbajo == dimensiones) {
                                        print("LLEGÓ A UNA PARED");
                                    }
                                }
                                break;
                            case "a":                         // izquierda
                                if (derechaOIzquierda == 0) {
                                    print("LLEGÓ A UNA PARED");
                                } else {
                                    derechaOIzquierda--;
                                    if (derechaOIzquierda == 0) {
                                        print("LLEGÓ A UNA PARED");
                                    }
                                }
                                break;
                            case "d":                         // derecha
                                if (derechaOIzquierda == dimensiones) {
                                    print("LLEGÓ A UNA PARED");
                                } else {
                                    derechaOIzquierda++;
                                    if (derechaOIzquierda == dimensiones) {
                                        print("LLEGÓ A UNA PARED");
                                    }
                                }
                                break;
                            default:
                                print("JUEGO TERMINADO");
                                finaliza = true;
                        }
                    }


                    // --------------------------------------------------------------------------------
                } else {                                //  NIVEL 3
                    int arribaOAbajo;
                    int derechaOIzquierda;

                    int alto = intInput("Ingrese un número entre 1 y 20:", i -> i > 0 && i <= 20);
                    int ancho = intInput("Ingrese otro número distinto, entre 1 y 20:", i -> i != alto && i > 0 && i <= 20);
                    print("Usted se encuentra en el centro de una habitación de " + alto + "m de alto y " + ancho + "m de ancho.");

                    if (alto % 2 == 0) {
                        arribaOAbajo = alto / 2;
                    } else {
                        arribaOAbajo = (alto - 1) / 2;
                    }
                    if (ancho % 2 == 0) {
                        derechaOIzquierda = ancho / 2;
                    } else {
                        derechaOIzquierda = (ancho - 1) / 2;
                    }

                    while (!finaliza) {
                        char[][] espacio = new char[alto + 1][ancho + 1];                      // reinicio siempre el array
                        for (int i = 0; i < (alto + 1); i++) {
                            for (int j = 0; j < (ancho + 1); j++) {
                                espacio[i][j] = '-';
                            }
                        }

                        espacio[arribaOAbajo][derechaOIzquierda] = 'X';        // posición actual (gracias al while se posiciona)

                        for (int x = 0; x < (alto + 1); x++) {
                            for (int y = 0; y < (ancho + 1); y++) {
                                System.out.print(espacio[x][y] + " ");
                            }
                            print("");
                        }
                        print("\n\n");
                        String accion = stringInput("Para moverse utilice w-a-s-d. Con el 0 finaliza.\n", s -> s.equals("w") || s.equals("a") || s.equals("s") || s.equals("d") || s.equals("0"));

                        switch (accion) {
                            case "w":                         // arriba
                                if (arribaOAbajo == 0) {
                                    print("LLEGÓ A UNA PARED");
                                } else {
                                    arribaOAbajo--;
                                    if (arribaOAbajo == 0) {
                                        print("LLEGÓ A UNA PARED");
                                    }
                                }
                                break;
                            case "s":                         // abajo
                                if (arribaOAbajo == alto) {
                                    print("LLEGÓ A UNA PARED");
                                } else {
                                    arribaOAbajo++;
                                    if (arribaOAbajo == alto) {
                                        print("LLEGÓ A UNA PARED");
                                    }
                                }
                                break;
                            case "a":                         // izquierda
                                if (derechaOIzquierda == 0) {
                                    print("LLEGÓ A UNA PARED");
                                } else {
                                    derechaOIzquierda--;
                                    if (derechaOIzquierda == 0) {
                                        print("LLEGÓ A UNA PARED");
                                    }
                                }
                                break;
                            case "d":                         // derecha
                                if (derechaOIzquierda == ancho) {
                                    print("LLEGÓ A UNA PARED");
                                } else {
                                    derechaOIzquierda++;
                                    if (derechaOIzquierda == ancho) {
                                        print("LLEGÓ A UNA PARED");
                                    }
                                }
                                break;
                            default:
                                print("JUEGO TERMINADO");
                                finaliza = true;
                        }
                    }
                }
                break;
            }
        }
    }

        // Juego: ordenar secuencias de números
        //Se trata de un juego de 19 niveles.
        //Termina cuando el usuario ingresa 'exit' o cuando resuelve el último nivel.
        //En el primer nivel se randomiza un número entero de 3 cifras positivo y se le pide al usuario que
        //          ingrese la secuencia en orden ascendente. Utilizar tipo de dato long.
        //Por ejemplo, si el programa muestra "839" el usuario tiene que ingresar "389".
        //En cada nivel se suma una cifra al desafío. Cada nivel superado suma el doble de puntos,
        //          siendo 100 el puntaje del nivel 1. Se puede fallar un máximo de 3 veces, en caso de
        //          superar esa cantidad finalizar el juego mostrando “Game over”.
        //Mostrar en cada paso el nivel en el que se está, el puntaje ganado del nivel y el puntaje final.
        //Al finalizar indicar el puntaje final.
        //
        //Extra -> si el usuario gana el juego, ¿puede volver a jugar manteniendo su score?

        // HECHO
        private static void exercise20 () {

            int intentos = 3;
            int nivel = 1;
            long puntajeTotal = 0;
            long puntajeActual = 100;
            int cantidadCifras = 3;
            boolean finalizar = false;

            while (!finalizar) {
                print("Ordene las cifras de los siguientes números de forma ascendente:");

                while (intentos > 0 && nivel <= 5) {

                    print("------------------------------------------------------------");
                    print("\n[NIVEL " + nivel +"]\n");


                    String stringResultado = "0";

                    while (stringResultado.contains("0")) {         // compruebo que no tenga 0
                        final Random randomOtro = new Random();
                        long randomLong = randomOtro.nextLong();    // obtengo un long

                        stringResultado = String.valueOf(randomLong)
                                .replace("-", "")
                                .substring(0, cantidadCifras);            // lo recorto a las cifras de cada nivel
                    }
                    print(stringResultado);
                    cantidadCifras++;                      // sumo una cifra, para el próximo nivel

                    char[] numOrdenado = stringResultado.toCharArray();     // lo convierto en array para poder ordenarlo

                    int pos, aux;                                       // lo ordeno de menor a mayor
                    for (int i = 0; i < numOrdenado.length; i++) {
                        pos = i;
                        aux = numOrdenado[i];
                        while (pos > 0 && numOrdenado[pos - 1] > aux) {
                            numOrdenado[pos] = numOrdenado[pos - 1];
                            pos--;
                        }
                        numOrdenado[pos] = (char) aux;
                    }

                    String resultadoFinal = String.valueOf(numOrdenado);      // lo paso a string para poder compararlo


                    int cifras = nivel + 2;
                    String numJugador = stringInput("\nIngrese el número ordenado de menor a mayor: ", s -> s.length() == cifras);
                    long numIngresado = Long.parseLong(numJugador);


                    if (resultadoFinal.equals(String.valueOf(numIngresado))) {
                        print("\n\n¡Ganaste el nivel " + nivel + "! \n\nSumás " + puntajeActual + " puntos");

                        nivel ++;
                        puntajeTotal = puntajeTotal + puntajeActual;

                        print("Puntaje: " + puntajeTotal);

                        print(" . . . . . . . . . . . . . . . . . . . . . . . . . . . . . .");
                    } else {
                        intentos --;
                        print("Perdiste. Intentos disponibles: " + intentos);

                        nivel ++;
                        puntajeActual = puntajeActual * 2;
                    }

                    if (nivel < 5) {
                        int continuar = intInput("\n¿Quiere continuar?:\n1- exit / 2- seguir", i -> i > 0 && i <= 2);
                        if (continuar == 1) {
                            print("JUEGO TERMINADO");
                            print("Puntaje final: " + puntajeTotal);
                            return;
                        } else {
                            puntajeActual = puntajeActual * 2;
                        }
                    }
                }

                print("\n\nJUEGO TERMINADO");

                if (intentos > 0) {
                    print("¡Ganaste el juego con " + puntajeTotal + " de puntaje final!");
                } else {
                    print("No ganaste el juego.");
                }
                int continuar = intInput("\n¿Quiere jugar otra vez?:\n1- sí / 2- no", i -> i > 0 && i <= 2);
                if (continuar == 1) {
                    intentos = 3;
                    nivel = 1;
                    cantidadCifras = 3;
                    puntajeActual = 100;
                } else {
                    finalizar = true;
                }
            }
        }
}

