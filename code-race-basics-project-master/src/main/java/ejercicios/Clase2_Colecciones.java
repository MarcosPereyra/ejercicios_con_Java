package ejercicios;

import menu.Menu;

import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

import static ejercicios.Clase2_Colecciones.Note.notesStrings;
import static java.util.Arrays.stream;
import static util.IOUtil.*;

public class Clase2_Colecciones {
    public static void suscribeToMenu(Menu mainMenu) {
        final Menu excercises = new Menu("Ejercicios, clase 2 (colecciones)", mainMenu);

        //excercises.addItem("Ejercicio 1", Clase2_Colecciones::exercise1);
        //excercises.addItem("Ejercicio 2", Clase2_Colecciones::exercise2);
        //excercises.addItem("Ejercicio 3", Clase2_Colecciones::exercise3);
        //excercises.addItem("Ejercicio 4", Clase2_Colecciones::exercise4);
        //excercises.addItem("Ejercicio 5", Clase2_Colecciones::exercise5);
        //excercises.addItem("Ejercicio 6", Clase2_Colecciones::exercise6);
        //excercises.addItem("Ejercicio 7", Clase2_Colecciones::exercise7);
        excercises.addItem("Ejercicio 8", Clase2_Colecciones::exercise8);
        //excercises.addItem("Contraseña de clase 3", Clase2_Colecciones::password);
    }

    // Cargar dos listas de 5 personas indicando su nombre. Luego armar un mapa de parejas por orden de
    // llegada en cada lista. Imprimir las parejas separadas por '-'.

    // HECHO
    public static void exercise1() {
        final List<String> nombres1 = new ArrayList<>();        // si es final, no puedo volver a iniciarla
        final List<String> nombres2 = new ArrayList<>();

        for (int i = 0; i < 5; i++) {      // lleno las listas
            nombres1.add(stringInput("Ingrese un nombre para la lista 1:"));
        }
        for (int i = 0; i < 5; i++) {
            nombres2.add(stringInput("Ingrese un nombre para la lista 2:"));
        }

        final Map<String, String> finalMap = exercise1(nombres1, nombres2);
    }
    public static Map<String, String> exercise1 (List<String> nombres1, List<String> nombres2) {
        final Map<String, String> parejas = new HashMap<>();    // creo un Map
        for (int i = 0; i < 5; i++) {
            parejas.put(nombres1.get(i), nombres2.get(i));      // cargo el Map con los datos de ambas listas

            print(nombres1.get(i) + " - " + nombres2.get(i));   // lo imprimo
        }
        return parejas;
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Crear dos listas de 5 números. Imprimir las parejas que se forman con los números
    // en orden ascendente para la primera lista, y descendente para la segunda.
    //Ejemplo
    //Entrada:
    //	lista 1 -> 5, 34, 1, 309, 20
    //	lista 2 -> 18, 100, 92, 7, 56
    //  Salida:
    //  1-100
    //  5-92
    //  20-56
    //  34-18
    //  309-7

    // HECHO
    public static void exercise2 () {
        final int listLength = 5;
        final List<Integer> listOne = new ArrayList<>();
        final List<Integer> listTwo = new ArrayList<>();

        addNumberToList(listOne, listLength);        // llamo al método que crea listas
        addNumberToList(listTwo, listLength);

        Collections.sort(listOne);                   // las ordeno de forma ascendente
        Collections.sort(listTwo);

        Collections.reverse(listTwo);                // invierto sólo la segunda

        printLists(listOne, listTwo);
    }

    private static void addNumberToList(List<Integer> list, int i) {
        for (int j = 1; j <= i; j++) {
            final int num = intInput(String.format("Ingrese el número %s de %s", j, i));
            list.add(num);      // relleno la lista
        }
    }

    private static void printLists(List<Integer> firstList, List<Integer> secondList) {
        for (int i = 0; i < firstList.size(); i++) {
            print(firstList.get(i) + " - " + secondList.get(i));           // imprimo cada valor de las listas
        }
    }


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // Crear un ENUM para representar un podio: CHAMPION, SUB_CHAMPION, THIRD_PLACE.
    //Ingresar el nombre y el puntaje de tres equipos y armar un mapa con el podio (enum + nombre).

    // HECHO
    public static void exercise3() {
        final String name1 = stringInput("Ingrese al primer equipo:", s -> s.length() > 0);
        final String name2 = stringInput("Ingrese al segundo equipo:", s -> s.length() > 0);
        final String name3 = stringInput("Ingrese al tercer equipo:", s -> s.length() > 0);

        final int score1 = intInput("Ingrese el puntaje de " + name1, i -> i > 0);
        final int score2 = intInput("Ingrese el puntaje de " + name2, i -> i > 0);
        final int score3 = intInput("Ingrese el puntaje de " + name3, i -> i > 0);

        print(exercise3Positions(name1, name2, name3, score1, score2, score3));
    }

    public static String exercise3Positions (String name1, String name2, String name3,
                                             int score1, int score2, int score3) {

        final Map<Integer, String> teamsAndScores = new HashMap<>();
        teamsAndScores.put(score1, name1);
        teamsAndScores.put(score2, name2);
        teamsAndScores.put(score3, name3);


        final List<Integer> scores = new ArrayList<>();
        scores.add(score1);
        scores.add(score2);
        scores.add(score3);

        Collections.sort(scores);
        Collections.reverse(scores);

        final Map<Podio, String> podioMap = new HashMap<>();
        podioMap.put(Podio.CHAMPION, teamsAndScores.get(scores.get(0)));
        podioMap.put(Podio.SUB_CHAMPION, teamsAndScores.get(scores.get(1)));
        podioMap.put(Podio.THIRD_PLACE, teamsAndScores.get(scores.get(2)));

        String result = Podio.CHAMPION + " - " + teamsAndScores.get(scores.get(0)) + " / "
                + Podio.SUB_CHAMPION + " - " + teamsAndScores.get(scores.get(1)) + " / "
                + Podio.THIRD_PLACE + " - " + teamsAndScores.get(scores.get(2));

        return result;
    }
    private enum Podio {
        CHAMPION, SUB_CHAMPION, THIRD_PLACE
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /* Sin ingreso de usuario. Armar un mapa con las siguientes ligas de fútbol y sus equipos más importantes
       (mínimo 2, máximo 4): "premier-league", "serie-a", "la-liga", "primera-división".
    Imprimir con el siguiente formato:
    Equipos más representativos de premier-league:
    Manchester City, Manchester Utd, Chelsea, Liverpool*/
    public static void exercise4() {
        final Map<League, List<String>> teamsByLeague = new HashMap<>();        // armo un Map de Ligas y List<String>

        final List<String> premierLeagueTeams = new ArrayList<>();              // armo una lista de Strings
        premierLeagueTeams.add("Manchester City");
        premierLeagueTeams.add("Manchester Utd");
        premierLeagueTeams.add("Liverpool");
        teamsByLeague.put(League.PREMIER_LEAGUE, premierLeagueTeams);           // lleno el [0] del Map con la Premier Ligue y la primera lista de equipos

        final List<String> serieATeams = new ArrayList<>();                     // repito con otra liga, [1]
        serieATeams.add("Milan");
        serieATeams.add("Inter");
        serieATeams.add("Juventus");
        teamsByLeague.put(League.SERIE_A, serieATeams);

        final List<String> laLigaTeams = new ArrayList<>();                     // repito con otra liga, [2]
        laLigaTeams.add("Barcelona");
        laLigaTeams.add("Real Madrid");
        laLigaTeams.add("Atlético Madrid");
        teamsByLeague.put(League.LA_LIGA, laLigaTeams);

        final List<String> primeraDivisionTeams = new ArrayList<>();            // repito con otra liga, [3]
        primeraDivisionTeams.add("River");
        primeraDivisionTeams.add("Boca");
        primeraDivisionTeams.add("Racing");
        teamsByLeague.put(League.PRIMERA_DIVISION, primeraDivisionTeams);

        teamsByLeague.forEach((league, teams) -> {                              // "para cada key y value...", junto los equipos en un solo String,
            final String teamsJoined = String.join(", ", teams);        //  y después imprimo cada liga

            print("Equipos más representativos de " + league + ":");
            print(teamsJoined);
        });
    }

    private enum League {
        PREMIER_LEAGUE, SERIE_A, LA_LIGA, PRIMERA_DIVISION
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Resolver ejercicio de colores con Collections y sin usar if. Recomendado: usar Map
    //8. Ingresar dos colores. Pueden ser los tres primarios o sus combinaciones.
    // Si los dos colores son primarios, devolver el color que se forma.
    // Si uno es secundario y el otro es uno de sus primarios, devolver el secundario sumándole "claro"/"oscuro"
    // según sea el caso. Si los dos son secundarios, o si uno es primario pero no forma parte del secundario,
    // devolver 'marrón'. Si alguno es inexistente, indicar "error". Pista -> pasar a minúscula.

    public static void exercise5 () {
        final String lighter = " claro";
        final String darker = " oscuro";

        // ingreso un string, lo paso a Enum
        final String color1 = stringInput("Ingrese el primer color: rojo | azul | amarillo | " +
                "violeta | verde | naranja ", s -> s.equals("rojo") || s.equals("azul") || s.equals("amarillo") ||
                s.equals("violeta") || s.equals("verde") || s.equals("naranja")).toUpperCase();
        final String color2 = stringInput("Ingrese el segundo color: rojo | azul | amarillo | " +
                "violeta | verde | naranja ", s -> s.equals("rojo") || s.equals("azul") || s.equals("amarillo") ||
                s.equals("violeta") || s.equals("verde") || s.equals("naranja")).toUpperCase();

        print(exercise5(color1, color2, lighter, darker));
    }

    public static String exercise5(String colorOne, String colorTwo, String lighter, String darker) {
        final Color color1 = Color.fromString(colorOne);
        final Color color2 = Color.fromString(colorTwo);

        final Map<Color, String> redCombinations = new HashMap<>();         // creo un Map por cada color + sus combinaciones
        final Map<Color, String> blueCombinations = new HashMap<>();
        final Map<Color, String> yellowCombinations = new HashMap<>();
        final Map<Color, String> orangeCombinations = new HashMap<>();
        final Map<Color, String> purpleCombinations = new HashMap<>();
        final Map<Color, String> greenCombinations = new HashMap<>();

        redCombinations.put(Color.ROJO, Color.ROJO.toString().toLowerCase());             // guardo en el Map el Enum y su String
        redCombinations.put(Color.AMARILLO, Color.NARANJA.toString().toLowerCase());
        redCombinations.put(Color.AZUL, Color.VIOLETA.toString().toLowerCase());
        redCombinations.put(Color.NARANJA, Color.NARANJA.toString().toLowerCase() + darker);
        redCombinations.put(Color.VIOLETA, Color.VIOLETA.toString().toLowerCase() + lighter);

        blueCombinations.put(Color.AZUL, Color.AZUL.toString().toLowerCase());
        blueCombinations.put(Color.AMARILLO, Color.VERDE.toString().toLowerCase());
        blueCombinations.put(Color.ROJO, Color.VIOLETA.toString().toLowerCase());
        blueCombinations.put(Color.VIOLETA, Color.VIOLETA.toString().toLowerCase() + darker);
        blueCombinations.put(Color.VERDE, Color.VERDE.toString().toLowerCase() + darker);

        yellowCombinations.put(Color.AMARILLO, Color.AMARILLO.toString().toLowerCase());
        yellowCombinations.put(Color.ROJO, Color.NARANJA.toString().toLowerCase());
        yellowCombinations.put(Color.AZUL, Color.VERDE.toString().toLowerCase());
        yellowCombinations.put(Color.NARANJA, Color.NARANJA.toString().toLowerCase() + lighter);
        yellowCombinations.put(Color.VERDE, Color.VERDE.toString().toLowerCase() + lighter);

        orangeCombinations.put(Color.NARANJA, Color.NARANJA.toString().toLowerCase());
        orangeCombinations.put(Color.AZUL, Color.NARANJA.toString().toLowerCase());
        orangeCombinations.put(Color.VIOLETA, Color.NARANJA.toString().toLowerCase());
        orangeCombinations.put(Color.AMARILLO, Color.NARANJA.toString().toLowerCase() + lighter);
        orangeCombinations.put(Color.ROJO, Color.NARANJA.toString().toLowerCase() + darker);

        purpleCombinations.put(Color.VIOLETA, Color.VIOLETA.toString().toLowerCase());
        purpleCombinations.put(Color.ROJO, Color.VIOLETA.toString().toLowerCase() + lighter);
        purpleCombinations.put(Color.AZUL, Color.VIOLETA.toString().toLowerCase() + darker);

        greenCombinations.put(Color.VERDE, Color.VERDE.toString().toLowerCase());
        greenCombinations.put(Color.AMARILLO, Color.VERDE.toString().toLowerCase() + lighter);
        greenCombinations.put(Color.AZUL, Color.VERDE.toString().toLowerCase() + darker);

        final Map<Color, Map<Color, String>> combinations = new HashMap<>();
        combinations.put(Color.ROJO, redCombinations);
        combinations.put(Color.AZUL, blueCombinations);
        combinations.put(Color.AMARILLO, yellowCombinations);
        combinations.put(Color.NARANJA, orangeCombinations);
        combinations.put(Color.VIOLETA, purpleCombinations);
        combinations.put(Color.VERDE, greenCombinations);


        if (color1 == null || color2 == null) {
            return "Error";
        } else {
            final String combination = combinations.get(color1).get(color2);

            return (combination != null ? combination : Color.MARRÓN.toString().toLowerCase());
        }
    }

    private enum Color {
        // primarios
        ROJO, AZUL, AMARILLO,

        // secundarios
        VERDE, VIOLETA, NARANJA,

        // MEZCLA
        MARRÓN;

        public static Color fromString(String value) {
            return stream(Color.values())            // creo un array con todos los Enums
                    .filter(color -> color.toString().equalsIgnoreCase(value))      // filtro sólo el color que ingresé
                    .findFirst()                                                    // lo busco
                    .orElse(null);                                             // sino es null
        }
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Sin ingreso de usuario. Armar e imprimir un mapa con las siete escalas/modos que se forman con las
    // notas de la escala mayor de DO:
    //JONICO -> "do", "re", "mi", "fa", "sol", "la", "si".
    //DORICO -> "re", "mi", "fa", "sol", "la", "si", "do"
    //FRIGIO -> "mi", "fa", "sol", "la"....
    //LIDIO -> "fa", "sol", "la"...
    //MIXOLIDIO -> "sol"...
    //EOLICO -> "la" ...
    //LOCRIO -> "si" ...
    //¿Es necesario cargar la lista de notas para cada key del mapa?
    public static void exercise6() {
        final String decision = stringInput("¿Qué opción desea ejecutar?:\n| Nei | Marcos |", s -> s.equalsIgnoreCase("Nei")
                | s.equalsIgnoreCase("Marcos"));

        if (decision.equalsIgnoreCase("Nei")) {
            // RESOLUCIÓN DE NEI
            final Map<Scale, Integer> offsetByScale = new HashMap<>();
            offsetByScale.put(Scale.JÓNICO, 0);
            offsetByScale.put(Scale.DÓRICO, 1);
            offsetByScale.put(Scale.FRIGIO, 2);
            offsetByScale.put(Scale.LIDIO, 3);
            offsetByScale.put(Scale.MIXOLIDIO, 4);
            offsetByScale.put(Scale.EÓLICO, 5);
            offsetByScale.put(Scale.LOCRIO, 6);

            offsetByScale.forEach((scale, offset) -> {
                String notesJoined = "";
                int loops = 0;
                int index = offset;

                final Note[] notes = Note.values();
                final int notesLength = notes.length;

                while (loops < notesLength) {
                    if (index == notesLength) {
                        index = 0;
                    }

                    notesJoined = notesJoined + notes[index];

                    if (loops < notesLength - 1) {
                        notesJoined += ", ";
                    }

                    index++;
                    loops++;
                }

                print(String.format("%s -> %s", scale, notesJoined));
            });
        }

        if (decision.equalsIgnoreCase("Marcos")) {
            // RESOLUCIÓN PROPIA (distinta a la consigna)
            // ingreso
            final String inputNote = stringInput("Ingrese la nota a partir de la cual empezar el modo:" +
                    "\n| do | re | mi | fa | sol | la | si |", s -> notesStrings().contains(s.toLowerCase())).toUpperCase();
            final Note initialNote = Note.fromString(inputNote);

            // Maps
            final Map<Note, String> scales = new HashMap<>();
            scales.put(Note.DO, "do - re - mi - fa - sol - la - si");
            scales.put(Note.RE, "re - mi - fa - sol - la - si - do");
            scales.put(Note.MI, "mi - fa - sol - la - si - do - re");
            scales.put(Note.FA, "fa - sol - la - si - do - re - mi");
            scales.put(Note.SOL, "sol - la - si - do - re - mi - fa");
            scales.put(Note.LA, "la - si - do - re - mi - fa - sol");
            scales.put(Note.SI, "si - do - re - mi - fa - sol - la");

            final Map<Note, Scale> nameOfScale = new HashMap<>();
            nameOfScale.put(Note.DO, Scale.JÓNICO);
            nameOfScale.put(Note.RE, Scale.DÓRICO);
            nameOfScale.put(Note.MI, Scale.FRIGIO);
            nameOfScale.put(Note.FA, Scale.LIDIO);
            nameOfScale.put(Note.SOL, Scale.MIXOLIDIO);
            nameOfScale.put(Note.LA, Scale.EÓLICO);
            nameOfScale.put(Note.SI, Scale.LOCRIO);

            // imprimo
            print(nameOfScale.get(initialNote) + ": " + scales.get(initialNote));
        }
    }

    enum Note {
        DO, RE, MI, FA, SOL, LA, SI;

        public static String notesStrings () {
            return "do re mi fa sol la si";
        }

        public static Note fromString (String value) {
            return stream(Note.values())                                        // a todos los Enum...
                    .filter(note -> note.toString().equalsIgnoreCase(value))    // filtro sólo el que sea igual a value...
                    .findFirst()                                                // lo encuentro...
                    .orElse(null);                                        // y si no está, devolver null
        }
    }
    enum Scale {
        JÓNICO, DÓRICO, FRIGIO, LIDIO, MIXOLIDIO, EÓLICO, LOCRIO;
    }




    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Ingresar un número. Mostrar la secuencia de nombres, sin usar if / switch.
    // Por ejemplo 123 -> mostrar UNO-DOS-TRES.
    //¿Se puede reutilizar la solución para hacer el camino inverso? Ingresar UNO-DOS-TRES -> mostrar 123

    public static void exercise7() {
        final int choice = intInput("¿Desea ingresar su número como cifras (1) o como texto (2)?:", i -> i == 1 | i == 2);
        int number = 0;
        String textNumber = "";

        if (choice == 1) {
            number = intInput("Ingrese un número positivo de tres cifras (Ej: 123).", n -> n > 0 && n <= 999);
        } else {
            textNumber = stringInput("Ingrese un número de tres cifras como texto separado por guiones (Ej: uno-dos-tres).");
        }

        print(exercise7(number, textNumber));
    }
    
    public static String exercise7 (int number, String textNumber) {
        final Map<Character, Number> numbersAndTexts = new HashMap<>();
        numbersAndTexts.put('1', Number.UNO);
        numbersAndTexts.put('2',Number.DOS);
        numbersAndTexts.put('3',Number.TRES);
        numbersAndTexts.put('4',Number.CUATRO);
        numbersAndTexts.put('5',Number.CINCO);
        numbersAndTexts.put('6',Number.SEIS);
        numbersAndTexts.put('7',Number.SIETE);
        numbersAndTexts.put('8',Number.OCHO);
        numbersAndTexts.put('9',Number.NUEVE);


        // number to text
        if (textNumber.equals("")) {
            final char[] numberToArray = String.valueOf(number).toCharArray();

            String numNamesJoined = "";     // creo un texto vacío

            for (char num : numberToArray) {
                if (!numNamesJoined.isEmpty()) {        // si no está vacío (solo la 1° vuelta no cumple)...
                    numNamesJoined += "-";              // agregar guión
                }

                numNamesJoined += numbersAndTexts.get(num);     // agrego el nombre del número, separado antes en chars
            }

            return numNamesJoined;
        }

        // text to number
        else {
            // lista de Enums   ej: [UNO, CUATRO, DOS]
            final List<Number> enumList = Arrays.stream(textNumber.split("-"))    // creo una lista de Enums con el número ingresado dividido
                    .map(Number::fromString)                                              // y pasado a Enums
                    .collect(Collectors.toList());

            // lista de Strings
            final List<String> numbersList = new ArrayList<>();         // creo una lista a llenar

            enumList.forEach(num -> {                      // para cada Enum de la lista hecha con el número ingresado...
                Character numChar = null;                 // declaro un char null
                int index = 1;                           // creo un index

                while(numChar == null && index <= numbersAndTexts.size()) {     // mientras numChar sea null y el index no supere el largo de mi Map de Enums...
                    final char key = Character.forDigit(index, 10);       // el key es el index
                    final Number n = numbersAndTexts.get(key);                  // creo un n que sea el Enum de ese index

                    if (n == num) {                                             // si el Enum creado es igual al Enum de la lista ingresada...
                        numChar = key;
                    }

                    index ++;
                }

                numbersList.add(String.valueOf(numChar));
            });

            return String.join("", numbersList);        }
    }


    enum Number {
        UNO, DOS, TRES, CUATRO, CINCO, SEIS, SIETE, OCHO, NUEVE;

        public static String numberString () {
            return "UNO - DOS - TRES - CUATRO - CINCO - SEIS - SIETE - OCHO - NUEVE";
        }
        public static Number fromString(String value) {
            return stream(Number.values())
                    .filter(number -> number.toString().equalsIgnoreCase(value))    // filtro sólo el que sea igual a value...
                    .findFirst()                                                // lo encuentro...
                    .orElse(null);                                        // y si no está, devolver null
        }
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Para enfermitos….
    // Se puede resolver la operación de la Calculadora sin usar if? Investigar interfaz Runnable () ->
    public static void exercise8() {
        Map<Operation, BiFunction<Double, Double, Double>> operations = new HashMap<>();
        operations.put(Operation.SUM, (n1, n2) -> n1 + n2);
        operations.put(Operation.SUBTRACT, (n1, n2) -> n1 - n2);
        operations.put(Operation.MULTIPLY, (n1, n2) -> n1 * n2);
        operations.put(Operation.DIVIDE, (n1, n2) -> n1 / n2);
        operations.put(Operation.PERCENTAGE, (n1, n2) -> n1 * (n2 / 100));

        final Operation operation = Operation.fromString(stringInput("Ingrese la operación a realizar:" +
                "\n| sum | subtract | multiply | divide | percentage |").toLowerCase());

        if (operation == null) {
            print("Error");
        }

        double num1 = doubleInput("Ingrese el primer número");
        double num2 = doubleInput("Ingrese el segundo número");


        if ((operation == Operation.DIVIDE && (num2 == 0 || num1 == 0)) ||
                (operation == Operation.PERCENTAGE && (num2 <= 0 || num1 <= 0))) {
            print("Error");
        } else {
            print(operations.get(operation).apply(num1, num2));
        }
    }
    private enum Operation {
        SUM, SUBTRACT, MULTIPLY, DIVIDE, PERCENTAGE;

        public static Operation fromString (String value) {
            return stream(Operation.values())
                    .filter(operation -> operation.toString().equalsIgnoreCase(value))
                    .findFirst()
                    .orElse(null);
        }
    }



    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void password () {
        String encode = "l.*********..****.f .*****.b**.***.d.*******..*.   .*****..*.o,.fdbbi,.***..*. k.****.e.**..**.f .*********.a*.********.trc .,. .*****.b.******.";

        encode = changeSymbol(encode)
                .replace("9", "")
                .replace(" ", "");
        encode = hasVocal(encode)
                .toUpperCase();
        encode = reverseString(encode);

        print(encode);
    }


    private static String hasVocal(String text) {
        char[] vocals = new char[]{'a', 'e', 'i', 'o', 'u'};

        char[] array = text.toCharArray();

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < vocals.length; j++) {
                if (array[i] == vocals[j]) {
                    array[i] = '-';
                }
            }
        }
        return String.valueOf(array);
    }
    private static String changeSymbol(String text) {
        text = text.replace(".,.", "0")
                .replace(".*.", "1")
                .replace(".**.", "2")
                .replace(".***.", "3")
                .replace(".****.", "4")
                .replace(".*****.", "5")
                .replace(".******.", "6")
                .replace(".*******.", "7")
                .replace(".********.", "8")
                .replace(".*********.", "9");

        return text;
    }
    private static String reverseString (String text){
        StringBuilder sb = new StringBuilder(text);
        sb.reverse();

        return sb.toString();
    }
}

